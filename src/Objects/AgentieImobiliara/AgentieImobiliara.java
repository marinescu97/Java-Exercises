package Objects.AgentieImobiliara;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Reprezintă o agenție imobiliară care gestionează anunțuri și tranzacții.
 * Este reprezentata de o denumire, adresa, o lista de anunturi si numarul lor.
 * Permite adaugarea anunturilor in lista si vanzarea apartamentelor.
 */
public class AgentieImobiliara {
    private final String denumire = "Java Estate";
    private String adresa;
    private ArrayList<Anunt> anunturi;
    private int nrAnunturi;

    /**
     * Creeaza o agentie imobiliara.
     */
    AgentieImobiliara(){
        this.adresa = "Str. Pelicanilor, nr.3";
        this.anunturi = new ArrayList<>();
        this.nrAnunturi = anunturi.size();
    }

    /**
     * Obtine lista anunturilor.
     * @return lista anunturilor
     */
    public ArrayList<Anunt> getAnunturi() {
        return anunturi;
    }

    /**
     * Adauga un anunt in lista.
     * @param anunt anuntul pentru vanzarea unui apartament.
     */
    public void adaugaAnunt(Anunt anunt){
        getAnunturi().add(anunt);
    }

    /**
     * Vinde un apartament.
     * @param nr numarul anuntului
     * @param nume numele persoanei care cumpara apartamentul
     * @param cnp cnp-ul persoanei care cumpara apartamentul
     * @param nrContract numarul contractului incheiat
     * @param data data la care s-a realizat tranzactia
     */
    public void vindeApartament(int nr, String nume, String cnp, String nrContract, String data){
        //  verifica daca apartamentul este disponibil
        for (int i=0; i<getAnunturi().size(); i++){
            if (getAnunturi().get(i).getApartament().getNr()==nr && getAnunturi().get(i).getApartament().isIncadrare()==true){
                // creeaza un obiect de tip Proprietar
                Proprietar proprietar = new Proprietar(nume, cnp);
                // creeaza un obiect de tip Contract
                Contract contract = new Contract(nrContract, data, proprietar, getAnunturi().get(i).getApartament());
                getAnunturi().remove(i);
                System.out.println("Apartamentul a fost vandut cu succes!");
            }
        }
    }

    /**
     * Afiseaza anunturile din lista dupa informatiile specificate.
     * @param luna luna anuntului
     * @param an anul anuntului
     */
    public void afisareAnunturiLunaAn(String luna, String an){
        for (int i=0; i<getAnunturi().size(); i++){
            LocalDate d = LocalDate.parse(getAnunturi().get(i).getData(), DateTimeFormatter.ofPattern("d/MM/yyyy", Locale.ENGLISH));
            String l = Integer.toString(d.getMonthValue());
            String a = Integer.toString(d.getYear());
            if (l==luna && a==an){
                getAnunturi().get(i).afisareAnunt();
            }
        }
    }

    /**
     * Afiseaza toate anunturile agentiei.
     */
    public void afisareAnunturiAgentie(){
        for (int i=0; i<getAnunturi().size(); i++){
            getAnunturi().get(i).afisareAnunt();
        }
    }
}

/**
 * Clasa testeaza functionalitatea clasei {@link AgentieImobiliara}.
 */
class Test {
    public static void main(String[] args) {
        // Se creeaza 5 apartamente.
        Apartament a1 = new Apartament((byte) 1,(byte) 2, (byte) 1, (byte) 70, (byte) 3, (byte) 1, "decomandat", "Str. Eliberarii, nr.3", "rezidentiala", "Constanta");
        Apartament a2 = new Apartament((byte) 2,(byte) 1, (byte) 3, (byte) 50, (byte) 3, (byte) 0, "semidecomandat", "Str. Salciei, nr.2", "periferie", "Bucuresti");
        Apartament a3 = new Apartament((byte) 3,(byte) 0, (byte) 2, (byte) 60, (byte) 2, (byte) 1, "decomandat", "Str. Mihai Eminescu, nr.14", "rezidentiala", "Constanta");
        Apartament a4 = new Apartament((byte) 4,(byte) 3, (byte) 1, (byte) 43, (byte) 2, (byte) 0, "nedecomandat", "Str. Pescarusilor, nr.1", "rezidentiala", "Constanta");
        Apartament a5 = new Apartament((byte) 5,(byte) 1, (byte) 1, (byte) 67, (byte) 2, (byte) 1, "semidecomandat", "Str. Margaritarelor, nr.7", "periferie", "Constanta");

        // Se creeaza o noua agentie imobiliara si se adauga anunturi pentru apartamente.
        AgentieImobiliara agentie = new AgentieImobiliara();
        agentie.adaugaAnunt(new Anunt(a1, "02/02/2007"));
        agentie.adaugaAnunt(new Anunt(a4,"17/03/2022"));
        agentie.adaugaAnunt(new Anunt(a5,"15/02/2007"));

        // Se vinde un apartament
        agentie.vindeApartament(4, "Marinescu Monica", "2647935712549", "001", "29/12/2022");

        // Se afiseaza toate anunturile agentiei
        agentie.afisareAnunturiAgentie();

        //Se afiseaza un apartament
        System.out.println(a4.afisareApartament());
        System.out.println();

        // Se afiseaza doar anunturile din Februarie 2007.
        agentie.afisareAnunturiLunaAn("2", "2007");
    }
}
