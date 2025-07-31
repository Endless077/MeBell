package Entita;


public class Utente {

    private String username;
    private String nome;
    private String cognome;
    private String password;


    public Utente(String user, String first, String last, String passw) {

	setUsername(user);
	setNome(first);
	setCognome(last);
	setPassword(passw);

    }

    public String getNome() {
	return nome;
    }
    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getCognome() {
	return cognome;
    }

    public void setCognome(String cognome) {
	this.cognome = cognome;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

}
