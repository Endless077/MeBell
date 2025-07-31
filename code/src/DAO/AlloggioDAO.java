package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Alloggio.Alloggio;
import Alloggio.Appartemento;
import Alloggio.BeB;
import Alloggio.Hotel;
import Controller.Controller;
import Entita.Location;

public class AlloggioDAO {

    Controller controller;

    public AlloggioDAO(Controller ctrl) {
	controller=ctrl;
    }

    public Alloggio getAlloggio(Location mainLoc) throws SQLException {
	String query = "SELECT * FROM alloggio WHERE cod=?";
	Alloggio alloggio=null;

	try {

	    PreparedStatement getAlloggio = controller.getConnection().prepareStatement(query);
	    getAlloggio.setString(1, mainLoc.getCod());
	    ResultSet rs = getAlloggio.executeQuery();

	    while(rs.next()) {
		alloggio = new Alloggio(mainLoc, rs.getInt(2), rs.getString(3));
	    }

	    rs.close();
	    getAlloggio.close();

	} catch (SQLException e) {
	    throw e;
	}

	return alloggio;
    }

    public Hotel getAlloggioHotel(Alloggio alloggio) throws SQLException {
	String query="SELECT * FROM hotel WHERE cod=?";
	Hotel hotel=null;

	try {

	    PreparedStatement getHotel = controller.getConnection().prepareStatement(query);
	    getHotel.setString(1, alloggio.getCod());
	    ResultSet rs = getHotel.executeQuery();

	    while(rs.next()) {
		hotel = new Hotel(alloggio, rs.getInt(2), rs.getInt(3), rs.getInt(4));
	    }

	    rs.close();
	    getHotel.close();

	} catch (SQLException e) {
	    throw e;
	}

	return hotel;

    }

    public BeB getAlloggioBeB(Alloggio alloggio) throws SQLException {
	String query="SELECT * FROM beb WHERE cod=?";
	BeB beb=null;

	try {

	    PreparedStatement getBEB = controller.getConnection().prepareStatement(query);
	    getBEB.setString(1, alloggio.getCod());
	    ResultSet rs = getBEB.executeQuery();

	    while(rs.next()) {
		beb = new BeB(alloggio, rs.getInt(2), rs.getInt(3), rs.getString(4));
	    }

	    rs.close();
	    getBEB.close();

	} catch (SQLException e) {
	    throw e;
	}

	return beb;

    }

    public Appartemento getAlloggioAppartamento(Alloggio alloggio) throws SQLException {
	String query="SELECT * FROM appartamento WHERE cod=?";
	Appartemento appartamento=null;

	try {

	    PreparedStatement getAppartamento = controller.getConnection().prepareStatement(query);
	    getAppartamento.setString(1, alloggio.getCod());
	    ResultSet rs = getAppartamento.executeQuery();

	    while(rs.next()) {
		appartamento = new Appartemento(alloggio,rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5));
	    }

	    rs.close();
	    getAppartamento.close();

	} catch (SQLException e) {
	    throw e;
	}

	return appartamento;

    }
}
