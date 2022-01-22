package it.unibs.fdp.tamaBase;

public class TamaBase {

    private String name;
    private int love;
    private int satiety;

    public TamaBase(String name, int love, int satiety) {
        this.name = name;
        this.love = love;
        this.satiety = satiety;
    }

    public String getName() { return name; }

    public int getLove() { return love; }

    public int getSatiety() { return satiety; }

    public String feed() {

        int n_cookies = InputDati.leggiIntero("Inserisci il numero di biscotti: ", 1, 20);

        if(satiety + n_cookies <= 100)
            satiety = satiety + n_cookies;
        else
            satiety = 100;

        love = love - 5;

        return "La sazieta' del tuo tamagotchi e' " + satiety + ", l'affettivita' e' " + love;

    }

    public String cuddle() {

        int n_cuddles = InputDati.leggiIntero("Inserisci il numero di carezze: ", 1, 20);

        if(love + n_cuddles <= 100)
            love = love + n_cuddles;
        else
            love = 100;

        satiety = satiety - 5;

        return "L'affettivita' del tuo tamagotchi e' " + love + ", la sazieta' e' " + satiety;

    }

    public String getStatus() {

        System.out.printf("Sazieta': %d, affettivita': %d\n", satiety, love);

        boolean felice = satiety >= 80 && love >= 80;
        boolean infelice = satiety <= 30 && love <= 30;
        boolean morto = satiety == 0 && love == 0;
        boolean affamato = satiety == 0 && love >= 30;
        boolean solo = satiety >= 30 && love == 0;
        boolean eccellente = satiety == 100 && love == 100;

        if(felice)
            return "Il tuo tamagotchi e' felice!";

        if(infelice)
            return "Il tuo tamagotchi e' infelice";

        if(morto)
            return "Il tuo tamagotchi e' morto";

        if(affamato)
            return "Il tuo tamagotchi e' affamato";

        if(solo)
            return "Il tuo tamagotchi e' solo";

        if(eccellente)
            return "Il tuo tamagotchi sta alla perfezione";

        return "Il tuo tamagotchi e' stabile";

    }

}
