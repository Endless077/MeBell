package Alloggio;

import Entit�.Location;

public class Hotel extends Alloggio{

    private int nCamere;
    private int nSuite;
    private int stelle;

    public Hotel(Alloggio all,int Ncamere,int Nsuite, int stelle) {
	super(all);
	this.nCamere=Ncamere;
	this.nSuite=Nsuite;
	this.stelle=stelle;
    }

    public int getnCamere() {
	return nCamere;
    }
    public void setnCamere(int nCamere) {
	this.nCamere = nCamere;
    }
    public int getNsuite() {
	return nSuite;
    }
    public void setNsuite(int nsuite) {
	nSuite = nsuite;
    }
    public int getStelle() {
	return stelle;
    }
    public void setStelle(int stelle) {
	this.stelle = stelle;
    }
}
