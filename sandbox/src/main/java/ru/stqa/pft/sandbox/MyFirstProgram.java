package ru.stqa.pft.sandbox;

import java.util.Scanner;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("Arek");
    hello("Alexei");

    Square s = new Square(50); //budowanie obiektu
    System.out.println("Powierzchnia o boku " + s.l + " = " + s.area());
    //s. odwoływanie się do odpiedniej zmiennej lub metody w kalsie

    Rectangle r = new Rectangle(10, 15);
    System.out.println("Powierzchnia prostokata o bokach " + r.a + " oraz " + r.b + " = " + r.area());

    //homework 2
    System.out.println("Podaj współrzędne: ");
    Scanner in = new Scanner(System.in);
    int x1 = in.nextInt();
    int x2 = in.nextInt();
    Point p1 = new Point(x1, x2);
    Point p2 = new Point(5, 9);

    System.out.println("Distance between points (" + p1.x + "," + p1.y + ") and (" + p2.x + "," + p2.y + ") is " + p1.distance(p2));
    //System.out.println(p1.distance(p2));
  }

  public static void hello(String somebody) {
    System.out.println("Hello, World! " + somebody);
  }
}