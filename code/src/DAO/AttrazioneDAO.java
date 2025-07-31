package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Attrazione.Attrazione;
import Controller.Controller;
import Entita.Location;

public class AttrazioneDAO {

    Controller controller;

    public AttrazioneDAO(Controller ctrl) {
	controller=ctrl;
    }

    public Attrazione getAttrazione(String cod, Location mainLoc) throws SQLException {
	String query = "SELECT * FROM attrazione WHERE cod=?";
	Attrazione att=null;

	try {

	    PreparedStatement getAttrazione = controller.getConnection().prepareStatement(query);
	    getAttrazione.setString(1, cod);
	    ResultSet rs = getAttrazione.executeQuery();

	    while(rs.next()) {
		att = new Attrazione(mainLoc,rs.getString(2),rs.getString(3));
	    }

	    rs.close();
	    getAttrazione.close();

	} catch (SQLException e) {
	    throw e;
	}

	return att;
    }

}
