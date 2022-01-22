package it.unibs.fdp.archivioCD;

import java.util.ArrayList;
import java.util.Random;

public class Collezione {

    private ArrayList<CD> collezione;

    public Collezione() {
        this.collezione = new ArrayList<>();
    }

    public int cerca(String str) {

        if(collezione.isEmpty())
            return -1;

        for(int i = 0; i < collezione.size(); i++) {

            if(str.equals(collezione.get(i).getTitle())) {
                return i;
            }
        }
        return -1;
    }


    public void creaCD() {

        String author = InputDati.leggiStringaNonVuota("Inserisci il nome dell'autore: ");
        String title = InputDati.leggiStringaNonVuota("Inserisci il titolo del CD: ");

        if(cerca(title) != -1) {
            System.out.println("Attenzione: titolo gia' inserito!");
        } else {
            System.out.println("---------------------------");
            System.out.println("Scrivere -exit per uscire\n");

            CD cd = new CD(author, title);

            cd.inserisciBrano();
            collezione.add(cd);
        }


    }

    public void stampaCD() {

        String str = InputDati.leggiStringaNonVuota("Inserisci il nome del CD: ");

        int i = cerca(str);

        if(i != -1) {
            System.out.println(collezione.get(i));
        } else
            System.out.println("Non e' stato trovatonessun CD con questo nome");
    }

    public void rimuovi() {

        String str = InputDati.leggiStringaNonVuota("Inserisci il nome del CD: ");

        int i = cerca(str);

        if(i != -1) {
            collezione.remove(i);

            char scelta = InputDati.leggiUpperChar("Sei sicuro di voler rimuovere il CD (S = si, N = no)? ", "SN");

            if(scelta == 'S') {

                for(int j = 0; j < collezione.size(); j++) {
                    System.out.println(collezione.get(j));
                }

                System.out.println("Rimozione avvenuta con successo");
            } else
                System.out.println("Errore");

        } else {
            System.out.println("Non e' stato trovato nessun CD con questo nome");
        }
    }


    public void printCollection() {

        if(collezione.isEmpty())
            return;

        int counter = 0;

        for(int i = 0; i < collezione.size(); i++) {

            counter++;
            System.out.println(counter + ". " + collezione.get(i) + "\n");
        }

    }

    public void randomCD() {

        int index = (int)(Math.random() * collezione.size());
        CD cd = collezione.get(index);

        System.out.println("Il CD random e' " + cd);
        System.out.println(cd.randomTrack());

        /*int indice = (int)(Math.random() * cd.getBrani().size());
        Brano brano = cd.getBrani().get(indice);

        System.out.println("Il brano random e' "+ brano);*/


    }



}
