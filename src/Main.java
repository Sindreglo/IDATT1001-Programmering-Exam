import static javax.swing.JOptionPane.*;
public class Main {

    public static void main(String[] args) {
        CovidStatsUI covidStatsUI = new CovidStatsUI();

        String[] menuItems = {"Add a COVID-19 entry", "List all COVID-19 entries in the register", "Find COVID-19 entry by date", "Find all entries after date", "Show the total deaths for a country", "Exit"};
        final int ADD_COVID_ENTRY_TO_REGISTER = 0;
        final int LIST_ALL_COVID_ENTRIES = 1;
        final int FIND_COVID_ENTRY_BY_DATE = 2;
        final int FIND_COVID_ENTRY_AFTER_DATE = 3;
        final int CALCULATE_TOTAL_DEATHS = 4;
        final int EXIT = 5;

        int menuSelection = showOptionDialog(null, "COID-19 \nSelect", "Exam des 2020", YES_NO_OPTION, INFORMATION_MESSAGE, null, menuItems, menuItems[0]);
        while (menuSelection != EXIT) {
            switch (menuSelection) {
                case ADD_COVID_ENTRY_TO_REGISTER:
                    int dato = Integer.parseInt(showInputDialog("Skriv inn dato for registrering:\nSkriv på form: 20201214 (14.12.2020)"));
                    String land = showInputDialog("Skriv inn landet til registreringen:");
                    int nyeSmittede = Integer.parseInt(showInputDialog("Skriv inn antall nye smittetilfeller:"));
                    int nyeDoede = Integer.parseInt(showInputDialog("Skriv inn antall nye døde:"));
                    if (covidStatsUI.regCOVIDtilfeller(dato, land, nyeSmittede, nyeDoede)) {
                        showMessageDialog(null, "Registrering godkjent.");
                    } else {
                        showMessageDialog(null, "Registrering ikke godkjent, noe gikk galt.");
                    }
                    break;

                case LIST_ALL_COVID_ENTRIES:
                    showMessageDialog(null, "Liste over alle registreringer:\n"+covidStatsUI.getRegistreringer().toString());
                    break;

                case FIND_COVID_ENTRY_BY_DATE:
                    int soekDato = Integer.parseInt(showInputDialog("Skriv inn dato du vil se:\nSkriv på form: 20201214 (14.12.2020"));
                    showMessageDialog(null, covidStatsUI.registreringerDato(soekDato).toString());
                    break;

                case FIND_COVID_ENTRY_AFTER_DATE:
                    int soekFraDato = Integer.parseInt(showInputDialog("Skriv inn dato du vil søke fra:\nSkriv på form: 20201214 (14.12.2020"));
                    showMessageDialog(null, covidStatsUI.registreringerEtterDato(soekFraDato));
                    break;

                case CALCULATE_TOTAL_DEATHS:
                    String valgtLand = showInputDialog(null, "Skriv inn landet du vil ha oversikt fra:");
                    showMessageDialog(null, covidStatsUI.antDoedeLand(valgtLand));
                    break;
                default:
                    break;
            }
            menuSelection = showOptionDialog(null, "COID-19 \nSelect", "Exam des 2020", YES_NO_OPTION, INFORMATION_MESSAGE, null, menuItems, menuItems[0]);
        }
    }
}
