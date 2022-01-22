package it.unibs.fdp.tamagotchi;

public class Tamagotchi {

    private String name;
    private double affection;
    private double satiety;
    private int limit = 30;

    public Tamagotchi(String name, double affection, double satiety) {
        this.name = name;
        this.affection = affection;
        this.satiety = satiety;
    }

    public String getName() {
        return name;
    }

    public double getAffection() {
        return affection;
    }

    public double getSatiety() {
        return satiety;
    }

    public String cuddle() {

        int min = 0;
        int max = 20;

        int n_cuddles = (int)Math.floor(Math.random() * (max - min + 1) + min);

        System.out.println("Il numero di coccole che verranno aggiunte e': " + n_cuddles);

        if(affection + n_cuddles <= 100) {
            affection = affection + n_cuddles;
        } else
            affection = 100;

        if(satiety - (n_cuddles / 2) >= 0) {
            satiety = satiety - (double)(n_cuddles / 2);
        } else
            satiety = 0;



        return "Il grado di affettivita' del tuo tamagotchi e' " + affection +"; il livello di sazieta' e' " + satiety;
    }

    public String feed() {

        int min = 0;
        int max = 20;

        int n_cookies = (int)Math.floor(Math.random() * (max - min + 1) + min);

        System.out.println("Il numero di biscotti che verranno dati e': " + n_cookies);

        if(satiety + (n_cookies * 0.1) <= 100) {
            satiety = satiety + (n_cookies * 0.1);
        } else
            satiety = 100;

        if(affection - (n_cookies * 0.25) >= 0) {
            affection = affection - (n_cookies * 0.25);
        } else
            affection = 0;


        return "Il grado di sazieta' del tuo tamagotchi e' " + satiety + "; il grado di affettivia' e' " + affection;
    }

    public String checkStatus() {

        boolean sad =  (affection < limit) || (satiety < limit || satiety > 90);

        if(sad)
            return "il tuo tamagotchi e' infelice";

        return "Il tuo tamagotchi sta bene";

    }

    public boolean toEnd() {

        boolean morto = (satiety == 0 || affection == 0) || satiety == 100;

        if(morto) {
            System.out.println("Il tuo tamagotchi e' morto, hai perso!");
            return true;
        }

        return false;
    }

}
