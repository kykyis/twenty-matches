package ru.kykyis.game.player;

import ru.kykyis.game.Game;
import java.util.Scanner;

public class ComputerPlayer extends AbstractPlayer {
    public ComputerPlayer() {
        super("Компьютер");
        System.out.println("Компьютер");
    }

    @Override
    public int turn(Game game, Scanner sc) {
        int value = game.getMatches() - 17;
        while (value < 1) {
                value += 4 ;
            }
        System.out.println(value);
        return value;
    }
}
