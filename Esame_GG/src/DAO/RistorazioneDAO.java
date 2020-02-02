package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Alloggio.Alloggio;
import Alloggio.Appartemento;
import Alloggio.BeB;
import Alloggio.Hotel;
import Controller.Controller;
import Entit�.Location;
import Ristorazione.Braceria;
import Ristorazione.Pizzeria;
import Ristorazione.Ristorazione;
import Ristorazione.SushiBar;

public class RistorazioneDAO{
	Controller controller;

    public RistorazioneDAO(Controller ctrl) {
	controller=ctrl;
    }

    public Ristorazione getRistorazione(Location mainLoc) {
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
    	    e.printStackTrace();
    	}

    return ristorazione;
    }
    
    
    //--------------------------------------------
    
    public Braceria getBraceria(Ristorazione ristorazione) {
	String query="SELECT * FROM braceria WHERE cod=?";
	Braceria braceria=null;

	try {
	    PreparedStatement getBraceria = controller.getConnection().prepareStatement(query);
	    getBraceria.setString(1, ristorazione.getCod());
	    ResultSet rs = getBraceria.executeQuery();

	    while(rs.next()) {
	    	braceria = new Braceria();
	    }

	    rs.close();
	    getBraceria.close();

	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return braceria;

    }
    
    public SushiBar getSushiBar(Ristorazione ristorazione) {
	String query="SELECT * FROM sushibar WHERE cod=?";
	SushiBar sushiBar=null;

	try {
	    PreparedStatement getSushiBar = controller.getConnection().prepareStatement(query);
	    getSushiBar.setString(1, ristorazione.getCod());
	    ResultSet rs = getSushiBar.executeQuery();

	    while(rs.next()) {
	    	sushiBar = new SushiBar();
	    }

	    rs.close();
	    getSushiBar.close();

	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return sushiBar;

    }
    
    public Pizzeria getPizzeria(Ristorazione ristorazione) {
	String query="SELECT * FROM pizzeria WHERE cod=?";
	Pizzeria pizzeria=null;

	try {
	    PreparedStatement getPizzeria = controller.getConnection().prepareStatement(query);
	    getPizzeria.setString(1, ristorazione.getCod());
	    ResultSet rs = getPizzeria.executeQuery();

	    while(rs.next()) {
	    	pizzeria = new Pizzeria();
	    }

	    rs.close();
	    getPizzeria.close();

	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return pizzeria;

    }
}
    
