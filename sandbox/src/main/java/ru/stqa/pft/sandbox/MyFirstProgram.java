package ru.stqa.pft.sandbox;

public class MyFirstProgram {

	public static void main (String[] args ) {
	  hello("Arek");
	  hello("Alexei");

	  double l = 5;
    System.out.println("Powierzchnia o boku " + l + " = " + area(l) );

    double a = 4, b=5;
    System.out.println("Powierzchnia prostokata o bokach " + a + " oraz " + b + " = " + area(a,b));
	}

	public static void hello(String somebody){
    System.out.println("Hello, World! " + somebody );
  }

  public static double area(double len){
	  return len*len;
  }

  public static double area(double a, double b){
	  return a*b;
  }
}