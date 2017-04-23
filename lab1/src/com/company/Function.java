package com.company;

/**
 * Created by Evgeniia Zubrich on 23.04.2017.
 */
public class Function {
    public double  Calculate(int m, int n){
        short i,j;
        double s = 0;
        for (i = 0; i < n; ++i){
            for (j = 0; j < m; ++j) {
                if ((j + 1) != 0)
                    s += (i + j) / (j + 1);
            }
        }
        return s;
    }
}
