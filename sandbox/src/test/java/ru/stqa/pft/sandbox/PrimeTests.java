package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {
  @Test
  public void testNoPrime(){
  Assert.assertFalse(Primes.isNoPrime(50));
  }

  @Test
  public void testPrime(){
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }

  @Test
  public void testPrimeWhile(){
    Assert.assertTrue(Primes.isPrimeWhile(Integer.MAX_VALUE));
  }
}
