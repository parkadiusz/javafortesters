package ru.stqa.pft.sandbox;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


public class Point {
  // class body
  public double x;
  public double y;

  // constructor
  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }


  public double distance(Point p2) {
    double px = this.x - p2.x;
    double py = this.y - p2.y;

    return sqrt(pow(px, 2) + pow(py, 2));
  }

}