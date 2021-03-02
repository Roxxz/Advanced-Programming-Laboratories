package com.java;

public class Main {
    public static void main(String[] args) {
        Factory S1 = new Factory();
        Warehouse S2 = new Warehouse();
        Warehouse S3 = new Warehouse();
        Destination D1 = new Destination();
        Destination D2 = new Destination();
        Destination D3 = new Destination();

        Problem p = new Problem();
        int[][] costMatrix = {{2, 3, 1,}, {5, 4, 8}, {5, 6, 8}};
        int[] supplyVector = {10, 35, 25};
        int[] demandVector = {20, 25, 25};
        p.setDim(3);
        p.fill(costMatrix, supplyVector, demandVector);
        p.print();
        p.findCost();
    }
}
