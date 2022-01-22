package it.unibs.fdp.aziendaSanitaria;

public class Paziente {

    private String nome;
    private String cognome;
    private String numeroTessera;
    private Medico medico;

    public Paziente(String nome, String cognome, String numeroTessera, Medico medico) {
        this.nome = nome;
        this.cognome = cognome;
        this.numeroTessera = numeroTessera;
        this.medico = medico;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNumeroTessera() {
        return numeroTessera;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return "Paziente: nome: " + nome + ", cognome: " + cognome + ", numero della tessera sanitaria: " + numeroTessera;
    }

    public static boolean checkCodice(String numeroTessera) {

        if(numeroTessera.length() != 20) {
            return false;
        }

        for(int i = 0; i < 20; i++) {

            if(numeroTessera.charAt(i) < '0' || numeroTessera.charAt(i) > '9') {
                return false;
            }
        }

        return true;
    }
}
