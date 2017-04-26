package com.company;

import java.util.Random;

/**
 * Created by Evgeniia Zubrich on 25.04.2017.
 */
public class MatrixSolver {
    private int n = 5;
    private long[][] A = null;
    private long[][] B = null;
    private long[][] C = null;
    private long sumMax;
    private long sumMin;


    MatrixSolver(int n) {
        if (n < 0) {
            System.out.println("n must be a positive integer");
        } else {
            this.n = n;
            A = new long[n][n];
            B = new long[n][n];
            C = new long[n][n];
            fillMatrix(A);
            fillMatrix(B);
            fillXor(A, B);
        }
    }

    void printMatrices() {
        System.out.println("Matrix A:");
        printMatrix(A);
        System.out.println("\nMatrix B:");
        printMatrix(B);
        System.out.println("\nMatrix C (A xor B):");
        printMatrix(C);
    }

    private void fillXor(long[][] matrixA, long[][] matrixB) {
        if (C.length == matrixA.length && C.length == matrixB.length) {
            for (int i = 0; i < C.length; i++) {
                for (int j = 0; j < C[i].length; j++) {
                    C[i][j] = matrixA[i][j] ^ matrixB[i][j];
                }
            }
        }

    }

    public int getN() {
        return n;
    }

    private void fillMatrix(long[][] matrix) {
        final Random random = new Random();
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = (long) random.nextInt(10);

    }

    private void printMatrix(long[][] matrix) {
        for (long[] a : matrix) {
            for (long b : a)
                System.out.print(b + "\t");
            System.out.println();
        }
    }

    protected void CalculateSums() {
        System.out.println("Calculating...");
        sumMax = 0;
        sumMin = 0;
        long min;
        long max;
        for (int i = 0; i < C.length; i++) {
            min = C[0][i];
            max = C[0][i];
            for (int j = 1; j < C[i].length; j++) {
                if (C[j][i] > max) max = C[j][i];
                if (C[j][i] < min) min = C[j][i];
            }
            if (i % 2 == 0) sumMax += max;
            else sumMin += min;
        }
        System.out.println("The sum of the largest items: " + sumMax);
        System.out.println("The sum of the least items: " + sumMin);
    }
}