package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {
    private String name;
    private int myTurn;
    private final Board board;
    private final Game game;
    private List<Token> tokens = new ArrayList<>();

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public Board getBoard() {
        return board;
    }

    public int getTurn() {
        return myTurn;
    }

    public void setTurn(int turn) {
        this.myTurn = turn;
    }


    protected void waitTurn(int playerIndex) { synchronized (getGame()) {
        getGame().notifyAll();
        while (getGame().getCurrentTurn() != playerIndex && getGame().getCurrentTurn() != -1 ) {
            try {
                getGame().wait();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }
    }

    public synchronized Token extractToken(int playerTurn) {
        if (!tokens.isEmpty()) {
            Token t;
            t = board.tokens.getFirst();
            board.tokens.removeFirst();
            waitTurn();
            System.out.println("Player " + (playerTurn + 1) + " picked " + t);
            return t;
        }
        System.out.println("!!! Game stopped, all tokens consumed and nobody won...");
        board.available = false;
        board.empty=true;
        notifyAll();
        return null;
    }

    @Override
    public void run() {
        while (board.isAvailable()) {

            if (!board.isEmpty()) {
                Token t = extractToken(myTurn);
                tokens.add(t);
                if (tokens.size() > 2) {
                    boolean isProgression = true;
                    int difference = tokens.get(1).getValue() - tokens.get(0).getValue();

                    for (int i = 2; i < tokens.size(); i++)
                        if ((tokens.get(i).getValue() - tokens.get(i - 1).getValue()) != difference) {
                            isProgression = false;
                            break;
                        }
                    if (isProgression)
                        board.win(tokens, myTurn);
                }

            }

        }
    }

    @Override
    public String toString() {
        return "Player='" +
                name + '\'';
    }
}
