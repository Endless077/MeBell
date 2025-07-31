package DAO;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import Controller.Controller;
import Entita.Recensione;

public class RecensioneDAO {
    Controller controller;

    public RecensioneDAO(Controller ctrl) {
	controller = ctrl;
    }

    public float getMediaVotoLocale(String codLocale) throws SQLException {

	float mediaLocale=0.0f;

	try {

	    CallableStatement cst = controller.getConnection().prepareCall("{CALL getMediaVoto(?,?)}");
	    cst.registerOutParameter(2, Types.FLOAT);
	    cst.setString(1, codLocale);
	    cst.execute();

	    mediaLocale = cst.getFloat(2);
	    cst.close();

	} catch (SQLException e) {
	    throw e;
	}

	return mediaLocale;
    }

    public boolean esisteRecensione(String username, String LocationCOD) throws SQLException {

	String query="SELECT * FROM recensione WHERE creatore=? AND cod_locale=?";

	try {

	    PreparedStatement getRecensione = controller.getConnection().prepareStatement(query);
	    getRecensione.setString(1, username);
	    getRecensione.setString(2, LocationCOD);
	    ResultSet rs = getRecensione.executeQuery();

	    if(!rs.next()) {
		return false;
	    }

	    rs.close();
	    getRecensione.close();

	} catch (SQLException e) {
	    throw e;
	}

	return true;

    }

    public ArrayList<Recensione> getAllRecensioniDiLocation(String codLocale) throws SQLException{

	String query = "SELECT * FROM recensione WHERE cod_locale=? ORDER BY data DESC";
	ArrayList<Recensione> recensioniLocation = new ArrayList<Recensione>();

	try {

	    PreparedStatement getRecensioni = controller.getConnection().prepareStatement(query);
	    getRecensioni.setString(1, codLocale);
	    ResultSet rs = getRecensioni.executeQuery();

	    while(rs.next()) {
		Recensione recensioneGet = new Recensione(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getString(5),rs.getString(6));
		recensioniLocation.add(recensioneGet);
	    }

	    rs.close();
	    getRecensioni.close();

	} catch (SQLException e) {
	    throw e;
	}
	return recensioniLocation;
    }

    public void inserisciRecensione(Recensione recensione) throws SQLException {
	String query = "INSERT INTO recensione(cod_locale,creatore,voto,titolo,testo) VALUES(?,?,?,?,?)";

	try {

	    PreparedStatement inserisciRecensione = controller.getConnection().prepareStatement(query);
	    inserisciRecensione.setString(1, recensione.getCod());
	    inserisciRecensione.setString(2, recensione.getCreatore());
	    inserisciRecensione.setInt(3, recensione.getVoto());
	    inserisciRecensione.setString(4, recensione.getTitolo());
	    inserisciRecensione.setString(5, recensione.getTesto());
	    inserisciRecensione.executeUpdate();

	    inserisciRecensione.close();

	} catch (SQLException e) {
	    throw e;
	}	
    }

    public void rimuoviRecensione(String codLoc, String Username) throws SQLException {
	String query = "DELETE FROM recensione WHERE (cod_locale=? AND creatore=?)";

	try {

	    PreparedStatement rimuoviRecensione = controller.getConnection().prepareStatement(query);
	    rimuoviRecensione.setString(1, codLoc);
	    rimuoviRecensione.setString(2, Username);

	    if(rimuoviRecensione.executeUpdate()<1) {
		throw new SQLException();
	    }

	    rimuoviRecensione.close();

	} catch (SQLException e) {
	    throw e;
	}	
    }

    public void aggiornaRecensione(Recensione recensione)  throws SQLException{
	String query = "UPDATE recensione SET voto=?,titolo=?,testo=?,data=CURRENT_TIMESTAMP WHERE (cod_locale=? AND creatore=?)";

	try {

	    PreparedStatement updateRecensione = controller.getConnection().prepareStatement(query);
	    updateRecensione.setInt(1, recensione.getVoto());
	    updateRecensione.setString(2, recensione.getTitolo());
	    updateRecensione.setString(3, recensione.getTesto());
	    updateRecensione.setString(4, recensione.getCod());
	    updateRecensione.setString(5, recensione.getCreatore());

	    if(updateRecensione.executeUpdate()<1) {
		throw new SQLException();
	    }

	    updateRecensione.close();

	} catch (SQLException e) {
	    throw e;
	}	
    }

    public Recensione getRecensioneUtenteLoggato(String username, String LocationCOD) throws SQLException {
	String query="SELECT * FROM recensione WHERE creatore=? AND cod_locale=?";
	Recensione recensioneUtente = null;

	try {

	    PreparedStatement getRecensione = controller.getConnection().prepareStatement(query);
	    getRecensione.setString(1, username);
	    getRecensione.setString(2, LocationCOD);
	    ResultSet rs = getRecensione.executeQuery();


	    while(rs.next()) {
		recensioneUtente = new Recensione(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getString(5),rs.getString(6));
	    }

	    rs.close();
	    getRecensione.close();

	} catch (SQLException e) {
	    throw e;
	}

	return recensioneUtente;

    }
}
