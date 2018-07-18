package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeltaEquationTest {

  @Test
  public void testDeltaEquation0(){
    DeltaEquation d = new DeltaEquation(1, 1, 1);
    Assert.assertEquals(d.rootNumber(),0);
  }

  @Test
  public void testDeltaEquation1(){
    DeltaEquation d = new DeltaEquation(1, 2, 1);

    Assert.assertEquals(d.rootNumber(),1);
  }

  @Test
  public void testDeltaEquation2(){
    DeltaEquation d = new DeltaEquation(1, 5, 6);

    Assert.assertEquals(d.rootNumber(),2);
  }
}
