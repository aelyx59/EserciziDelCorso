package it.unibs.fdp.cuoriSolitari;



public class Main {

    public static void greeting() {
        System.out.println("Benvenuti! testate ora la vostra compatibilita'! ");
    }
    public static void goodbye() { System.out.println("\n\nArrivderci!"); }

    public static void main(String[] args) {
        greeting();

        CuoreSolitario c1 = creaPersona();

        System.out.println("------------------");

        CuoreSolitario c2 = creaPersona();

        boolean affini = c1.isAffine(c2);
        boolean idonei = checkAge(c1, c2);

        if(idonei) {
            System.out.println("\n...processing...");
            System.out.println("\n>> I due cuori " + (!affini ? "non sono compatibili" : "sono affini"));
        } else {
            System.out.println("Errore!!!");
        }

        goodbye();
    }

    public static CuoreSolitario creaPersona() {

        String name = InputDati.leggiStringaNonVuota("Inserisci il nome: ");
        char sesso = InputDati.leggiUpperChar("Inserisci il sesso: ", "MF".toUpperCase());
        int anni = InputDati.leggiIntero("Inserisci l'eta': ");

        CuoreSolitario.ZodiacSign sgn = CuoreSolitario.ZodiacSign.valueOf(InputDati.leggiStringa("Inserisci il segno zodiacale: ").toUpperCase());
        CuoreSolitario.ZodiacSign ascendente = CuoreSolitario.ZodiacSign.valueOf(InputDati.leggiStringa("Inserisci il segno zodiacale ascendente: ").toUpperCase());

        return new CuoreSolitario(name, sesso, anni, sgn, ascendente);
    }

    public static boolean checkAge(CuoreSolitario cs1, CuoreSolitario cs2 ) {

        if((cs1.getAge() > 18 && cs2.getAge() > 18) && (cs1.getAge() < 120 && cs2.getAge() < 120)) {
            System.out.println("\nI due giocatori possono partecipare!");
            return true;
        } else if((cs1.getAge() > 18 && cs1.getAge() < 120) && (cs2.getAge() < 18 || cs2.getAge() > 120)) {
             System.out.println("\nIl secondo giocatore non puo' partcipare");
            return false;
        } else if ((cs1.getAge() < 18 || cs1.getAge() > 120) && (cs2.getAge() > 18 && cs2.getAge() < 120)) {
            System.out.println("\nIl primo giocatore non puo' partecipare");
            return false;
        }else{
            if((cs1.getAge() < 18 && cs2.getAge() < 18) && (cs1.getAge() > 120 && cs2.getAge() > 120)) {
                System.out.println("\nNessuno dei due giocatori puo' partecipare");
                return false;
            }
        }
        return false;
    }

}
