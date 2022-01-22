package it.unibs.fdp.moraCinese;

public enum Move {

    SASSO, CARTA, FORBICE;

    public int checkGame(Move m) {

        if(this == m)
            return 0;

        switch (this) {

            //ci chiediamo partendo dalla scelta della mossa per la quale l'oggeto nel case vincerebbe
            case SASSO:
                return (m == FORBICE ? 1 : -1);

            case CARTA:
                return (m == SASSO ? 1 : -1);

            case FORBICE:
                return (m == CARTA ? 1 : -1);
        }

        return 0;
    }

}
