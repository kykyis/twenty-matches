package ru.kykyis.view;

import ru.kykyis.game.Game;
import ru.kykyis.game.player.AbstractPlayer;


public class ConsoleView {

    public static void newGame() {
        System.out.println("Добро пожаловать в игру 20 спичек.");
        System.out.println("Выберите тип игры.");
        System.out.println("1. Player vs Player.");
        System.out.println("2. Computer vs Player.");
        inputHere();
    }
    public static void printStartOfTurn(Game game, AbstractPlayer player) {
        System.out.printf("\nНа столе лежат спички в количестве: %d.\n", game.getMatches());
        System.out.printf("Ходит %s.\n", player.getName());
        System.out.println("Сколько спичек убёрем?");
        inputHere();
    }
    public static void printEndOfTurn(Game game, int value) {
        System.out.printf("Игрок %s забрал спички в количестве %d.\n", game.whoTurns().getName(), value);;
    }
    public static void printPlayerName(int number) {
        System.out.printf("Имя игрока %d.\n", number);
        inputHere();
    }
    public static void errorNumber() {
        System.out.println("Введите корректное число.");
        inputHere();
    }
    public static void errorName(String name) {
        System.out.printf("Имя %s уже занято.\n", name);
        inputHere();
    }

    private static void inputHere() { System.out.print(": "); }
    public static void getWinner(Game game) {
        System.out.printf("\nПобедил игрок %s.\n", game.whoTurns().getName());
    }

}
