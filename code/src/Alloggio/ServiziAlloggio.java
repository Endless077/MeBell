package Alloggio;

public class ServiziAlloggio {

    private boolean wi_fi;
    private boolean dayUse;
    private boolean spa;
    private boolean piscina;
    private boolean ariaCondizionata;
    private boolean accessoDisabili;
    private boolean accessoAnimali;
    private boolean ascensore;
    private boolean servizioLavanderia;
    private boolean servizioRistorazione;
    private boolean tv_stereo;
    private boolean parcheggio;



    public ServiziAlloggio(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12) {

	if(string.equals("si")) {
	    wi_fi=true;
	}else {
	    wi_fi=false;
	}

	if(string2.equals("si")) {
	    dayUse=true;
	}else {
	    dayUse=false;
	} 

	if(string3.equals("si")) {
	    spa=true;
	}else {
	    spa=false;
	}

	if(string4.equals("si")) {
	    piscina=true;
	}else {
	    piscina=false;
	}

	if(string5.equals("si")) {
	    ariaCondizionata=true;
	}else {
	    ariaCondizionata=false;
	}

	if(string6.equals("si")) {
	    accessoDisabili=true;
	}else {
	    accessoDisabili=false;
	}

	if(string7.equals("si")) {
	    accessoAnimali=true;
	}else {
	    accessoAnimali=false;
	}

	if(string8.equals("si")) {
	    ascensore=true;
	}else {
	    ascensore=false;
	}

	if(string9.equals("si")) {
	    servizioLavanderia=true;
	}else {
	    servizioLavanderia=false;
	}

	if(string10.equals("si")) {
	    servizioRistorazione=true;
	}else {
	    servizioRistorazione=false;
	}

	if(string11.equals("si")) {
	    tv_stereo=true;
	}else {
	    tv_stereo=false;
	}

	if(string12.equals("si")) {
	    parcheggio=true;
	}else {
	    parcheggio=false;
	}
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Servizi:\nWiFi: ").append(wi_fi).append(",\tday use: ").append(dayUse).append(",\tspa: ")
	.append(spa).append(",\npiscina: ").append(piscina).append(",\taria condizionata: ").append(ariaCondizionata)
	.append(",\taccesso disabili: ").append(accessoDisabili).append(",\naccesso animali: ").append(accessoAnimali)
	.append(",\tascensore:").append(ascensore).append(",\tservizio lavanderia:").append(servizioLavanderia)
	.append(",\nservizio ristorazione: ").append(servizioRistorazione).append(",\ttv stereo: ").append(tv_stereo)
	.append(",\tparcheggio: ").append(parcheggio).append(".");

	String s = builder.toString();
	s = s.replace("true", "disponibile");
	s = s.replace("false", "non disponibile");
	return s;
    }


    public boolean isWi_fi() {
	return wi_fi;
    }
    public void setWi_fi(boolean wi_fi) {
	this.wi_fi = wi_fi;
    }
    public boolean isDayUse() {
	return dayUse;
    }
    public void setDayUse(boolean dayUse) {
	this.dayUse = dayUse;
    }
    public boolean isSpa() {
	return spa;
    }
    public void setSpa(boolean spa) {
	this.spa = spa;
    }
    public boolean isPiscina() {
	return piscina;
    }
    public void setPiscina(boolean piscina) {
	this.piscina = piscina;
    }
    public boolean isAriaCondizionata() {
	return ariaCondizionata;
    }
    public void setAriaCondizionata(boolean ariaCondizionata) {
	this.ariaCondizionata = ariaCondizionata;
    }
    public boolean isAccessoDisabili() {
	return accessoDisabili;
    }
    public void setAccessoDisabili(boolean accessoDisabili) {
	this.accessoDisabili = accessoDisabili;
    }
    public boolean isAccessoAnimali() {
	return accessoAnimali;
    }
    public void setAccessoAnimali(boolean accessoAnimali) {
	this.accessoAnimali = accessoAnimali;
    }
    public boolean isAcenzore() {
	return ascensore;
    }
    public void setAcenzore(boolean acenzore) {
	this.ascensore = acenzore;
    }
    public boolean isServizioLavanderia() {
	return servizioLavanderia;
    }
    public void setServizioLavanderia(boolean servizioLavanderia) {
	this.servizioLavanderia = servizioLavanderia;
    }
    public boolean isServizioRistorazione() {
	return servizioRistorazione;
    }
    public void setServizioRistorazione(boolean servizioRistorazione) {
	this.servizioRistorazione = servizioRistorazione;
    }
    public boolean isTv_stereo() {
	return tv_stereo;
    }
    public void setTv_stereo(boolean tv_stereo) {
	this.tv_stereo = tv_stereo;
    }
    public boolean isParcheggio() {
	return parcheggio;
    }
    public void setParcheggio(boolean parcheggio) {
	this.parcheggio = parcheggio;
    }
}
