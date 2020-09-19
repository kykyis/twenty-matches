package ru.kykyis.game.player;

import ru.kykyis.game.Game;
import java.util.Scanner;

public abstract class AbstractPlayer {
    private String name;

    public AbstractPlayer(String name) {
        this.name = name;
    }

    abstract public int turn(Game game, Scanner sc);

    public String getName() {
        return name;
    }

}
