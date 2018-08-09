package ru.stqa.pft.sandbox;

public class Primes {
  public static boolean isPrime(int n) {
    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        System.out.println(n + " Is not prime");
        return false;
      }
    }
    System.out.println(n + " Is prime");
    return true;
  }

  public static boolean isNoPrime(int n) {
    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        System.out.println(n + " Is not prime");
        return false;
      }
    }
    System.out.println(n + " Is prime");
    return true;
  }

  public static boolean isPrimeWhile(int n) {
    int i = 2;
    while (i < n && n % i != 0) {
      i++;
    }
    if (i == n) {
      System.out.println(n + " is prime");
      return true;
    } else {
      System.out.println(n + " is not prime");
      return false;
    }
  }
}
