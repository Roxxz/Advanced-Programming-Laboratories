package com.java;

import java.util.Arrays;

public class Problem {
    private int dim;
    private static final int LENGTH = 5;
    int[][] matrix = new int[LENGTH][LENGTH];
    int[] supply = new int[LENGTH];
    int[] demand = new int[LENGTH];

    Problem() {}

    public int getDim() {
        return dim;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }

    public void print() {
        for (int i = 0; i < getDim(); i++) {
            for (int j = 0; j < getDim(); j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print('\n');
        }
    }

    public void fill(int[][] matrix, int[] supply, int[] demand) {
        this.matrix = matrix;
        this.supply = supply;
        this.demand = demand;
    }

    /**
     * Iterez prin matrice si salvez in costVector costurile aferente fiecarei linii
     * Sortez vectorul crescator pentru a putea selecta doar cele mai mici costuri
     */
    public void findCost(){
        int[] costVector = new int[LENGTH];
        int cost = 0;
        for (int matrixRow = 0; matrixRow < getDim(); matrixRow++){
            for(int matrixColumn = 0; matrixColumn< getDim(); matrixColumn++){
                costVector[matrixColumn] = supply[matrixRow] * matrix[matrixRow][matrixColumn];
            }
            Arrays.sort(costVector);
            for(int costVectorIt = 0; costVectorIt < getDim(); costVectorIt++){
                if(supply[matrixRow] >= demand[costVectorIt]){
                    cost = cost + costVector[costVectorIt];
                    break;
                }
            }
        }
        System.out.println("The minimum cost of the solution is: " + cost);
    }
}