package DAO;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import Controller.Controller;
import Entit�.Recensione;

public class RecensioneDAO {
    Controller controller;

    public RecensioneDAO(Controller ctrl) {
	controller = ctrl;
    }

    public float getMediaVotoLocale(String codLocale) {

	float mediaLocale=0.0f;

	try {

	    CallableStatement cst = controller.getConnection().prepareCall("{CALL getMediaVoto(?,?)}");
	    cst.registerOutParameter(2, Types.FLOAT);
	    cst.setString(1, codLocale);
	    cst.execute();

	    mediaLocale = cst.getFloat(2);
	    cst.close();

	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return mediaLocale;
    }

    public ArrayList<Recensione> getAllRecensioniDiLocation(String ID){

	String query = "SELECT * FROM recensione WHERE cod_locale=?";
	ArrayList<Recensione> recensioniLocation = new ArrayList<Recensione>();

	try {
	    PreparedStatement getRecensioni = controller.getConnection().prepareStatement(query);
	    getRecensioni.setString(1, ID);
	    ResultSet rs = getRecensioni.executeQuery();

	    while(rs.next()) {
		Recensione recensioneGet = new Recensione(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
		recensioniLocation.add(recensioneGet);
	    }

	    rs.close();
	    getRecensioni.close();

	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return recensioniLocation;
    }

    public void inserisciRecensione(Recensione recensione) throws SQLException {
    	String query = "Insert into recensione values(?,?,?,?,?)";
    	
    	try {
    		PreparedStatement inserisciRecensione = controller.getConnection().prepareStatement(query);
			inserisciRecensione.setString(1, recensione.getCod());
			inserisciRecensione.setString(2, recensione.getCreatore());
			inserisciRecensione.setInt(3, recensione.getVoto());
			inserisciRecensione.setString(4, recensione.getTitolo());
			inserisciRecensione.setString(5, recensione.getTesto());
			inserisciRecensione.executeUpdate();
			
		} catch (SQLException e) {
			throw e;
		}	
    }
    
    public void rimuoviRecensione(String codLoc,String Username) throws SQLException {
    	String query = "delete from recensione where (cod_locale=? && creatore=?)";
    	
    	try {
    		PreparedStatement rimuoviRecensione = controller.getConnection().prepareStatement(query);
			rimuoviRecensione.setString(1, codLoc);
			rimuoviRecensione.setString(2, Username);
			
			if(rimuoviRecensione.executeUpdate()<1) {
				throw new SQLException();
			}
			
		} catch (SQLException e) {
			throw e;
		}	
    }
    
    public void AggiornaRecensione(Recensione recensione) throws SQLException {
    	String query = "update recensione set voto=?,titolo=?,testo=? where (cod_locale=? && creatore=?)";
    	
    	try {
    		PreparedStatement inserisciRecensione = controller.getConnection().prepareStatement(query);
    		inserisciRecensione.setInt(3, recensione.getVoto());
    		inserisciRecensione.setString(4, recensione.getTitolo());
			inserisciRecensione.setString(5, recensione.getTesto());
			inserisciRecensione.setString(1, recensione.getCod());
			inserisciRecensione.setString(2, recensione.getCreatore());
			
			if(inserisciRecensione.executeUpdate()<1) {
				throw new SQLException();
			}
			
		} catch (SQLException e) {
			throw e;
		}	
    }
}
