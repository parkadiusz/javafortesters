package ru.stqa.pft.sandbox;

public class DeltaEquation {

  private double a;
  private double b;
  private double c;

  public int n;


  public DeltaEquation(double a, double b, double c) {

    this.a = a;
    this.b = b;
    this.c = c;

    double d = b * b -4 * a * c;

      if (d == 0) {
        n = 1;
      } else {
        if (d > 0) {
          n = 2;
        } else {
          n = 0;
        }
      }
    }
      public int rootNumber(){
        return n;
      }
    }

