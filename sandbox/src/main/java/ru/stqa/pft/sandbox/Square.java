package ru.stqa.pft.sandbox;

public class Square {
  public double l;

  public Square(double l) { //konstruktor
    this.l = l;
  }

  public double area() { //metoda, każda funckja jest metodą ale metoda nie jest funkcją
    return this.l * this.l;
  }
}
