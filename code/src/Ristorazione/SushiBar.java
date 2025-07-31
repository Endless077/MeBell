package Ristorazione;

public class SushiBar {

    private boolean allYouCanEat;
    private String tipoSushi;

    public SushiBar(String allYouCanEat, String tipoSushi) {
	if(allYouCanEat.contentEquals("si")) {
	    this.allYouCanEat=true;
	}else {
	    this.allYouCanEat=false;
	}
	this.tipoSushi=tipoSushi;
    }

    public boolean isAllYouCanEat() {
	return allYouCanEat;
    }

    public void setAllYouCanEat(boolean allYouCanEat) {
	this.allYouCanEat = allYouCanEat;
    }
    public String getTipoSushi() {
	return tipoSushi;
    }
    public void setTipoSushi(String tipoSushi) {
	this.tipoSushi = tipoSushi;
    }
}
