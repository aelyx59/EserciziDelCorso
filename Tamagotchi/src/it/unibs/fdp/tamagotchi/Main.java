package it.unibs.fdp.tamagotchi;

public class Main {

    public static void greeting() {
        System.out.println("Benventui in Tamagotchi!");
    }

    public static void goodbye() {
        System.out.println("Arrivederci!");
    }

    private static final String MENU = ""
            + "\r\n>>>>>  MENU  <<<<<\r\n"
            + "0. Esci dal programma\r\n"
            + "1. Fai le coccole\r\n"
            + "2. Dai dei biscotti\r\n"
            + ">>>>>>    <<<<<<\r\n"
            + "\nScelta: ";

    public static void main(String[] args) {

        greeting();

        Tamagotchi tama = creaTama();

        int azione;
        String status;

        status = tama.checkStatus();
        System.out.println(status);



        do {

            azione = InputDati.leggiIntero(MENU, 0, 2);

            switch(azione) {
                case 0:
                    goodbye();
                    break;

                case 1: String cuddle = tama.cuddle();
                    System.out.println(cuddle);
                    status = tama.checkStatus();
                    System.out.println(status);
                    break;

                case 2: String cookies = tama.feed();
                    System.out.println(cookies);
                    status = tama.checkStatus();
                    System.out.println(status);
                    break;

                default:
                    System.out.println("Errore");
            }

        } while(azione != 0 && tama.toEnd() != true);

    }

    public static Tamagotchi creaTama() {

        String nome = InputDati.leggiStringaNonVuota("Inserisci il nome del tuo Tamagotchi: ");
        int amato = InputDati.leggiIntero("Inserisci il livello di affettivita': ", 0, 100);
        int sazio = InputDati.leggiIntero("Inserisci il livello di sazieta': ", 0, 100);

        return new Tamagotchi(nome, amato, sazio);
    }
}
