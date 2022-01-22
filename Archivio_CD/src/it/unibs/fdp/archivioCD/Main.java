package it.unibs.fdp.archivioCD;

import java.util.ArrayList;
import java.util.Locale;

public class Main {

    public static void greeting() {
        System.out.println("Benvenuti");
    }

    public static void goodbye() {
        System.out.println("Arrivederci");
    }

    private static final String MENU = "" +
            "\r\n-------MENU-------\r\n" +
            "0. Esci dal programma\n" +
            "1. Inserisci un nuovo CD\n" +
            "2. Visualizza il contenuto di un CD\n" +
            "3. Elimina un CD\n" +
            "4. Visualizza l'intera collezione\n" +
            "5. Seleziona un brano a caso dall'intera collezione" +
            "\r\n------------------\r\n" +
            "\nScelta: ";

    public static void main(String[] args) {

        greeting();

        Collezione col = new Collezione();
        int scelta;

        do {

            scelta = InputDati.leggiIntero(MENU, 0, 5);

            switch (scelta) {

                case 0: goodbye();
                    break;

                case 1: col.creaCD();
                    break;

                case 2: col.stampaCD();
                    break;

                case 3: col.rimuovi();
                    break;

                case 4: col.printCollection();
                    break;

                case 5: col.randomCD();
                    break;

                default:
                    System.out.println("Errore");

            }

        } while (scelta != 0);
    }
}
