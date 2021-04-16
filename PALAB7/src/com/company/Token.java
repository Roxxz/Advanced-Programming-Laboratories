package com.company;


public class Token{
    private int value;

    public Token(int token) {
        this.value = token;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int token) {
        this.value = token;
    }

    @Override
    public String toString() {
        return "Token=" +
                value;
    }
}
