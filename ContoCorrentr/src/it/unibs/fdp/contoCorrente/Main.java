package it.unibs.fdp.contoCorrente;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.Base64;

public class Main {

    public static void greeting() {
        System.out.println("Benvenuti!");
    }

    public static void goodbye() {
        System.out.println("Arrivederci!");
    }

    private static final String MENU = "" +
            "\r\n--------MENU--------\r\n" +
            "0. Esci dal programma\n" +
            "1. Prelevare\n" +
            "2. Depositare\n" +
            "\r\n--------------------\r\n" +
            "Scelta: ";

    public static void main(String[] args) {

        greeting();

        ContoCorrente c = creaConto();

        int scelta;

        do {

            scelta = InputDati.leggiIntero(MENU, 0, 2);

            switch (scelta) {

                case 0: goodbye();
                        break;

                case 1: double importo = InputDati.leggiDoubleConMinimo("Inserisci l'importo da prelevare: ", 0.0);
                    String.format("%,2f", importo);
                    System.out.println("Il saldo e': " + c.withdraw(importo));
                    break;

                case 2: double versamento = InputDati.leggiDoubleConMinimo("Inserisci il valore del versamento da effettuare: ", 0.0);
                    System.out.println("Il saldo e': " + c.deposit(versamento));
                    break;

                default:
                    System.out.println("Errore");
            }

        } while (scelta != 0);

    }

    public static ContoCorrente creaConto() {

        DecimalFormat df = new DecimalFormat(".##");

        String proprietario = InputDati.leggiStringaNonVuota("Inserisci il nome del proprietario: ");
        double saldo = InputDati.leggiDoubleConMinimo("Inserisci il saldo iniziale: ", 0);

        System.out.print("-->  Saldo arrotondato: " + df.format(saldo));

        return new ContoCorrente(proprietario, saldo);
    }
}
