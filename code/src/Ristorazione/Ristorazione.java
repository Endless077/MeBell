package Ristorazione;

import Entita.Location;

public class Ristorazione extends Location{

    private int prezzoMedio;
    private int nPosti;
    private String tipoRistorazione;

    private SushiBar sushiBar; 
    private Pizzeria pizzeria;
    private Braceria braceria;

    public Ristorazione(Location mainLoc, int prezzomedio, int nPosti, String tipoRistorazione) {
	super(mainLoc.getCod(), mainLoc.getNome(), mainLoc.getCod_residenza(), mainLoc.getTipo(), mainLoc.getPartitaIva(), mainLoc.getDescrizione(), mainLoc.getResidenzaLocation(), mainLoc.getRecensiondiLocation());

	this.prezzoMedio=prezzomedio;
	this.nPosti=nPosti;
	this.tipoRistorazione=tipoRistorazione;
    }



    @Override
    public String toString() {

	String StringaReturn="";

	if(this.sushiBar!=null) {
	    String infoSushiBar="Informazioni SushiBar:\nAllYouCanEat: "+this.sushiBar.isAllYouCanEat()+", Tipo sushi: "+this.sushiBar.getTipoSushi()+"\n\n";
	    StringaReturn=StringaReturn+infoSushiBar;
	}
	if(this.pizzeria!=null) {
	    String infoPizzeria="Informazioni Pizzeria:\nAsporto: "+this.pizzeria.isAsporto()+", Tipo Forno: "+this.pizzeria.getTipoForno().replace("Entrambi", "Elettrico e A legna")+"\n\n";
	    StringaReturn=StringaReturn+infoPizzeria;
	}
	if(this.braceria!=null) {
	    String infoBraceria="Informazioni Braceria:\nAsporto: "+this.braceria.isAsporto()+", Serve alcolici artigianali: "+this.braceria.isAlcoliciArtigianali()+", Tipo Carne: "+this.braceria.getTipoCarne().replace("Entrambe", "Italiana e Importata")+"\n\n";
	    StringaReturn=StringaReturn+infoBraceria;
	}


	StringaReturn=StringaReturn.replace("true", "si");
	StringaReturn=StringaReturn.replace("false", "no");

	return StringaReturn;
    }



    public int getPrezzoMedio() {
	return prezzoMedio;
    }
    public void setPrezzoMedio(int prezzoMedio) {
	this.prezzoMedio = prezzoMedio;
    }
    public int getnPosti() {
	return nPosti;
    }
    public void setnPosti(int nPosti) {
	this.nPosti = nPosti;
    }
    public String getTipoRistorazione() {
	return tipoRistorazione;
    }
    public void setTipoRistorazione(String tipoRistorazione) {
	this.tipoRistorazione = tipoRistorazione;
    }
    public SushiBar getSushiBar() {
	return sushiBar;
    }
    public void setSushiBar(SushiBar sushiBar) {
	this.sushiBar = sushiBar;
    }
    public Pizzeria getPizzeria() {
	return pizzeria;
    }
    public void setPizzeria(Pizzeria pizzeria) {
	this.pizzeria = pizzeria;
    }
    public Braceria getBraceria() {
	return braceria;
    }
    public void setBraceria(Braceria braceria) {
	this.braceria = braceria;
    }
}
