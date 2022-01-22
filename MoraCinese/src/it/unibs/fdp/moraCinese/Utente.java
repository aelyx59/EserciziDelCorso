package it.unibs.fdp.moraCinese;

import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Utente {

    private Scanner scanner;

    public Utente() {
        this.scanner = new Scanner(System.in);
    }

    public Move getMove() {

        System.out.println("Sasso, Carta, Forbici?");

        String scelta = scanner.nextLine();
        scelta = scelta.toUpperCase();

        char firstletter = scelta.charAt(0);

        if(firstletter == 'S' || firstletter == 'C' || firstletter == 'F') {

            switch (firstletter) {

                case 'S':
                    return Move.SASSO;

                case 'C':
                    return Move.CARTA;

                case 'F':
                    return Move.FORBICE;

                default:
                    System.out.println("Errore");

            }
        }

        return getMove();
    }

    public boolean giocaAncora() {

        System.out.println("Vuoi giocare ancora?");
        String answer = scanner.nextLine();
        answer = answer.toUpperCase();

        return answer.charAt(0) == 'Y';

    }
}
