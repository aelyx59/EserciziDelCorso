package it.unibs.fdp.tamaBase;

public class Main {

    public static void greeting() {
        System.out.println("Benvenuti in TamaBase!");
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

        TamaBase tb = creaTama();

        int azione;
        String status;

        status = tb.getStatus();
        System.out.println(status);

        do {

            azione = InputDati.leggiIntero(MENU, 0, 2);

            switch(azione) {
                case 0:
                    goodbye();
                    break;

                case 1: String cuddle = tb.cuddle();
                    System.out.println(cuddle);
                    status = tb.getStatus();
                    System.out.println(status);
                    break;

                case 2: String cookies = tb.feed();
                    System.out.println(cookies);
                    status = tb.getStatus();
                    System.out.println(status);
                    break;

                default:
                    System.out.println("Errore");
            }

        } while(azione != 0);


    }

    public static TamaBase creaTama() {

        String nome = InputDati.leggiStringaNonVuota("Inserisci il nome del tuo tamagotchi: ");
        int affetto = InputDati.leggiIntero("Inserisci il livello affettivo del tuo tamagotchi: ", 0, 100);
        int fame = InputDati.leggiIntero("Inserisci il livello di sazieta' del tuo tamagotchi: ", 0, 100);

        return new TamaBase(nome, affetto, fame);
    }
}
