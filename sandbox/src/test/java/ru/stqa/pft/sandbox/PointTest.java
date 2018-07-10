package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {


  public Point p1 = new Point(2, 5);
  public Point p2 = new Point(5, 9);

  @Test
  public void testPointCheck(){
    Assert.assertEquals(p1.x, 2.0);
    Assert.assertEquals(p1.y, 5.0);
    Assert.assertEquals(p2.x, 5.0);
    Assert.assertEquals(p2.y, 9.0);
  }

  @Test
  public void testDistanceNegative(){
    Assert.assertNotEquals(p1.distance(p2), 6.0);
  }

  @Test
  public void testDistancePositive(){
    Assert.assertEquals(p1.distance(p2), 5.0);
  }




}
