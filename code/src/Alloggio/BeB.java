package Alloggio;

public class BeB extends Alloggio{

    private int nCamere;
    private int stelle;
    private boolean bagnoInComune;

    public BeB(Alloggio all,int nCamere, int stelle, String bagnoInComune) {
	super(all);
	this.nCamere=nCamere;

	if(bagnoInComune.equals("si")) {
	    this.bagnoInComune=true;
	}else {
	    this.bagnoInComune=false;
	}

	this.stelle=stelle;
    }


    @Override
    public String toString() {

	String s="Informazioni: \nNumero Camere:"+nCamere+", Stelle:"+stelle+", Bagno in coumune:"+bagnoInComune;
	s = s.replace("true", "si");
	s = s.replace("false", "no");

	return s;
    }

    public int getnCamere() {
	return nCamere;
    }
    public void setnCamere(int nCamere) {
	this.nCamere = nCamere;
    }
    public int getStelle() {
	return stelle;
    }
    public void setStelle(int stelle) {
	this.stelle = stelle;
    }
    public boolean isBagnoInComune() {
	return bagnoInComune;
    }
    public void setBagnoInComune(boolean bagnoInComune) {
	this.bagnoInComune = bagnoInComune;
    }
}
