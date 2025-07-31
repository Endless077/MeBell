package Connessione;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static Connection connect;

    private DatabaseConnection() {}


    public static Connection Connessione() throws SQLException {

	if(connect==null) {

	    try {

		Class.forName("oracle.jdbc.driver.OracleDriver");

	    }catch(ClassNotFoundException e){

		System.err.println("Errore, driver non trovato.");
		System.out.println(e.getMessage());

	    }
	    String url = "jdbc:oracle:thin:@localhost:1521:xe";
	    String user = "Utente";
	    String Password = "OracleADMIN";

	    try {
		connect = DriverManager.getConnection(url,user,Password);
	    } catch (Exception e) {
		throw(e);
	    }
	}


	return connect;
    }


    public static Connection getConnect() {
	return connect;
    }


    public static void setConnect(Connection connect) {
	DatabaseConnection.connect = connect;
    }


    public static void Disconnessione (){
	if(connect!=null) {
	    try {
		connect.close();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }
}