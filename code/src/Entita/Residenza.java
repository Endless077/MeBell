package Entita;

import java.util.ArrayList;

public class Residenza {

    private String via;
    private String n_civico;
    private String cap;
    private String comune;
    private String cod_res;

    private ArrayList<Location> location_in_res;

    public Residenza(String via, String n_civico, String cap, String comune, String cod_res) {

	this.setVia(via);
	this.setN_civico(n_civico);
	this.setCap(cap);
	this.setComune(comune);
	this.setCod_res(cod_res);

    }


    @Override
    public String toString() {
	return this.via+", "+this.n_civico+", "+this.cap+", "+this.comune;
    }

    public String getVia() {
	return via;
    }

    public void setVia(String via) {
	this.via = via;
    }

    public String getN_civico() {
	return n_civico;
    }

    public void setN_civico(String n_civico) {
	this.n_civico = n_civico;
    }

    public String getCap() {
	return cap;
    }

    public void setCap(String cap) {
	this.cap = cap;
    }

    public String getComune() {
	return comune;
    }

    public void setComune(String comune) {
	this.comune = comune;
    }

    public String getCod_res() {
	return cod_res;
    }

    public void setCod_res(String cod_res) {
	this.cod_res = cod_res;
    }

    public ArrayList<Location> getLocation_in_res() {
	return location_in_res;
    }

    public void setLocation_in_res(ArrayList<Location> location_in_res) {
	this.location_in_res = location_in_res;
    }



}
