package com.company;

public class Circle {

    public static int radial (int x1, int y1, int x2, int y2){

        return  (int) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    public static double perimetr (int radial){
        return radial * 2 * 3.1415;
    }

    public static double space (int radial){
        return radial * radial * 3.1415;
    }

    public static int diameter (int radial){
        return radial * 2;
    }





}
