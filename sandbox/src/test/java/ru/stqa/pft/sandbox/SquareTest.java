package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTest {

  @Test
  public void testArea(){
    Square s = new Square(5);
    Assert.assertEquals(s.area(),25.0);
  }

  public void testPointPositive(){
    Point p = new Point(2.0,3.0);
    Assert.assertEquals(p.x, 2.0);
    Assert.assertEquals(p.y, 3.0);
  }
}
