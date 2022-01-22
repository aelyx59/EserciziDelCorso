package it.unibs.fdp.moraCinese;

import java.util.Random;

public class Computer {

    public Move getMove() {

        Move[] moves = Move.values();
        Random r = new Random();

        int i = r.nextInt(moves.length);

        return moves[i];
    }
}
