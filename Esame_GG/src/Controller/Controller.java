package Controller;

import java.awt.Image;
import java.sql.Connection;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Connessione.DatabaseConnection;
import DAO.UtenteDAO;
import Entit�.*;
import Swing.HomePage;
import Swing.Login;
import Swing.Register;

public class Controller {
	Login login;
	Register register;
	HomePage homepage;
	
	DefaultTableModel model;
	   
	private Utente utente=null;
	private ArrayList<Location> location;

	public static void main(String[] args) {
		
	    Controller ctrl = new Controller();
	    
	}
	
	public Controller() {
	  
	  login = new Login(this);
	  login.setVisible(true);
	  register = new Register(this);
	  homepage = new HomePage(this);
	  
	  location = new ArrayList<Location>();
	    
	}
	
//-------------------------------------------------------------------------------------------------


	public void aggiungiUtente(String first, String last, String user, String pass) {
		Utente utente = new Utente(first,last,user,pass);
		UtenteDAO utenteDAO = new UtenteDAO(this);
		try {
			utenteDAO.inserisciUtente(utente);
			JOptionPane.showMessageDialog(null, "Registrazione effettuata con successo");
			
		} catch (SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Il nome utente risulta gi� registrato", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Errore con il database", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void loginTry(String user, String pass) {
		UtenteDAO stdDAO = new UtenteDAO(this);
		utente = stdDAO.trovaUtente(user);
		if (utente!=null && utente.getPassword().equals(pass)) {
		    	JOptionPane.showMessageDialog(null, "Login effettuato, ciao"+" "+this.utente.getUsername(), "Esito login", JOptionPane.INFORMATION_MESSAGE);	
			login.setVisible(false);
			homepage.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "Username o password errate", "Errore", JOptionPane.ERROR_MESSAGE);
			utente=null;
		}
	}
	
	public boolean isPassEqual(char[] password, char[] password2) {
		String psw = new String(password);
		String psw2 = new String(password2);
		if(psw.equals(psw2) && psw!="") {
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
	
	  public void insertLocationInTable(DefaultTableModel modello) {
		
		modello.getDataVector().removeAllElements();
		
		Icon Icona = new ImageIcon(getClass().getResource("/Icons/UserICON.png"));
		JLabel labelIMG = new JLabel();
		labelIMG.setIcon(Icona);
		
		modello.addRow(new Object[] {labelIMG});
		   
		modello.fireTableDataChanged();

	    }
	
//Get connessione
	public Connection getConnection() {
	    
	    try {

		if(DatabaseConnection.getConnect()==null) {
		    return DatabaseConnection.Connessione();
		}else {
		    return DatabaseConnection.getConnect();
		}

	    } catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "Connessione non riuscita. Controllare il collegamento", "Errore SQL", JOptionPane.ERROR_MESSAGE);
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
	
//Getter e setter TableModel

	public void setModel(DefaultTableModel modello) {
	    this.model=modello;

	}

	public DefaultTableModel getModel() {

	    return this.model;
		
	    }
	
//Open frame
	
	public void openRegister() {
	        register.setVisible(true);
	    }
	
	public void openLogin() {
	        login.setVisible(true);
	    }
	public void openHomePage() {
	    	homepage.setVisible(true);
	    }
	
	
}