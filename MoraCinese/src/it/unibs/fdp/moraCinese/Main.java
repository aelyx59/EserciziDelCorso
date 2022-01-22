package it.unibs.fdp.moraCinese;

public class Main {

    public static void greeting() {
        System.out.println("Benvenuti in Morra Cinese!");
    }

    public static void main(String[] args) {

        greeting();

        MorraCinese mc = new MorraCinese();
        mc.startGame();

    }


}
