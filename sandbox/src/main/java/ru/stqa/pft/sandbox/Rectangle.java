package ru.stqa.pft.sandbox;

public class Rectangle {

  public double a;
  public double b;

  public Rectangle(double a, double b) { //konstruktor
    this.a = a;
    this.b = b;
  }

  public double area() { //metoda
    return this.a * this.b;
  }
}
