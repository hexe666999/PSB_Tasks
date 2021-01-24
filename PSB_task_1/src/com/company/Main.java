package com.company;

public class Main {

    public static void main(String[] args) {
        int x1 = Integer.parseInt(args[0]);
        int y1 = Integer.parseInt(args[1]);
        int x2 = Integer.parseInt(args[2]);
        int y2 = Integer.parseInt(args[3]);


        if (x1 != x2 & y1 != y2) {

            System.out.println("Прямоугольник:");
            System.out.println("Периметр = " + Square.calculatePerimeter(Square.calculateSideLenghts(x1, y1, x2, y2)));
            System.out.println("Площадь  = " + Square.calculateSpace(Square.calculateSideLenghts(x1, y1, x2, y2)));
        } else {
            System.out.println("Построить прямоугольник невозможно. Введите другие координаты");
        }
        int circleRadial = Circle.radial(x1, y1, x2, y2);
        System.out.println("Окружность: ");
        System.out.println("Периметр = " + String.format("%.3f", Circle.perimetr(circleRadial)));
        System.out.println("Площадь = " + String.format("%.3f", Circle.space(circleRadial)));
        System.out.println("Диаметр = " + Circle.diameter(circleRadial));
    }


}
