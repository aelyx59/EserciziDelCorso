package it.unibs.fdp.punti_e_rette;

public class Main {

    public static void main(String[] args) {

        System.out.println("Insiersci le coordinate del primo punto");

        double x1 = InputDati.leggiDouble("x1: ");
        double y1 = InputDati.leggiDouble("y1: ");

        System.out.println("Inserisci le coordinate del secondo punto");

        double x2 = InputDati.leggiDouble("x2: ");;
        double y2 = InputDati.leggiDouble("y2: ");;

        Punto p1 = new Punto(x1, y1);
        Punto p2 = new Punto(x2, y2);

        Retta r = new Retta(p1, p2);

        System.out.printf("La distanza tra i due punti e': %.3f\n", p1.calcolaDistanza(p2));
        System.out.println(r.calcolaRetta());

        System.out.println("Inserisci le coordinate di un punto per verificare se e' allineato");

        double x3 = InputDati.leggiDouble("x: ");
        double y3 = InputDati.leggiDouble("y: ");

        Punto p3 = new Punto(x3, y3);
        boolean allineato = r.isAligned(p3);

        //System.out.println("qui");

        System.out.println("Il punto " + (!allineato ? "non e' allineato" : "" + "appartiene alla retta"));





    }
}
