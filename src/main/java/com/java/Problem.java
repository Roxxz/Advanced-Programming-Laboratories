package com.java;

import java.util.Scanner;

public class Problem {
private int dim;
int matrix[][] = new int[3][3];
Problem(){}

    public int getDim() {
        return dim;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }

    public void print(){
        for(int i = 0; i < getDim(); i++){
            for(int j = 0; j < getDim(); j++){
                System.out.println(matrix[i][j] + " ");
            }
        }
    }

    public void fill(){
        matrix[0][0] = 2;
        matrix[0][1] = 3;
        matrix[0][2] = 1;
        matrix[1][0] = 5;
        matrix[1][1] = 4;
        matrix[1][2] = 8;
        matrix[2][0] = 5;
        matrix[2][1] = 6;
        matrix[2][2] = 8;
        }
}
