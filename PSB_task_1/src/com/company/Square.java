package com.company;

public class Square {
    public static int[][] coordinates = new int[4][2];


    public static int[] calculateSideLenghts(int x1, int y1, int x2, int y2) {

        int sides[] = new int[2];

        if (x2 > x1) {
            sides[0] = x2 - x1;
        } else {
            sides[0] = x1 - x2;
        }
        if (y2 > y1) {
            sides[1] = y2 - y1;
        } else {
            sides[1] = y1 - y2;
        }
        return sides;
    }

    public static int calculatePerimeter(int[] lengths) {

        return (lengths[0] + lengths[1]) * 2;
    }

    public static int calculateSpace(int[] lengths) {

        return lengths[0] * lengths[1];
    }
}
