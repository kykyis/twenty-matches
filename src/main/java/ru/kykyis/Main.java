package ru.kykyis;

import ru.kykyis.game.Game;
import ru.kykyis.game.player.*;
import ru.kykyis.view.ConsoleView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsoleView.newGame();
        int intChoice = 0;
        String strChoice="";
        Game game;
        AbstractPlayer player;
        AbstractPlayer player1;
        AbstractPlayer player2;
        Scanner sc = new Scanner(System.in);

        //тип игры

        while ((intChoice != 1) && (intChoice != 2)) {
            try {
                intChoice = Integer.parseInt(sc.nextLine());
            }
            catch (NumberFormatException e) {
                ConsoleView.errorNumber();
                continue;
            }
            if ((intChoice != 1) && (intChoice != 2)) {
                ConsoleView.errorNumber();
            }
        }

        // создаем игроков

        ConsoleView.printPlayerName(1);
        if (intChoice == 1) {
            strChoice = sc.nextLine();
            player1 = new HumanPlayer(strChoice);
        } else {
            player1 = new ComputerPlayer();
        }

        ConsoleView.printPlayerName(2);
        strChoice = sc.nextLine();
        while(player1.getName().equals(strChoice)) {
            ConsoleView.errorName(player1.getName());
            strChoice = sc.nextLine();
        }
        player2 = new HumanPlayer(strChoice);
        // начало игры

        game = new Game(player1, player2);
        while (game.getMatches() > 0) {
            int value = 0;
            player = game.whoTurns();
            ConsoleView.printStartOfTurn(game, player);

            while(value == 0) {
                try {
                    value = game.gameTurn(player, sc);
                }
                catch (NumberFormatException e) {
                    ConsoleView.errorNumber();
                    continue;
                }
                if (value == 0) {
                    ConsoleView.errorNumber();
                }
            }

            ConsoleView.printEndOfTurn(game, value);
            game.changeMatchesAndTurn(value);
        }
        ConsoleView.getWinner(game);
    }
}
