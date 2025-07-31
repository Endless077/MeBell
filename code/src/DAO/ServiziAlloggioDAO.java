package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Alloggio.ServiziAlloggio;
import Controller.Controller;
import Entita.Location;

public class ServiziAlloggioDAO {
    Controller controller;

    public ServiziAlloggioDAO(Controller ctrl) {
	controller=ctrl;
    }

    public ServiziAlloggio getAlloggio(String cod, Location mainLoc) throws SQLException {
	String query = "SELECT * FROM servizi_alloggio WHERE cod=?";
	ServiziAlloggio serviziAlloggio=null;

	try {
	    PreparedStatement getAttrazione = controller.getConnection().prepareStatement(query);
	    getAttrazione.setString(1, cod);
	    ResultSet rs = getAttrazione.executeQuery();

	    while(rs.next()) {

		serviziAlloggio = new ServiziAlloggio(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12), rs.getString(13));

	    }

	    rs.close();
	    getAttrazione.close();

	} catch (SQLException e) {
	    throw e;
	}


	return serviziAlloggio;
    }

}
