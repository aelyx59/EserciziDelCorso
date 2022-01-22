package it.unibs.fdp.moraCinese;

public class MorraCinese {

    private int punteggioUtente = 0;
    private int punteggioComputer = 0;
    private int nPareggi = 0;
    private int n_partite = 0;

    public MorraCinese() {

    }

    public void startGame() {

        GestisciFile.leggi();

        Utente u = new Utente();
        Computer c = new Computer();

        Move mossaUtente = u.getMove();
        Move mossaComputer = c.getMove();

        System.out.println("\nHai giocato " + mossaUtente);
        System.out.println("Il computer ha giocato " + mossaComputer + "\n");

        int checkMosse = mossaUtente.checkGame(mossaComputer);

        switch (checkMosse) {

            case 0:
                System.out.println("Pareggio");
                nPareggi++;
                break;

            case 1:
                System.out.println(mossaUtente + " sconfigge " + mossaComputer);
                punteggioUtente++;
                break;

            case -1:
                System.out.println(mossaComputer + " sconfigge " + mossaUtente);
                punteggioComputer++;
                break;

            default:
                System.out.println("Errore");

        }

        n_partite++;

        if(u.giocaAncora()) {
            System.out.println("\n");
            System.out.println("Avvio nuova partita");
            startGame();
        }
        else {
            printResults();
            GestisciFile.scrivi(punteggioUtente, punteggioComputer, nPareggi);
        }

    }

    public void printResults() {

        int nVittorie = punteggioUtente;
        int nSconfitte = punteggioComputer;
        int pareggi = n_partite - punteggioComputer - punteggioUtente;

        System.out.println("----------------------------------------");
        System.out.printf("| %10s | %10s | %10s |\n", "VITTORIE", "SCONFITTE", "PAREGGI");
        System.out.println("----------------------------------------");
        System.out.printf("| %10d | %10d | %10d |\n", nVittorie, nSconfitte, pareggi);
        System.out.println("----------------------------------------");

    }



}
