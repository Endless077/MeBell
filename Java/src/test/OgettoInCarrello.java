package test;

public class OgettoInCarrello {
	private Prodotto prodotto;
	private int quantit�;
	
	public OgettoInCarrello(Prodotto p,int q) {
		prodotto = p;
		quantit� = q;
	}
	
	public Prodotto getProdotto() {
		return prodotto;
	}
	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}
	public int getQuantit�() {
		return quantit�;
	}
	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}

}
