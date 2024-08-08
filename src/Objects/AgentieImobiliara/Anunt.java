package Objects.AgentieImobiliara;

/**
 * Clasa reprezinta un anunt imobiliar.
 * Un anunt contine detalii despre un apartament si data la care s-a postat anuntul.
 */
public class Anunt {
    private Apartament apartament;
    private String data;

    /**
     * Creeaza un anunt cu detaliile specificate.
     * @param apartament Apartamentul pentru care este creat anuntul.
     * @param data Data la care s-a postat anuntul.
     */
    public Anunt(Apartament apartament, String data){
        if (apartament.isIncadrare()){
            this.apartament = apartament;
            this.data = data;
        }
    }

    /**
     * Obtine apartamentul pentru care s-a postat anuntul.
     * @return apartamentul
     */
    public Apartament getApartament() {
        return apartament;
    }

    /**
     * Obtine data la care s-a postat anuntul.
     * @return data
     */
    public String getData(){
        return data;
    }

    /**
     * Afiseaza anuntul creat.
     */
    public void afisareAnunt(){
        System.out.println("Data " + getData() + "\n" + getApartament().afisareApartament());
    }
}
