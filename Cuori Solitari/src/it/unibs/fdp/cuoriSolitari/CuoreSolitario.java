package it.unibs.fdp.cuoriSolitari;

public class CuoreSolitario {

    public enum ZodiacSign {ARIETE, TORO, GEMELLI, CANCRO, LEONE,
        VERGINE, BILANCIA, SCORPIONE, SAGITTARIO,
        CAPRICORNO, ACQUARIO, PESCI}

    private String name;
    private char sex;
    private int age;
    private int soglia = 30;
    private ZodiacSign sg;
    private ZodiacSign ascendente;

    public CuoreSolitario(String name, char sex, int age, ZodiacSign sg, ZodiacSign ascendente) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.sg = sg;
        this.ascendente = ascendente;
    }

    public String getName() { return name; }

    public char getSex() { return sex; }

    public int getAge() { return age; }

    public ZodiacSign getSg() { return sg; }

    public ZodiacSign getAscendente() { return ascendente; }

    public boolean isAffine(CuoreSolitario cs) {

        if(this.sex != cs.getSex() && Math.abs(this.age - cs.getAge()) < soglia && (this.sg == cs.getAscendente()) && (this.ascendente == cs.getSg()))
            return true;

        return false;
    }


}
