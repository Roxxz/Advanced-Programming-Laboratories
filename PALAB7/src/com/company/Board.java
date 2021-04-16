package com.company;

import java.util.LinkedList;
import java.util.List;


public class Board {
    public LinkedList<Token> tokens = new LinkedList<>();
    private int n;
    public volatile boolean available = true;
    public volatile boolean empty = false;

    public Board(int n) {
        for (int i = 1; i <= n; i++) {
            Token t = new Token(i);
            this.tokens.add(t);
        }
        this.n = n;
    }

    public synchronized void win(List<Token> tokens,int playerTurn){
        available = false;
        notifyAll();
        System.out.println("!!! Player " + (playerTurn+1) + " with tokens= " + tokens + " won the game!");
    }

    public synchronized boolean isEmpty() {
        return tokens.isEmpty();
    }

    public synchronized boolean isAvailable() {
        return available;
    }

    public synchronized void setAvailable(boolean available) {
        this.available = available;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "Board{" +
                "tokens=" + tokens +
                '}';
    }
}
