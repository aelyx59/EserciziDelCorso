package it.unibs.fdp.punti_e_rette;

import java.text.DecimalFormat;

public class Retta {

    private boolean verticale;
    private double m;
    private double q;

    public Retta(Punto p1, Punto p2) {
        verticale = (p1.getX() == p2.getX());

        if(verticale) {
            q = p1.getX();
        } else {
            m = ((p2.getY() - p1.getY()) / (p2.getX() - p1.getX()));
            q = p2.getY() - (m * p2.getX());
        }
    }

    public String calcolaRetta() {

        StringBuffer sb = new StringBuffer();
        sb.append("L'equazione e': ");

        if(verticale) {
            sb.append(String.format("x = %.2f", q));
        } else {
            if(m == 0) {
                sb.append(String.format("y = %.2f", q));
            } else {
                if(q == 0) {
                    sb.append(String.format("y = %.2f * x", m));
                } else {
                    Character c = (q > 0 ? '+' : '-');
                    sb.append(String.format("y = %.2f * x %c %.2f", m, c,Math.abs(q)));
                }
            }
        }
        return sb.toString();
    }

    public boolean isAligned(Punto p) {
        if(!verticale)
            return p.getY() == (m * p.getX()) + q;

        else
            return q == p.getX();
    }
}
