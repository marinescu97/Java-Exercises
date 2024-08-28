package Objects.AgentieImobiliara;

/**
 * Reprezinta un contract de vanzare-cumparare pentru un apartament.
 * Contine detalii despre numarul si data contractului, noul proprietar si apartament.
 */
public class Contract {
    private String nrContract, data;
    private Proprietar proprietar;
    private Apartament apartament;

    /**
     * Creeaza un contract cu detaliile specificate.
     * @param nrContract numarul contractului
     * @param data data contractului
     * @param proprietar persoana care a cumparat apartamentul
     * @param apartament apartamentul care s-a vandut
     */
    public Contract(String nrContract, String data, Proprietar proprietar, Apartament apartament) {
        if (apartament.isIncadrare()){
            this.nrContract = nrContract;
            this.data = data;
            this.proprietar = proprietar;
            this.apartament = apartament;
            apartament.setNrContract(nrContract);
        } else {
            System.out.println("Apartamentul nu este disponibil!");
        }
    }

    /**
     * Obtine numarul contractului.
     * @return numarul contractului
     */
    public String getNrContract() {
        return nrContract;
    }

    /**
     * Obtine data contractului.
     * @return data contractului
     */
    public String getData() {
        return data;
    }

    /**
     * Obtine proprietarul apartamentului.
     * @return proprietarul apartamentului
     */
    public Proprietar getProprietar() {
        return proprietar;
    }

    /**
     * Obtine apartamentul vandut.
     * @return apartamentul vandut
     */
    public Apartament getApartament() {
        return apartament;
    }

    /**
     * Afiseaza contractul.
     * @return modul in care contractul este afisat
     */
    public String afisareContract(){
        return "Contract nr." + getNrContract() + " din data " + getData() + "\n" +
                "Proprietar: " + getProprietar().afisareProprietar() + "\n" + getApartament().afisareApartament();
    }
}
