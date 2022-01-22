package it.unibs.fdp.moraCinese;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestisciFile {

    public static void scrivi(int nVittorie, int nSconfitte, int nPareggi)  {

        try {
            FileWriter myWriter = new FileWriter("risultati.txt");
            myWriter.write("Vittorie: " + nVittorie + ", Sconfitte: " + nSconfitte + ", Pareggi: " + nPareggi);
            myWriter.close();

        } catch (IOException e) {
            System.out.println("Si e' verificato un errore");
            e.printStackTrace();
        }
    }

    public static void leggi() {

        try {
            Scanner file = new Scanner(new FileReader("risultati.txt"));
            String s = file.next();
            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
