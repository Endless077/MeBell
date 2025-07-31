package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Controller.Controller;
import Entita.Utente;
import Exception.LoginExeption;


public class UtenteDAO {
    Controller controller;

    public UtenteDAO(Controller ctrl) {
	controller = ctrl;
    }

    public void inserisciUtente(Utente utente) throws SQLException {

	String query ="INSERT into utente values(?,?,?,?)";

	try {

	    PreparedStatement inserisciUtente = controller.getConnection().prepareStatement(query);
	    inserisciUtente.setString(1, utente.getUsername());
	    inserisciUtente.setString(2, utente.getNome());
	    inserisciUtente.setString(3, utente.getCognome());
	    inserisciUtente.setString(4, utente.getPassword());
	    inserisciUtente.executeUpdate();

	    inserisciUtente.close();

	} catch (SQLException e) {
	    throw(e);
	}
    }

    public Utente trovaUtente(String user, String pass) throws LoginExeption, SQLException {

	String query = "SELECT * FROM utente WHERE (username = ? AND password = ?)";

	try {

	    PreparedStatement inserisciUtente = controller.getConnection().prepareStatement(query);
	    inserisciUtente.setString(1, user);
	    inserisciUtente.setString(2, pass);
	    ResultSet rs = inserisciUtente.executeQuery();

	    Utente usr=null;

	    while(rs.next()) {
		usr = new Utente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
	    }

	    rs.close();
	    inserisciUtente.close();

	    if(usr==null) {
		throw new LoginExeption();
	    } else {
		return usr;
	    }

	} catch (SQLException e) {
	    throw (e);
	}

    }

}