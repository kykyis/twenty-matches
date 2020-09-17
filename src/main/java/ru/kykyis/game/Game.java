package ru.kykyis.game;

import ru.kykyis.game.player.AbstractPlayer;
import java.util.Scanner;

public class Game {
    private int turn = 0;
    private int matches = 20;
    private AbstractPlayer player1;
    private AbstractPlayer player2;

    public Game(AbstractPlayer player1, AbstractPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    // Возвращает либо количество спичек, либо 0, если количество спичек невалидно.
    public int gameTurn(AbstractPlayer player, Scanner sc) throws NumberFormatException {
        return player.turn(this, sc);
    }

    //Меняет количество спичек и передает ход.
    public void changeMatchesAndTurn(int number) {
        this.matches -= number;
        this.turn++;
    }

    //Возвращает игрока, который ходит
    public AbstractPlayer whoTurns() {
        if ((this.turn % 2) == 1) {
            return player2;
        } else { return player1;}
    }

    public int getMatches() {
        return matches;
    }
}
