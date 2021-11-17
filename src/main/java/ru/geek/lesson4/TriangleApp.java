package ru.geek.lesson4;

import java.lang.IllegalArgumentException;


public class TriangleApp {
    private int a, b, c;
    public TriangleApp(int a, int b, int c) throws IllegalArgumentException {
        if (!this.isPossible(a, b, c)) throw new IllegalArgumentException("Не верный треугольник");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private boolean isPossible(int a, int b, int c) {
        if ((a <= 0) || (b <= 0) || (c <= 0)) return false;
        if ((a + b <= c) && (a + c <= b) && (b + c <= a)) return false;
        return true;
    }

    public double area() {
        double s = (double) (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}