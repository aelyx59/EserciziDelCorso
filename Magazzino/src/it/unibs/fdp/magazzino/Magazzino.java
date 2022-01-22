package it.unibs.fdp.magazzino;

import java.util.ArrayList;

public class Magazzino {

    private ArrayList<Articolo> articoli;

    public Magazzino() {
        this.articoli = new ArrayList<>();
    }

    public void addArticolo(Articolo a) {
        articoli.add(a);
    }

    public void getDisponibili() {

        if(articoli.isEmpty())
            return;

        ArrayList<Articolo> articoliDisponibili = new ArrayList<>();

        for(Articolo a: articoli) {

            if(cercaArticolo(a) == null)
                return;

            if(!a.esaurito()) {
                articoliDisponibili.add(a);
            }
            else {
                System.out.println("L'articolo " + a.getNome() + "non e' attulamente disponibile, vi preghiamo di attendere");

                a.setQuantity(a.getMaximum()); //l'articolo non era disponibile, lo vado a rimettere nel magazzino assegnando la scorta massima
            }
        }

        print(articoliDisponibili);
    }

    public void print(ArrayList<Articolo> daStampare) {

        for(Articolo a: daStampare) {
            System.out.println("Nome: " + a.getNome() +", quantità disponibile in magazzino: " + a.getQuantity());
        }

    }

    public Articolo cercaArticolo(Articolo a) {

        for(Articolo articolo: articoli) {

            if(a.getNome().equals(articolo.getNome()))
                return articolo;
        }
        return null;
    }

}
