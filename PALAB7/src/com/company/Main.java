package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Token> tokens = new ArrayList<>();



        Board board = new Board(30);

        Game game = new Game(30, board.getN(), 5, players, board);
        System.out.println(game);
        game.startGame();
    }
}
