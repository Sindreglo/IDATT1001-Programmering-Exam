import java.util.Objects;

/**
 * Klassen COVIDregistrering
 */
public class COVIDregistrering {
    final private int dato;
    final private String land;
    final private int nyeSmittede;
    final private int nyeDoede;

    /**
     * Konstruktør oppretter objekt av variablene, av typen COVIDregistrering.
     *
     * @param dato
     * @param land
     * @param nyeSmittede
     * @param nyeDoede
     */
    public COVIDregistrering(int dato, String land, int nyeSmittede, int nyeDoede) {
        //Hvis antall nye smittetilfeller ELLER antall nye døde er mindre en null,
        //kastes en feilmelding om problemet.
        if (nyeSmittede <0 || nyeDoede <0) {
            throw new IllegalArgumentException("Kan ikke være mindre en null.");
        }
        this.dato = dato;
        this.land = land;
        this.nyeSmittede = nyeSmittede;
        this.nyeDoede = nyeDoede;
    }

    /**
     * Metode. get-metode returnerer datoen.
     *
     * @return dato (integer)
     */
    public int getDato() {
        return dato;
    }

    /**
     * Metode. get-metode returnerer landet.
     *
     * @return land (String)
     */
    public String getLand() {
        return land;
    }

    /**
     * Metode. get-metode returnerer antall nye smittede.
     *
     * @return nyeSmittede (Integer)
     */
    public int getNyeSmittede() {
        return nyeSmittede;
    }


    /**
     * Metode. get-metode returnerer antall nye døde.
     *
     * @return nyeDøde (Integer)
     */
    public int getNyeDoede() {
        return nyeDoede;
    }

    /**
     * Metode som sjekker om et objekt stemmer med gjeldende objekt.
     *
     * @param o
     * @return true/false ettersom det er samme objekt.
     */
    @Override
    public boolean equals(Object o) {
        //sjekker om det er et objekt av typen COVIDregistrering
        if (this == o) return true;
        //sjekker om objektet har innhold
        if (o == null || getClass() != o.getClass()) return false;
        COVIDregistrering that = (COVIDregistrering) o;
        return dato == that.dato &&
                nyeSmittede == that.nyeSmittede &&
                nyeDoede == that.nyeDoede &&
                Objects.equals(land, that.land);
    }

    /**
     * Metode. toString metode returnerer variablene som felles String.
     * @return
     */
    @Override
    public String toString() {
        return dato + ", " + land.toUpperCase() + ", Nye smittende: " + nyeSmittede + ", nyeDøde=" + nyeDoede + "\n";
    }
}
