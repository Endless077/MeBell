package Alloggio;

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


    @Override
    public String toString() {

	return "Informazioni: \nNumero Camere:"+nCamere+", Numero Suite:"+nSuite+", Stelle:"+stelle;
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
