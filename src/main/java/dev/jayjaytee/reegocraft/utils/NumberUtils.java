package dev.jayjaytee.reegocraft.utils;

import java.util.Random;

public class NumberUtils {
    public static boolean ChanceOf(int chance){
        Random r = new Random();
        int rNum = r.nextInt(100) + 1;
        return rNum < chance;
    }
    public static int RandomNumberBetween(int lower, int upper){
        return new Random().nextInt((upper - lower) + 1) + lower;
    }
}
