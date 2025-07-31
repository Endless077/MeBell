package Entita;

import java.time.LocalDate;

public class Recensione {
    private String cod;
    private String creatore;
    private int voto;
    private LocalDate dataRecensione;
    private String titolo;
    private String testo;


    public Recensione(String cod, String creatore, int voto, java.sql.Date date, String titolo, String testo) {

	this.setCod(cod);
	this.setCreatore(creatore);
	this.setVoto(voto);
	this.setTitolo(titolo);
	this.setTesto(testo);

	if(!(date==null))
	    this.dataRecensione=date.toLocalDate();
    }

    public String getCod() {
	return cod;
    }
    public void setCod(String cod) {
	this.cod = cod;
    }
    public String getCreatore() {
	return creatore;
    }
    public void setCreatore(String creatore) {
	this.creatore = creatore;
    }
    public int getVoto() {
	return voto;
    }
    public void setVoto(int voto) {
	this.voto = voto;
    }
    public LocalDate getDataRecensione() {
	return dataRecensione;
    }
    public void setDataRecensione(LocalDate dataRecensione) {
	this.dataRecensione = dataRecensione;
    }
    public String getTitolo() {
	return titolo;
    }
    public void setTitolo(String titolo) {
	this.titolo = titolo;
    }
    public String getTesto() {
	return testo;
    }
    public void setTesto(String testo) {
	this.testo = testo;
    }

}
