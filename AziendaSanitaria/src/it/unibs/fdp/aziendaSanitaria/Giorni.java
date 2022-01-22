package it.unibs.fdp.aziendaSanitaria;

public enum Giorni {

    LUNEDI, MARTEDI, MERCOLEDI, GIOVEDI, VENERDI, SABATO, DOMENICA;

    public static Giorni getDay(String giorno) {
        return valueOf(giorno.toUpperCase());
    }

    public static Giorni getRestDay() {
        return values() [(int)Math.floor(Math.random() * values().length)];
    }

}
