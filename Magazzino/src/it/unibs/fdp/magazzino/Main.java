package it.unibs.fdp.magazzino;

import java.util.ArrayList;

public class Main {

    private static final String MENU = "" +
            "\r\n-------MENU-------\r\n" +
            "0. Esci dal programma\n" +
            "1. Inserisci degli articoli\n" +
            "2. Effettua un ordine" +
            "\r\n------------------\r\n" +
            "Scelta: ";

    public static void main(String[] args) {

        Magazzino m = new Magazzino();
        int scelta;

        do {

            scelta = InputDati.leggiIntero(MENU, 0, 2);

            switch (scelta) {

                case 0: break;

                case 1: Articolo a = creaArticolo();
                    m.addArticolo(a);
                    System.out.println(a);
                    break;

                case 2:
                    m.getDisponibili();

                    String nome = InputDati.leggiStringaNonVuota("Articolo da ordinare: ");
                    int quantity = InputDati.leggiIntero("Quantita' da ordinare: ");

                    Articolo articolo = m.cercaArticolo(new Articolo(nome, 0,0,0, null));

                    if(articolo != null)
                        articolo.ordina(quantity);
                    else
                        System.out.println("L'articolo non e' presente in lista");
                    break;

                default:
                    System.out.println("Errore");

            }


        }while (scelta != 0);


    }

    public static Articolo creaArticolo() {

        int max = 30;
        int min = 1;

        String nome = InputDati.leggiStringaNonVuota("Nome articolo: ");
        int quantity = (int)Math.floor(Math.random() * (max - min + 1) + min);
        int scortaMinima = InputDati.leggiIntero("Inserisci la soglia minima: ", 0, 10);
        int scortaMassina = InputDati.leggiIntero("Inserisci la soglia massima: ", 40, 50);

        return new Articolo(nome, quantity, scortaMinima, scortaMassina, creaOrario());

    }

    public static Orario creaOrario() {

        int ore = (int)Math.floor(Math.random() * (10 + 1));
        int minuti = (int)Math.floor(Math.random() * (59 + 1));
        int secondi = (int)Math.floor(Math.random() * (59 + 1));

        return new Orario(ore, minuti, secondi);
    }


}
