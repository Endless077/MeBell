package Ristorazione;

public class Pizzeria {

    private boolean asporto;
    private String tipoForno;


    public Pizzeria(String asporto, String tipoForno) {

	if(asporto.equals("si")) {
	    this.asporto=true;
	}else {
	    this.asporto=false;
	}

	this.tipoForno=tipoForno;

    }

    public boolean isAsporto() {
	return asporto;
    }
    public void setAsporto(boolean asporto) {
	this.asporto = asporto;
    }
    public String getTipoForno() {
	return tipoForno;
    }
    public void setTipoForno(String tipoForno) {
	this.tipoForno = tipoForno;
    }
}
