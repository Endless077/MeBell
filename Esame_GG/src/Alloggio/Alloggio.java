package Alloggio;

import Entit�.Location;

public class Alloggio extends Location{
	private int prezzoMedio;
	private String tipoAlloggio;
	ServiziAlloggio serviziAlloggio;
	
	public Alloggio() {
		serviziAlloggio = new ServiziAlloggio(); 
	}
}
