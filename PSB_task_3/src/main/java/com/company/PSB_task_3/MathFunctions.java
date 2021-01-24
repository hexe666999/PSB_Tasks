package com.company.PSB_task_3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class MathFunctions {


    public static int [] findPrime (int [] array) {

        ArrayList<Integer> primes = new ArrayList<>();
        int countPrime = 0;
        for (int i = 0; i < array.length; i++) {
            BigInteger bigInteger = BigInteger.valueOf(array[i]);
            if (bigInteger.isProbablePrime((int) Math.log(array[i]))) {
                primes.add(array[i]);
                countPrime++;
            }
        }
        if (countPrime > 0) {
            int[] prime = new int[countPrime];
            for (int i = 0; i < countPrime; i++) {
                prime[i] = primes.get(i);

            }
            return prime;
        } else {
            return new int[]{};
        }
    }

    public static int findMedian(int[] array) {
        int mediana;
        Arrays.sort(array);
        if (array.length % 2 == 1) {
            mediana = array[array.length / 2];
            return mediana;
        } else {
            mediana = (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
            return mediana;
        }
    }

    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    public static int findMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length - 1; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public static int findAvg(int[] array) {

        int result = 0;

        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        result = result/ array.length;
        return result;

    }
}

