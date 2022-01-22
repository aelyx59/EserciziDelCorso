package it.unibs.fdp.aziendaSanitaria;

import java.util.ArrayList;
import java.util.Random;

public class AziendaSanitaria {

    private String nome;
    private String descrizione;
    private ArrayList<Medico> elencoMedici;
    private ArrayList<Paziente> elencoPazienti;

    public AziendaSanitaria(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.elencoMedici = new ArrayList<>();
        this.elencoPazienti = new ArrayList<>();
    }

    public Medico getMedicoDisponibile(Giorni giorno) {

        Medico m = null;
        for(int i = 0; i < elencoMedici.size(); i++) {
            if(!elencoMedici.get(i).isResting(giorno) && elencoMedici.get(i).getPazienti().size() < 3) {
                m = elencoMedici.get(i);
                break;
            }
        }
        return m;
    }

    public void inserisciMedico(Medico m) {
        elencoMedici.add(m);

        System.out.println(m + "\n");
    }

    public void inserisciPaziente(Paziente p) {

        if(p.getMedico() == null) {
            System.out.println("Non ci sono medici");
            return;
        }

        elencoPazienti.add(p);
        System.out.println("Il paziente " + p.getCognome() + " " + p.getNome() + " e' stato assegnato al medico " + p.getMedico().getCognome() + " " + p.getMedico().getNome());
        p.getMedico().addPaziente(p);

    }


    public void ricercaMedicoCodice(String code) {

        for(Medico m: elencoMedici) {

            if(m.getCodice().equals(code)) {
                System.out.println(m);
                m.printPazienti();
            }
        }
    }

    public ArrayList<Medico> ricercaMedicoGiorno(Giorni giorno) {

        ArrayList<Medico> mediciDisponibili = new ArrayList<>();

        for(Medico m: elencoMedici) {
            if(!m.isResting(giorno))
                mediciDisponibili.add(m);
        }

        return mediciDisponibili;
    }

    public Paziente ricercaPaziente(String nTessera) {

        for(Paziente p: elencoPazienti) {

            if(p.getNumeroTessera().equals(nTessera)) {

                System.out.println(p);
                System.out.println(p.getMedico());
                return p;
            }
        }

        return null;
    }

    public boolean isUnicoCodice(String codice) {

        for(Medico m: elencoMedici) {
            if(m.getCodice().equals(codice)) {
                return false;
            }
        }
        return true;
    }

    public boolean isUnicoPazinete(String nTessera) {

        for(Paziente p: elencoPazienti) {
            if(p.getNumeroTessera().equals(nTessera))
                return false;
        }
        return true;
    }


    public void riassegnaPaziente(String codiceTessera, Giorni g) {

        Paziente p = ricercaPaziente(codiceTessera);

        if(p == null) {
            System.out.println("Codice tessera invalido o inesistente");
            return;
        }

        Medico m = p.getMedico();

        m.getPazienti().remove(p);

        Medico medico;
        int counter = 0;

        do{
            medico = nuovoMedico(g);

            if(counter > 1000) {
                System.out.println("Errore: impossibile trovare un medico");
                return;
            }

            counter++;

        } while(m.equals(medico));

        m.getPazienti().add(p);
        p.setMedico(medico);

        System.out.println("Il paziente " + p.getCognome() + " " + p.getNome() + " e' stato riassegnato al medico " + medico.getCognome() + " " + medico.getNome());
    }

    public Medico nuovoMedico(Giorni g) {

        Random r = new Random();
        Medico m;

        int index;

        do {
             index = r.nextInt(elencoMedici.size());
             m = elencoMedici.get(index);

        } while(m.isResting(g) || m.getPazienti().size() >= 3);

        return m;
    }

}
