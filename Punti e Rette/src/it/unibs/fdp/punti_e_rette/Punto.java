package it.unibs.fdp.punti_e_rette;

public class Punto {

    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double calcolaDistanza(Punto p) {

        double distanza = Math.sqrt((Math.pow((p.getX() - x), 2) + Math.pow((p.getY() - y), 2)));

        return distanza;
    }


}
