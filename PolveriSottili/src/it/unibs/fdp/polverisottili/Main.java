package it.unibs.fdp.polverisottili;

import java.util.ArrayList;

public class Main {

    public static void greeting() {
        System.out.println("Benvenuti!");
    }

    private static final String MENU = ""
            + "\r\n>>>>>  MENU  <<<<<\r\n"
            + "0. Esci dal programma\r\n"
            + "1. Controlla\r\n"
            + ">>>>>>    <<<<<<\r\n"
            + "\nScelta: ";

    private static final String SOTTOMENU = ""
            + "\r\n>>>>>>SOTTOMENU<<<<<<\r\n"
            + "2. Controlla il giorno della settimana\r\n"
            + "3. Calcola la media settimanale\r\n"
            + "4. Calcola i dati di una nuova settimana\r\n"
            + "5. Esci dal programma\r\n"
            +">>>>>>>>    <<<<<<<<\r\n"
            + "\nScelta: ";

    public static void goodbye() {
        System.out.println("Arrivederci!");
    }

    public static void main(String[] args) {

        greeting();

        Week week = creaSettimana();

        int scelta;
        String str;

        do {

            scelta = InputDati.leggiIntero(MENU, 0, 1);

            switch (scelta) {

                case 0:
                    goodbye();
                    break;

                case 1:

                    do {

                        scelta = InputDati.leggiIntero(SOTTOMENU, 2, 5);

                        switch (scelta) {

                            case 2:
                                str = week.checkMax();
                                System.out.println(str);
                                break;

                            case 3:
                                str = week.checkMedia();
                                System.out.println(str);
                                break;

                            case 4:
                                creaSettimana();
                                break;

                            case 5:
                                goodbye();
                                break;

                            default:
                                System.out.println("Errore");
                                break;
                        }

                    } while (scelta != 4);

                default:
                    break;

            }

        } while (scelta != 0 && scelta != 5);
    }

    public static Week creaSettimana() {

        int anno = InputDati.leggiIntero("Inserisci l'anno: ", 1, 10000);
        int n_settimana = InputDati.leggiIntero("Inserisci la settimana: ", 1, 52);

        ArrayList<String> days = new ArrayList<>();

        days.add("lunedi'");
        days.add("martedi'");
        days.add("mercoledi'");
        days.add("giovedi'");
        days.add("venerdi'");
        days.add("sabato");
        days.add("domenica");

        ArrayList<Integer> values = new ArrayList<>();

        for(int i = 0; i < days.size(); i++) {

            int value = InputDati.leggiIntero("Inserisci il valore di " + days.get(i) + ": ", 0, 150);
            values.add(value);
        }

        return new Week(anno, n_settimana, values);
    }
}
