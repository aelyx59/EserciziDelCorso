package it.unibs.fdp.polverisottili;

import java.util.ArrayList;

public class Week {

    public static final int SOGLIA = 75;
    public static final int LIMITE = 50;

    private int year;
    private int n_week;
    private ArrayList<Integer> values;



    public Week(int year, int n_week, ArrayList<Integer> values) {
        this.year = year;
        this.n_week = n_week;
        this.values = values;
    }

    public int getYear() {
        return year;
    }

    public int getN_week() {
        return n_week;
    }

    public String checkMax() {

        ArrayList<String> days = new ArrayList<>();

        days.add("lunedi'");
        days.add("martedi'");
        days.add("mercoledi'");
        days.add("giovedi'");
        days.add("venerdi'");
        days.add("sabato");
        days.add("domenica");

        ArrayList<String> giorni_alti = new ArrayList<>();

        int i = 0;

        for(int j = 0; j < days.size(); j++) {

            if(values.get(i) >= SOGLIA) {

                giorni_alti.add(days.get(i));
            }

            i++;
        }

        return "Il/I giorno/i con il/i valore/i più alto/i della settimana e'/sono " + giorni_alti;
    }

    public String checkMedia() {

        int somma = 0;
        int n_giorni = 7;
        double media;

        for(int i = 0; i < values.size(); i++) {
            somma = somma + values.get(i);
        }

        media = (double) somma / n_giorni;

        System.out.printf("La media e' %.2f ", media);

        if(media > LIMITE)
            return "La media settimanale e' troppo alta";

        return "Tutto e' nella norma";

    }
}
