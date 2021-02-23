package com.java;

public class Main {
    public static void main(String[] args) {
        Source S1 = new Source();
        Source S2 = new Source();
        Source S3 = new Source();
        Destination D1 = new Destination();
        Destination D2 = new Destination();
        Destination D3 = new Destination();

        Problem p = new Problem();
        p.setDim(3);
        p.fill();
        p.print();
    }
}
