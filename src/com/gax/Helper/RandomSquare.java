package com.gax.Helper;

import java.util.Random;
import java.util.Vector;

/**
 * Author: Gác Xanh (phamanh)
 * Date: 19/12/2015
 * Class: OOP2
 * Project: 2048
 */
public final class RandomSquare {
    public static int[][] randomSquare(int[][] squareMatrix){
        Random rd = new Random();
        Vector<Integer> vector = new Vector();

        int a = -1;
        for (int i = 0; i < squareMatrix.length; i++) {
            for (int j = 0; j < squareMatrix[0].length; j++) {
                if (squareMatrix[i][j] == 0){
                    a++;
                }
            }
        }
        return squareMatrix;
    }
}
