package it.unibs.fdp.aziendaSanitaria;

import java.sql.PseudoColumnUsage;

public class Main {

    private static final String MENU = "" +
            "\r\n----------MENU----------\r\n" +
            "0. Esci dal programma\n" +
            "1. Inserisci un medico\n" +
            "2. Inserisci un paziente\n" +
            "3. Ricerca un medico\n" +
            "4. Ricerca un paziente\n" +
            "5. Riassegna un paziente ad un nuovo medico\n" +
            "\r\n--------------------------\r\n" +
            "Scelta: ";

    private static final String  SOTTOMENU = "" +
            "\r\n-------SOTTOMENU-------\r\n" +
            "6. Ricerca per codice\n" +
            "7. Ricerca per giorno di riposo\n" +
            "8. Indietro\n" +
            "\r\n--------------------------\r\n" +
            "Scelta: ";


    static AziendaSanitaria as = creaAzienda();

    public static void main(String[] args) {

        int scelta;
        Giorni oggi = Giorni.LUNEDI;

        do {

            scelta = InputDati.leggiIntero(MENU, 0, 5);

            switch (scelta) {

                case 0: break;

                case 1:
                    Medico m = creaMedico();
                    as.inserisciMedico(m);
                    break;

                case 2:
                    Paziente p = creaPaziente(as.getMedicoDisponibile(oggi));
                    as.inserisciPaziente(p);
                    break;

                case 3:

                    scelta = InputDati.leggiIntero(SOTTOMENU, 6, 8);

                    switch(scelta) {

                        case 6:
                            String codice = InputDati.leggiStringaNonVuota("Inserisci il codice del medico da cercare: ");
                            as.ricercaMedicoCodice(codice);
                            break;

                        case 7:
                            String day = InputDati.leggiStringaNonVuota("Inserisci il giorno: ");
                            as.ricercaMedicoGiorno(Giorni.getDay(day));
                            break;

                        case 8: break;

                    }
                    break;

                case 4:
                    String tesseraSanitaria = InputDati.leggiStringaNonVuota("Inserisci il codice della tessera da cercare: ");
                    as.ricercaPaziente(tesseraSanitaria);
                    break;

                case 5:
                    String tessera = InputDati.leggiStringaNonVuota("Inserisci il codice della tessera del paziente da riassegnare: ");
                    as.riassegnaPaziente(tessera, oggi);
                    break;

                default:
                    System.out.println("Errore");
            }


        } while (scelta != 0);


    }

    public static AziendaSanitaria creaAzienda() {

        String nome = InputDati.leggiStringaNonVuota("Inserisci il nome della azienda: ");
        String descrizione = InputDati.leggiStringaNonVuota("Inserisci una breve descrizione della azienda: ");

        return new AziendaSanitaria(nome, descrizione);
    }

    public static Medico creaMedico() {

        String nome = InputDati.leggiStringaNonVuota("Nome: ");
        String cognome = InputDati.leggiStringaNonVuota("Cognome: ");
        String codice = InputDati.leggiStringaNonVuota("Codice: ");

        while(!Medico.checkCode(codice) || !as.isUnicoCodice(codice)) {
            System.out.println("Codice incorretto");
            codice = InputDati.leggiStringaNonVuota("Codice: ");
        }

        return new Medico(nome, cognome, codice);
    }

    public static Paziente creaPaziente(Medico m) {

        String nome = InputDati.leggiStringaNonVuota("Nome: ");
        String cognome = InputDati.leggiStringaNonVuota("Cognome: ");
        String tessera = InputDati.leggiStringaNonVuota("Codice: ");

        while(!Paziente.checkCodice(tessera) || !as.isUnicoPazinete(tessera)) {
            System.out.println("Numero tessera incorretto");
            tessera = InputDati.leggiStringaNonVuota("Codice: ");
        }

        return new Paziente(nome, cognome, tessera, m);
    }

}
