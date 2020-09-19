package ru.kykyis.game.player;

import ru.kykyis.game.Game;
import java.util.Scanner;

public class HumanPlayer extends AbstractPlayer {

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public int turn(Game game, Scanner sc) throws NumberFormatException {
        int value = 0;

        value = Integer.parseInt(sc.nextLine());

        if ((value < 1) || (value > 3) || (game.getMatches() - value) < 0) {
            return 0;
        } else {
            return value;
        }
    }


}
