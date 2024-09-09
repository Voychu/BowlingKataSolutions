package org.example;

public class Main {
    public static void main(String[] args) {

        Game game = new Game(args);

        System.out.println("Wyniki poszczególnych tur: " + game.printScoresForIndividualFrames());
        System.out.println("Końcowy wynik: " + game.getTotalScore());
        System.out.println("Koniec");
    }
}