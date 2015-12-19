package com.gax.Helper;

import com.gax.Model.Square;

import java.util.Random;
import java.util.Vector;
import java.util.function.BooleanSupplier;

/**
 * Author: Gác Xanh (phamanh)
 * Date: 19/12/2015
 * Class: OOP2
 * Project: 2048
 */
public final class Utility {
    // random 2 square

    public static void randomSquare(){
        boolean[][] listActive = Square.instanceActive();
        Random rd = new Random();
        Vector<Integer> vector = new Vector<>();
        int a = 0;
        for (int i = 0; i < listActive.length; i++) {
            for (int j = 0; j < listActive[0].length; j++) {
                if (listActive[i][j]) vector.add(a++);
                a++;
            }
        }

        int iNew;
        for (int i = 0; i < 2;) {
            iNew = rd.nextInt(16);
            if (!vector.contains(iNew)) {
                vector.add(iNew);
                Square.getSquareMatrix()[(iNew) / 4][(iNew + 1) % 4].setActive(true);
                i++;
            }
        }
    }
}
