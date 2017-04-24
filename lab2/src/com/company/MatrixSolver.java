package com.company;

import java.util.Random;

/**
 * Created by Evgeniia Zubrich on 25.04.2017.
 */
public class MatrixSolver {
    private int n = 5;
    private long[][] A = new long[n][n];
    MatrixSolver(int n) {
        setN(n);
    }

    public int getN() {
        return n;
    }

    public void setN(int num) {
        n = num;
    }

    private void fillMatrix(long[][] matrix) {
        final Random random = new Random();
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = (long) random.nextInt(50);
    }

    public void printMatrix(long[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j] + "\t");
            System.out.println();
        }
    }
}
