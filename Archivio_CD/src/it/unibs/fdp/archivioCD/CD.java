package it.unibs.fdp.archivioCD;

import java.util.ArrayList;

public class CD {

    private String author;
    private String title;
    private ArrayList<Brano> brani;


    public CD(String author, String title) {
        this.author = author;
        this.title = title;
        this.brani = new ArrayList<>();
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Brano> getBrani() {
        return brani;
    }

    @Override
    public String toString() {
        return "CD: " + title + ", autore: " + author + ", " + brani;
    }

    public void inserisciBrano() {

        String brano = "";
        int n_minuti = 0;
        int n_secondi = 0;

        while(!(brano.equals("-exit"))) {

            brano = InputDati.leggiStringaNonVuota("Inserisci il titolo del brano: ");

            if(brano.equals("-exit")) {
                break;
            } else {
                n_minuti = InputDati.leggiInteroConMinimo("Inserisci i minuti: ", 0);
                n_secondi = InputDati.leggiIntero("Inserisci i secondi: ", 0, 59);

                brani.add(new Brano(n_minuti, n_secondi, brano));

            }
        }

        for(int i = 0; i < brani.size(); i++) {

            /*il toString è per specificare, in realtà Java implicitamente l'avrebbe fatto;
              il fatto che sia stato necessario crecare un toString nella classe brano è perché
              così Java non usa il toString di Object ma quello della classe brano
             */
            System.out.println("\n" + brani.get(i).toString());
        }
    }

    public String randomTrack() {

        int index = (int) (Math.random() * brani.size());

        return "Il brano random e': " + brani.get(index);

    }





}
