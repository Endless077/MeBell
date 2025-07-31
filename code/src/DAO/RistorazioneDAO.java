package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Controller.Controller;
import Entita.Location;
import Ristorazione.Braceria;
import Ristorazione.Pizzeria;
import Ristorazione.Ristorazione;
import Ristorazione.SushiBar;

public class RistorazioneDAO{
    Controller controller;

    public RistorazioneDAO(Controller ctrl) {
	controller=ctrl;
    }

    public Ristorazione getRistorazione(Location mainLoc) throws SQLException {
	String query = "SELECT * FROM ristorazione WHERE cod=?";
	Ristorazione ristorazione=null;

	try {

	    PreparedStatement getRistorazione = controller.getConnection().prepareStatement(query);
	    getRistorazione.setString(1, mainLoc.getCod());
	    ResultSet rs = getRistorazione.executeQuery();

	    while(rs.next()) {
		ristorazione = new Ristorazione(mainLoc, rs.getInt(2), rs.getInt(3), rs.getString(4));
	    }

	    rs.close();
	    getRistorazione.close();

	} catch (SQLException e) {
	    throw e;
	}

	return ristorazione;
    }


    public Braceria getBraceria(Ristorazione ristorazione) throws SQLException {
	String query="SELECT * FROM braceria WHERE cod=?";
	Braceria braceria=null;

	try {

	    PreparedStatement getBraceria = controller.getConnection().prepareStatement(query);
	    getBraceria.setString(1, ristorazione.getCod());
	    ResultSet rs = getBraceria.executeQuery();

	    while(rs.next()) {
		braceria = new Braceria(rs.getString(2), rs.getString(3),rs.getString(4));
	    }

	    rs.close();
	    getBraceria.close();

	} catch (SQLException e) {
	    throw e;
	}
	return braceria;
    }

    public SushiBar getSushiBar(Ristorazione ristorazione) throws SQLException {
	String query="SELECT * FROM sushibar WHERE cod=?";
	SushiBar sushiBar=null;

	try {

	    PreparedStatement getSushiBar = controller.getConnection().prepareStatement(query);
	    getSushiBar.setString(1, ristorazione.getCod());
	    ResultSet rs = getSushiBar.executeQuery();

	    while(rs.next()) {
		sushiBar = new SushiBar(rs.getString(2), rs.getString(3));
	    }

	    rs.close();
	    getSushiBar.close();

	} catch (SQLException e) {
	    throw e;
	}
	return sushiBar;

    }

    public Pizzeria getPizzeria(Ristorazione ristorazione) throws SQLException {
	String query="SELECT * FROM pizzeria WHERE cod=?";
	Pizzeria pizzeria=null;

	try {

	    PreparedStatement getPizzeria = controller.getConnection().prepareStatement(query);
	    getPizzeria.setString(1, ristorazione.getCod());
	    ResultSet rs = getPizzeria.executeQuery();

	    while(rs.next()) {
		pizzeria = new Pizzeria(rs.getString(2), rs.getString(3));
	    }

	    rs.close();
	    getPizzeria.close();

	} catch (SQLException e) {
	    throw e;
	}
	return pizzeria;

    }

}


