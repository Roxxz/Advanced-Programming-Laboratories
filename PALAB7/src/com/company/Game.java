package com.company;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Game {
    private int m;
    private int n;
    private int k;
    private LinkedList<Player> players;
    private Board board;

    public Game(int m, int n, int k, LinkedList<Player> players, Board board) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.players = players;
        this.board = board;
    }

    public void startGame() {
        List<Integer> randomIndexes = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            players.get(i).setTurn(i);
            new Thread(players.get(i)).start();
        }
    }



    @Override
    public String toString() {
        return "Game{" +
                "\nm=" + m +
                ", n=" + n +
                ", k=" + k +
                ", \nplayers=" + players +
                ", \nboards=" + board +
                '}';
    }
}
