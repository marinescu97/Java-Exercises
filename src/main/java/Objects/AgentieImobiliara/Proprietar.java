package Objects.AgentieImobiliara;

/**
 * Reprezinta noul proprietar al apartamentului.
 * Contine detalii despre proprietar cum ar fi numele si cnp-ul.
 */
public class Proprietar {
    private String nume, cnp;

    /**
     * Creeaza un proprietar cu detaliile specificate.
     * @param nume numele proprietarului
     * @param cnp cnp-ul proprietarului
     */
    Proprietar(String nume, String cnp){
        this.nume = nume;
        this.cnp = cnp;
    }

    /**
     * Obtine numele proprietarului
     * @return numele proprietarului
     */
    public String getNume() {
        return nume;
    }

    /**
     * Obtine cnp-ul proprietarului.
     * @return cnp-ul proprietarului
     */
    public String getCnp() {
        return cnp;
    }

    /**
     * Afiseaza proprietarul.
     * @return modul in care proprietarul este afisat
     */
    public String afisareProprietar(){
        return getNume() + ", " + getCnp();
    }
}
