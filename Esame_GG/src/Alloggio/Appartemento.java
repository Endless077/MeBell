package Alloggio;

import Entit�.Location;

public class Appartemento extends Alloggio{

    public Appartemento(Alloggio all,int nVani, int nBagni, boolean veranda,boolean cucina) {
	super(all);
	this.n_bagni=nBagni;
	this.n_vani=nVani;
	this.cucina=cucina;
	this.veranda=veranda;
    }

    private int n_vani;
    private int n_bagni;
    private boolean cucina;
    private boolean veranda;

    public int getN_vani() {
	return n_vani;
    }

    public void setN_vani(int n_vani) {
	this.n_vani = n_vani;
    }

    public int getN_bagni() {
	return n_bagni;
    }

    public void setN_bagni(int n_bagni) {
	this.n_bagni = n_bagni;
    }

    public boolean isVeranda() {
	return veranda;
    }

    public void setVeranda(boolean veranda) {
	this.veranda = veranda;
    }

    public boolean isCucina() {
	return cucina;
    }

    public void setCucina(boolean cucina) {
	this.cucina = cucina;
    }

}
