package Controller;

import java.awt.Color;
import java.awt.TextArea;
import java.sql.Connection;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Alloggio.*;
import Attrazione.Attrazione;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Connessione.DatabaseConnection;
import DAO.*;
import Entita.*;
import Swing.HomePage;
import Swing.LocationPage;
import Exception.LoginExeption;
import Ristorazione.*;
import Swing.Login;
import Swing.Register;
import Swing.VediRecensioni;
import SwingDialog.*;
import Utility.ModelloTabella;


public class Controller {
    Login login;
    Register register;
    HomePage homepage;
    LocationPage locationpage;
    VediRecensioni vedirecensioni;

    EliminaRecensione eliminarecensione;
    ModificaRecensione modificarecensione;
    InserisciRecensione inseriscirecensione;

    private Utente utente;
    private String IDlocationScelta;
    private Location locationDaVedere;
    private int filtroMediaVoto;
    private ArrayList<Location> location;	
    private ArrayList<Residenza> residenze;

    public static void main(String[] args) {
	Controller ctrl = new Controller();
    }

    public Controller() {

	login = new Login(this);

	login.setLocationRelativeTo(null);
	login.setVisible(true);

	register = new Register(this);
	homepage = new HomePage(this);
	locationpage = new LocationPage(this);
	vedirecensioni = new VediRecensioni(this);

	eliminarecensione = new EliminaRecensione(this);
	modificarecensione = new ModificaRecensione(this);
	inseriscirecensione = new InserisciRecensione(this);

	location = new ArrayList<Location>();

    }

    //-------------------------------------------------------------------------------------------------

    //	 LOGIN & REGISTRAZIONE

    public void aggiungiUtente(String user, String first, String last, String pass) {
	Utente utente = new Utente(user,first,last,pass);
	UtenteDAO utenteDAO = new UtenteDAO(this);

	try {
	    utenteDAO.inserisciUtente(utente);
	    JOptionPane.showMessageDialog(null, "Registrazione avvenuta con successo", "Esito registrazione", JOptionPane.INFORMATION_MESSAGE);

	} catch (SQLIntegrityConstraintViolationException e) {
	    JOptionPane.showMessageDialog(null, "Il nome utente risulta già registrato", "Error", JOptionPane.ERROR_MESSAGE);

	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, "Errore con il database", "Error", JOptionPane.ERROR_MESSAGE);
	}
    }

    public void loginTry(String user, String pass) {
	UtenteDAO stdDAO = new UtenteDAO(this);

	try {
	    utente = stdDAO.trovaUtente(user,pass);
	    JOptionPane.showMessageDialog(null, "Login effettuato, ciao"+" "+this.utente.getUsername(), "Esito login", JOptionPane.INFORMATION_MESSAGE);	

	    this.setDynamicLabelEliminaRecensione();

	    login.setVisible(false);
	    homepage.setVisible(true);
	    getFilterLocation("Tutti", "Tutti", "", 0);
	    aggiornaTable(homepage.getModel());

	} catch (LoginExeption e) {
	    JOptionPane.showMessageDialog(null, "Username o password errate", "Errore", JOptionPane.ERROR_MESSAGE);
	    utente=null;

	}catch (SQLException e) {
	    stampaErroreDB();
	    utente=null;

	}
    }

    public boolean isPassEqual(char[] password, char[] password2) {
	String psw = new String(password);
	String psw2 = new String(password2);

	if(psw.equals(psw2)) {
	    return true;
	}

	return false;
    }

    public boolean controlloPass(JPasswordField passField) {

	String password = new String(passField.getPassword());
	Pattern path = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,15})");
	Matcher m = path.matcher(password);
	boolean controllo = m.matches();
	return controllo;
    }

    public boolean controlloUsername(JTextField utenteField) {

	String Username = utenteField.getText();
	Pattern path = Pattern.compile("^[a-zA-Z0-9_-]{3,15}$");
	Matcher m = path.matcher(Username);
	boolean controllo = m.matches();
	return controllo;
    }

    //-------------------------------------------------------------------------------------------------

    public void getFilterLocation(String tipologia, String comune, String nome, int mediaVoto) {

	LocationDAO locDAO = new LocationDAO(this);
	ResidenzaDAO resDAO = new ResidenzaDAO(this);

	this.filtroMediaVoto=mediaVoto;

	try {
	    this.residenze=resDAO.getResidenze(comune);
	    this.location=locDAO.getLocations(tipologia, comune, nome);

	} catch (SQLException e) {
	    stampaErroreDB();
	}
    }

    public void aggiornaTable(DefaultTableModel modello) {

	int filtro = this.filtroMediaVoto;
	float media = 0.0f;

	RecensioneDAO recDAO = new RecensioneDAO(this);
	modello.getDataVector().removeAllElements();

	try {
	    for(Location l : location) { 

		for(Residenza r : residenze) {

		    if(l.getCod_residenza().equals(r.getCod_res())) {

			media=recDAO.getMediaVotoLocale(l.getCod());

			if(media>=filtro) {

			    media = (float) (Math.floor(media * 100) / 100);

			    if(l.getTipo().equals("Alloggio")) {
				Icon Icona = new ImageIcon(getClass().getResource("/Icons/HotelICON.png"));
				JLabel labelIMG = new JLabel();
				labelIMG.setIcon(Icona);

				modello.addRow(new Object[] {labelIMG,l.getCod(),l.getNome(),r.getVia(),r.getComune(),media});

			    }else if(l.getTipo().equals("Attrazione")) {
				Icon Icona = new ImageIcon(getClass().getResource("/Icons/AttrazioneICON.png"));
				JLabel labelIMG = new JLabel();
				labelIMG.setIcon(Icona);

				modello.addRow(new Object[] {labelIMG,l.getCod(),l.getNome(),r.getVia(),r.getComune(),media});

			    }else if(l.getTipo().equals("Ristorante")) {
				Icon Icona = new ImageIcon(getClass().getResource("/Icons/RestaurantICON.png"));
				JLabel labelIMG = new JLabel();
				labelIMG.setIcon(Icona);

				modello.addRow(new Object[] {labelIMG,l.getCod(),l.getNome(),r.getVia(),r.getComune(),media});
			    }
			}
		    }
		}
	    }
	    modello.fireTableDataChanged();

	} catch (SQLException e) {
	    stampaErroreDB();
	}
    }

    public void riempiTabellaRecensioni() {
	ModelloTabella model = vedirecensioni.getModel();
	model.getDataVector().removeAllElements();

	for(Recensione r : this.locationDaVedere.getRecensiondiLocation()) {
	    model.addRow(new Object[] {r.getCreatore(), r.getDataRecensione(), r.getTitolo(), r.getVoto()});
	}

	model.fireTableDataChanged();
	vedirecensioni.setModel(model);
    }

    public void filtraRecensioni(ModelloTabella model, int votoFiltro, String timeFilter) {
	model.getDataVector().removeAllElements();
	ArrayList<Recensione> recensioniFiltrate = new ArrayList<Recensione>();

	if(votoFiltro==0) {
	    recensioniFiltrate=locationDaVedere.getRecensiondiLocation();
	}else {
	    for(Recensione r : locationDaVedere.getRecensiondiLocation()) {
		if(r.getVoto()==votoFiltro) {
		    recensioniFiltrate.add(r);
		}
	    }
	}

	if(timeFilter.equals("Dalla più recente")) {

	    for(Recensione r : recensioniFiltrate) {
		model.addRow(new Object[] {r.getCreatore(), r.getDataRecensione(), r.getTitolo(), r.getVoto()});
	    }

	}else {

	    int lunghezza = recensioniFiltrate.size()-1;
	    Recensione r;

	    for(int l= lunghezza;l>=0; l--) {
		r=recensioniFiltrate.get(l);
		model.addRow(new Object[] {r.getCreatore(), r.getDataRecensione(), r.getTitolo(), r.getVoto()});
	    }
	}

	model.fireTableDataChanged();
    }

    public boolean getLocationFromTable(JTable tabella) {

	String cod_locale;
	int rowSelected;

	if(!tabella.getSelectionModel().isSelectionEmpty()) {
	    rowSelected=tabella.getSelectedRow();
	    cod_locale=(String) tabella.getValueAt(rowSelected, 1);
	    this.setLocationScelta(cod_locale);
	    this.homepage.setVisible(false);
	    this.openLocationPage();
	    return true;

	}else {
	    JOptionPane.showMessageDialog(null, "Selzeziona una riga", "Error", JOptionPane.ERROR_MESSAGE);
	    return false;
	}
    }

    public void getTestoRecensioneDaTable(JTable table) {
	String username;
	int rowSelected;

	if(!table.getSelectionModel().isSelectionEmpty()) {
	    rowSelected = table.getSelectedRow();
	    username=(String) table.getValueAt(rowSelected, 0);
	    RecensioneDAO recDao =new RecensioneDAO(this);
	    Recensione recensionePresa;

	    try {
		recensionePresa = recDao.getRecensioneUtenteLoggato(username, locationDaVedere.getCod());
		vedirecensioni.setTextAreaRecensione(recensionePresa.getTesto());

	    } catch (SQLException e) {
		stampaErroreDB();
	    }

	}
    }

    public ArrayList<String> getComuni() {
	ResidenzaDAO resDAO = new ResidenzaDAO(this);

	try {
	    return resDAO.getAllComuni();

	} catch (SQLException e) {
	    stampaErroreDB();
	    return null;
	}
    }

    public void getLocationInformation() {
	LocationDAO locDAO = new LocationDAO(this);
	ResidenzaDAO resDAO = new ResidenzaDAO(this);
	RecensioneDAO recDAO = new RecensioneDAO(this);

	try {
	    this.locationDaVedere=locDAO.getLocationFromID(IDlocationScelta);
	    this.locationDaVedere.setResidenzaLocation(resDAO.getResidenzaFromID(this.locationDaVedere.getCod_residenza()));
	    this.locationDaVedere.setRecensiondiLocation(recDAO.getAllRecensioniDiLocation(IDlocationScelta));

	} catch (SQLException e) {
	    stampaErroreDB();
	}

    }

    public float getMediaRecensioni() {
	int i = 0;
	float media = 0.0f;

	if(!this.locationDaVedere.getRecensiondiLocation().isEmpty()){

	    for(Recensione r : this.locationDaVedere.getRecensiondiLocation()) {
		i++;
		media=media+r.getVoto();	    
	    }

	    media=media/i;
	}
	return media;
    }

    public void aggiornaLocationPage(){

	if(this.locationDaVedere.getTipo().equals("Alloggio")) {

	    this.setAlloggioLabel();

	}else if(this.locationDaVedere.getTipo().equals("Attrazione")) {

	    this.setAttrazioneInLabel();

	}else if(this.locationDaVedere.getTipo().equals("Ristorante")) {

	    this.setRistorazioneInLabel();

	}

    }

    private void setAlloggioLabel() {

	AlloggioDAO allDAO = new AlloggioDAO(this);
	ServiziAlloggioDAO serviziAll = new ServiziAlloggioDAO(this);
	Alloggio all;

	try {
	    all = allDAO.getAlloggio(this.locationDaVedere);
	    ServiziAlloggio serviziAlloggio = serviziAll.getAlloggio(this.IDlocationScelta, this.locationDaVedere);
	    all.setServiziAlloggio(serviziAlloggio);

	    Object alloggioSpecializzato = this.getAlloggiosSpecializzato(all, allDAO);

	    locationpage.setLocationPage(all.getNome(), all.getTipo()+", "+all.getTipoAlloggio(), all.getResidenzaLocation().toString(), all.getPartitaIva(), this.getMediaRecensioni(), all.getDescrizione(), alloggioSpecializzato.toString(), all.getServiziAlloggio().toString());

	} catch (SQLException e) {
	    stampaErroreDB();
	}

    }


    private void setAttrazioneInLabel() {

	AttrazioneDAO attDAO = new AttrazioneDAO(this);
	Attrazione att;

	try {
	    att = attDAO.getAttrazione(this.IDlocationScelta, this.locationDaVedere);

	    String pagamento;
	    if(att.isPagamento()) {
		pagamento="L'attrazione è a pagamento.";
	    }else {
		pagamento="L'attrazione non è a pagamento.";
	    }
	    locationpage.setLocationPage(att.getNome(), att.getTipo()+", "+att.getTipoAttrazione(), att.getResidenzaLocation().toString(), att.getPartitaIva(), this.getMediaRecensioni(), att.getDescrizione(), pagamento, "Nessun servizio");

	} catch (SQLException e) {
	    stampaErroreDB();
	}

    }

    private void setRistorazioneInLabel() {

	RistorazioneDAO ristDAO = new RistorazioneDAO(this);
	Ristorazione rist;

	try {
	    rist = ristDAO.getRistorazione(locationDaVedere);
	    this.setAttributiTipoRistorazione(rist, ristDAO);

	    String informazioni="Informazioni: \nNumero posti: "+rist.getnPosti()+", Prezzo medio:"+rist.getPrezzoMedio();
	    locationpage.setLocationPage(rist.getNome(), rist.getTipo()+", "+rist.getTipoRistorazione().replace("Elenco completo", "Braceria, Pizzeria, Sushi Bar"), rist.getResidenzaLocation().toString(), rist.getPartitaIva(), this.getMediaRecensioni(), rist.getDescrizione(),informazioni , rist.toString());

	} catch (SQLException e) {
	    stampaErroreDB();
	}

    }

    public void setAttributiTipoRistorazione(Ristorazione ristorante, RistorazioneDAO ristoranteDaSpecificare) {

	Braceria brace;

	try {
	    brace = ristoranteDaSpecificare.getBraceria(ristorante);
	    Pizzeria pizza = ristoranteDaSpecificare.getPizzeria(ristorante);
	    SushiBar sushibar = ristoranteDaSpecificare.getSushiBar(ristorante);

	    ristorante.setBraceria(brace);
	    ristorante.setPizzeria(pizza);
	    ristorante.setSushiBar(sushibar);

	} catch (SQLException e) {
	    stampaErroreDB();
	}


    }

    public Object getAlloggiosSpecializzato(Alloggio alloggioScelto, AlloggioDAO alloggioDaSpecificare) {

	Object tipoAlloggio = null;

	try {
	    if(alloggioScelto.getTipoAlloggio().equals("Hotel")) {
		tipoAlloggio=alloggioDaSpecificare.getAlloggioHotel(alloggioScelto);

	    }else if(alloggioScelto.getTipoAlloggio().equals("BeB")) {
		tipoAlloggio=alloggioDaSpecificare.getAlloggioBeB(alloggioScelto);

	    }else if(alloggioScelto.getTipoAlloggio().equals("Appartamento")) {
		tipoAlloggio=alloggioDaSpecificare.getAlloggioAppartamento(alloggioScelto);
	    }

	} catch (Exception e) {
	    stampaErroreDB();
	}
	return tipoAlloggio;

    }

    //-------------------------------------------------------------------------------------------------

    public boolean controlloSeHaRecensioni() {

	RecensioneDAO recDAO = new RecensioneDAO(this);
	boolean controllo = false;

	try {
	    controllo = recDAO.esisteRecensione(utente.getUsername(), locationDaVedere.getCod());

	} catch (SQLException e) {
	    stampaErroreDB();
	}

	return controllo;
    }

    public void visualizzaOldRecensioneInDialog() {

	RecensioneDAO recDAO = new RecensioneDAO(this);
	Recensione recensioneUtenteLoggato;

	try {
	    recensioneUtenteLoggato = recDAO.getRecensioneUtenteLoggato(utente.getUsername(), locationDaVedere.getCod());
	    modificarecensione.setOldReview(recensioneUtenteLoggato.getTitolo(), recensioneUtenteLoggato.getTesto(), recensioneUtenteLoggato.getVoto());

	} catch (SQLException e) {
	    stampaErroreDB();
	}


    }

    public void inserisciRecensione(JTextField titolo, JTextArea testo, int voto){
	String getTitolo = titolo.getText();
	String getTesto = testo.getText();

	Recensione recensioneNuova = new Recensione(locationDaVedere.getCod(), utente.getUsername(), voto, null, getTitolo, getTesto);
	RecensioneDAO recDAO = new RecensioneDAO(this);

	try {
	    recDAO.inserisciRecensione(recensioneNuova);

	} catch (SQLException e) {
	    JOptionPane.showMessageDialog(null, "Errore durante l'inserimento", "Error", JOptionPane.ERROR_MESSAGE);
	    e.printStackTrace();
	}

    }

    public void modificaRecensione(JTextField titolo, JTextArea testo, int voto) {
	String getTitolo = titolo.getText();
	String getTesto = testo.getText();

	Recensione recensioneNuova = new Recensione(locationDaVedere.getCod(), utente.getUsername(), voto, null, getTitolo, getTesto);
	RecensioneDAO recDAO = new RecensioneDAO(this);

	try {
	    recDAO.aggiornaRecensione(recensioneNuova);

	} catch (SQLException e) {
	    JOptionPane.showMessageDialog(null, "Errore durante la modifica", "Error", JOptionPane.ERROR_MESSAGE);
	    e.printStackTrace();
	}

    }

    public void eliminaRecensione() {
	RecensioneDAO recDAO = new RecensioneDAO(this);

	try {
	    recDAO.rimuoviRecensione(locationDaVedere.getCod(), utente.getUsername());

	} catch (SQLException e) {
	    JOptionPane.showMessageDialog(null, "Errore durante la cancellazione", "Error", JOptionPane.ERROR_MESSAGE);
	    e.printStackTrace();
	}

    }

    //-------------------------------------------------------------------------------------------------

    //Get connessione
    public Connection getConnection() {

	try {
	    if(DatabaseConnection.getConnect()==null) {
		return DatabaseConnection.Connessione();
	    } else {
		return DatabaseConnection.getConnect();
	    }

	} catch (SQLException e) {
	    JOptionPane.showMessageDialog(null, "Connessione non riuscita, controllare il collegamento\nSe il problema persiste contattare gli amministratori", "Errore SQL", JOptionPane.ERROR_MESSAGE);
	    return null;
	}	
    }

    //Getter e setter utente loggato
    public Utente getUtente() {
	return utente;
    }

    public void setUtente(Utente utente) {
	this.utente = utente;
    }

    //Getter e setter location scelta
    public String getLocationScelta() {
	return IDlocationScelta;
    }

    public void setLocationScelta(String locationScelta) {
	this.IDlocationScelta = locationScelta;
    }

    //Getter e setter filtro media voto
    public int getFiltroMediaVoto() {
	return filtroMediaVoto;
    }

    public void setFiltroMediaVoto(int filtroMediaVoto) {
	this.filtroMediaVoto = filtroMediaVoto;
    }

    //Getter e setter location da vedere
    public Location getLocationDaVedere() {
	return locationDaVedere;
    }

    public void setLocationDaVedere(Location locationDaVedere) {
	this.locationDaVedere = locationDaVedere;
    }


    //Utility
    public void resetCampiReg(JTextField textFirstN, JTextField textLastN, JTextField textUserN, JPasswordField passwordField, JPasswordField passwordFieldR) {

	textFirstN.setText("");
	textLastN.setText("");
	textUserN.setText("");
	passwordField.setText("");
	passwordFieldR.setText("");

    }

    public void resetControlliReg(boolean controlloUsername, boolean controlloPassword, JLabel controlloUser, JLabel  controlloPass) {

	controlloUsername=false;
	controlloPassword=false;

	controlloUser.setForeground(Color.BLACK);
	controlloUser.setText("Il campo conterrà una lunghezza da 3 a 15 char alfanumerici.");

	controlloPass.setForeground(Color.BLACK);
	controlloPass.setText("Il campo conterrà A-Z, a-z, 0-9 e almeno un @#$%.");

    }

    public void resetCampiInsertModify(JTextArea testo, JTextField titolo, JLabel titoloCount, JLabel testoCount, boolean controlloTitolo, boolean controlloTesto){

	controlloTitolo=false;
	controlloTesto=false;

	testoCount.setText("Testo: 0/25");
	testoCount.setForeground(Color.BLACK);
	titoloCount.setText("Titolo: 0/250");
	titoloCount.setForeground(Color.BLACK);

	testo.setText("");
	titolo.setText("");

    }

    public void resetFiltroRec(JButton star1, JButton star2, JButton star3, JButton star4, JButton star5) {

	star1.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));
	star2.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));
	star3.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));
	star4.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));
	star5.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));

    }

    public void resetFiltroHomepage(JComboBox comboBox_FiltroTipologia, JComboBox comboBox_FiltroComune, JTextField textNomeLocale) {

	comboBox_FiltroTipologia.setSelectedIndex(0);
	comboBox_FiltroComune.setSelectedIndex(0);
	textNomeLocale.setText("");
	homepage.setFiltro_media_voto(0);

    }

    public void resettaCampiVediRecensioni(int media, JTextArea textAreaRecensione, JComboBox comboBoxTimeFilter ) {

	media=0;
	vedirecensioni.setFiltro_media_voto(0);;
	textAreaRecensione.setText("");
	comboBoxTimeFilter.setSelectedIndex(0);

    }

    public void setCellNotEditable(JTable tabella, ModelloTabella modello) {

	int indice_riga;
	int indice_colonna;

	indice_riga=tabella.getSelectedRow();
	indice_colonna=tabella.getSelectedColumn();
	modello.isCellEditable(indice_riga, indice_colonna);

    }

    public void setImgLocation() {

	String pathICON = "/LocationIMG/"+this.IDlocationScelta+".png";

	Icon Icona = new ImageIcon(getClass().getResource(pathICON));

	locationpage.setLabelImmagineLocation(Icona);
    }

    public int conteggioChar(String stringaDaContare) {

	int conteggio=0;
	conteggio=stringaDaContare.length();

	return conteggio;	
    }

    public boolean controlloTitoloRecensione(String titolo) {

	if(titolo.length()<25 && titolo.length()>3) {
	    return true;
	}else {
	    return false;
	}

    }

    public boolean controlloTestoRecensione(String testo) {

	if(testo.length()<250) {
	    return true;
	}else {
	    return false;
	}
    }

    private void setDynamicLabelEliminaRecensione() {
	homepage.setLblLoggatoCome(utente.getUsername());
	eliminarecensione.setLblAvvertenza("<html>Ehi ciao "+utente.getUsername()+", <br/> stai per eliminare la recensione alla location "+"<br/> vuoi procedere?");
    }

    private void stampaErroreDB() {
	JOptionPane.showMessageDialog(null, "Errore generico con il database.\nRiprovare o contattare gli amministratori", "Errore", JOptionPane.ERROR_MESSAGE);
    }

    public void updateSistema() {
	this.getLocationInformation();
	this.aggiornaLocationPage();
	this.riempiTabellaRecensioni();
	this.aggiornaTable(homepage.getModel());
    }

    public void logOut() {
	this.IDlocationScelta=null;
	this.locationDaVedere=null;
	this.filtroMediaVoto=0;
	this.location.clear();
	this.residenze.clear();
	this.utente=null;
	login.setVisible(true);
    }

    //Open frame

    public void openRegister() {
	register.setLocationRelativeTo(null);
	register.setVisible(true);
    }
    public void openLogin() {
	login.setLocationRelativeTo(null);
	login.setVisible(true);
    }
    public void openHomePage() {
	homepage.setLocationRelativeTo(null);
	homepage.setVisible(true);
    }
    public void openLocationPage() {
	locationpage.setLocationRelativeTo(null);
	locationpage.setVisible(true);
    }
    public void openVediRecensioni() {
	vedirecensioni.setLocationRelativeTo(null);
	vedirecensioni.setVisible(true);
    }
    public void openEliminaDialog() {
	eliminarecensione.setLblAvvertenza("<html>Ehi ciao, "+utente.getUsername()+"<br/> stai per eliminare la recensione alla location "+locationDaVedere.getNome()+"<br/> vuoi procedere?");
	eliminarecensione.setLocationRelativeTo(null);
	eliminarecensione.setVisible(true);
    }
    public void openModificaDialog() {
	modificarecensione.setLocationRelativeTo(null);
	modificarecensione.setVisible(true);
    }
    public void openInserisciDialog() {
	inseriscirecensione.setLocationRelativeTo(null);
	inseriscirecensione.setVisible(true);
    }

}