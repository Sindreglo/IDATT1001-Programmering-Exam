import java.util.ArrayList;
import java.util.Iterator;

/**
 * Klassen CovidStatsUI
 */
public class CovidStatsUI {
    private ArrayList<COVIDregistrering> register;

    /**
     * Konstruktør, oppretter ArrayList for covidregistreringer.
     */
    public CovidStatsUI() {
        this.register = new ArrayList<>();
    }

    /**
     * Metoden regCOVIDtilfeller tar in variablene til en ny covidregistrering,
     * og legger den til i ArrayListen hvis metoden godkjenner den.
     *
     * @param dato
     * @param land
     * @param nyeSmittede
     * @param nyedoede
     * @return true/false etter om det ble lagt til i ArrayListen
     */
    public boolean regCOVIDtilfeller(int dato, String land, int nyeSmittede, int nyedoede) {
        //Gir brukeren en feilmelding om det skulle inntreffe. returnerer false siden objektet ikke ble lagt til.
        try {
            //Oppretter et nytt Objekt fra variablene
            COVIDregistrering COVIDtilfeller = new COVIDregistrering(dato, land, nyeSmittede, nyedoede);

            //Går gjennom en for-loop for alle registrerte objekter. Legger ikke
            // til hvis objektet allerede er i ArrayListen. Returnerer derfor false.
            for (COVIDregistrering c: register) {
                if (c.equals(COVIDtilfeller)) {
                    return false;
                }
            }
            //Legger til i registeret, returnerer true siden det ble lagt til.
            register.add(COVIDtilfeller);
            return true;

        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Metode som returnerer ArrayListen av alle covidregistreringer.
     *
     * @return ArrayList
     */
    public ArrayList<COVIDregistrering> getRegistreringer() {
        return register;
    }

    /**
     * Metode som returnerer String av totalt antall smittetilfeller.
     *
     * @return String
     */
    public String getAntRegistreringer() {
        return "Totalt antall registrerte smittetilfeller: " + register.size();
    }

    /**
     * Metode som returnerer ArrayList for alle covidregistreringer på gitt dato.
     *
     * @param dato
     * @return ArrayList
     */
    public ArrayList<COVIDregistrering> registreringerDato(int dato) {
        //Oppretter ny ArrayList
        ArrayList<COVIDregistrering> retur = new ArrayList<>();
        //Går gjennom alle covidregistreringer.
        for (COVIDregistrering c: register) {
            //Sjekker om datoen til hvert objekt stemmer med valgt dato.
            if (c.getDato() == dato) {
                //Legger til objektet i den nye ArrayListen.
                retur.add(c);
            }
        }
        //Returnerer den nye ArrayListen
        return retur;
    }

    /**
     * Metode som returnerer String over første covidregistrering på gitt dato
     *
     * @param dato
     * @return toString av objektet.
     */
    public String forsteRegistreringDato(int dato) {
        //Går gjennom alle covidregistreringer.
        for (COVIDregistrering c: register) {
            //Sjekker om datoen til hvert objekt stemmer med valgt dato.
            if (c.getDato() == dato) {
                //Returnerer første registrering Som string
                return c.toString();
            }
        }
        //Returnerer null, om ingen registreringer på gitt dato.
        return null;
    }

    /**
     * Metode som returnerer ArrayList av alle covidregistreringer etter (ikke fra og med), gitt dato.
     *
     * @param dato
     * @return ArrayList
     */
    public ArrayList<COVIDregistrering> registreringerEtterDato(int dato) {
        //Oppretter ny ArrayList
        ArrayList<COVIDregistrering> retur = new ArrayList<>();
        //Går gjennom alle covidregistreringer.
        for (COVIDregistrering c: register) {
            //Sjekker om datoen til hvert objekt er større enn valgt dato.
            if (c.getDato() > dato) {
                //Legger til objektet i den nye ArrayListen.
                retur.add(c);
            }
        }
        //Returnerer den nye ArrayListen
        return retur;
    }

    /**
     * Metode som kalkulerer antall totale dødsfall i gitt land.
     *
     * @param land
     * @return int antall dødsfall
     */
    public int antDoedeLand(String land) {
        //Oppretter integer-variabel som øker hvor antall dødsfall. starter derfor på null.
        int antDoede = 0;
        for (COVIDregistrering c: register) {
            //Sjekker om landet til objektet stemmer med gitt land, uavhengig av små/store bokstaver.
            if (c.getLand().equalsIgnoreCase(land)) {
                //Legger til nye dødsfall i antDoede
                antDoede += c.getNyeDoede();
            }
        }
        //returnerer integer (heltall) over antall døde.
        return antDoede;
    }



    public boolean itererer(String land) {
        Iterator iterator = register.iterator();
        while (iterator.hasNext()) {
            COVIDregistrering registrering = (COVIDregistrering) iterator.next();
            if (registrering.getLand().equalsIgnoreCase(land)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

}
