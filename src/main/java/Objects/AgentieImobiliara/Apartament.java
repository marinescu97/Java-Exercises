package Objects.AgentieImobiliara;

/**
 * Reprezinta un apartament care poate fi pus spre vanzare de catre agentia imobiliara.
 * Apartamentul este caracterizat prin adresa, etaj, suprafata, numar camere si alte informatii relevante.
 */
public class Apartament {
    private byte etaj, confort, nr, suprafata, nrCamere, nrBalcoane;
    private String tip, adresa, zona, oras, nrContract;
    private boolean incadrare;

    /**
     * Creeaza un apartament cu detaliile specificate.
     * @param nr numarul apartamentului
     * @param etaj etajul la care se afla apartamentul
     * @param confort confortul apartamentului reprezentat prin cifre de la 1 la 4.
     * @param suprafata suprafata apartamentului
     * @param nrCamere numarul camerelor
     * @param nrBalcoane numarul balcoanelor
     * @param tip tipul apartamentului (decomandat, semidecomandat, nedecomandat)
     * @param adresa adresa la care se afla apartamentul
     * @param zona zona in care se afla apartamentul
     * @param oras orasul in care se afla apartamentul
     * @param nrContract numarul contractului in cazul in care apartamentul este vandut
     */
    public Apartament(byte nr,byte etaj, byte confort, byte suprafata, byte nrCamere, byte nrBalcoane, String tip, String adresa, String zona, String oras, String nrContract) {
        this.etaj = etaj;
        this.confort = confort;
        this.nr = nr;
        this.suprafata = suprafata;
        this.nrCamere = nrCamere;
        this.nrBalcoane = nrBalcoane;
        this.tip = tip;
        this.adresa = adresa;
        this.zona = zona;
        this.oras = oras;
        this.nrContract = nrContract;
        this.incadrare = false;
    }

    public Apartament(byte nr, byte etaj, byte confort, byte suprafata, byte nrCamere, byte nrBalcoane, String tip, String adresa, String zona, String oras) {
        this.etaj = etaj;
        this.confort = confort;
        this.nr = nr;
        this.suprafata = suprafata;
        this.nrCamere = nrCamere;
        this.nrBalcoane = nrBalcoane;
        this.tip = tip;
        this.adresa = adresa;
        this.zona = zona;
        this.oras = oras;
        this.incadrare = true;
    }

    /**
     * Obtine etajul la care se afla apartamentul.
     * @return etajul la care se afla apartamentul
     */
    public byte getEtaj() {
        return etaj;
    }

    /**
     * Obtine confortul apartamentului.
     * @return confortul apartamentului
     */
    public byte getConfort() {
        return confort;
    }

    /**
     * Obtine numarul apartamentului.
     * @return numarul apartamentului
     */
    public byte getNr() {
        return nr;
    }

    /**
     * Obtine suprafata apartamentului.
     * @return suprafata apartamentului
     */
    public byte getSuprafata() {
        return suprafata;
    }

    /**
     * Obtine numarul de camere al apartamentului.
     * @return numarul de camere al apartamentului
     */
    public byte getNrCamere() {
        return nrCamere;
    }

    /**
     * Obtine numarul de balcoane al apartamentului.
     * @return numarul de balcoane al apartamentului
     */
    public byte getNrBalcoane() {
        return nrBalcoane;
    }

    /**
     * Obtine tipul apartamentului.
     * @return tipul apartamentului
     */
    public String getTip() {
        return tip;
    }

    /**
     * Obtine adresa apartamentului.
     * @return adresa apartamentului
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Obtine zona apartamentului.
     * @return zona apartamentului
     */
    public String getZona() {
        return zona;
    }

    /**
     * Obtine orasul apartamentului.
     * @return orasul apartamentului
     */
    public String getOras() {
        return oras;
    }

    /**
     * Se retine contractul in cazul vanzarii unui apartament si se schimba incadrarea apartamentului
     * @param nrContract contractul de vanzare al apartamentului
     */
    public void setNrContract(String nrContract) {
        this.nrContract = nrContract;
        this.incadrare = false;
    }

    /**
     * Obtine incadrarea apartamentului.
     * @return incadrarea apartamentului
     */
    public boolean isIncadrare() {
        return incadrare;
    }

    /**
     * Afiseaza informatii despre apartament.
     * @return modul in care apartamentul este afisat
     */
    public String afisareApartament(){
        String disponibilitate;
        if (isIncadrare()){
            disponibilitate = "Disponibil";
        } else {
            disponibilitate = "Indisponibil";
        }
        return "Apartament nr." + getNr() + ", " +
                "Etaj: " + getEtaj() + ", " +
                "Numar camere: " + getNrCamere() + ", " +
                "Nr balcoane: " + getNrBalcoane() + ", " +
                "Tip: " + getTip() + ", " +
                "Suprafata: " + getSuprafata() + ", " +
                "Confort: " + getConfort() + ", " +
                "Adresa: " + getAdresa() + ",zona " + getZona() + ", " + getOras() + "\n" +
                "Disponibilitate: " + disponibilitate;
    }
}
