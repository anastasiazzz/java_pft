package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by anastasia.papko on 17.03.2017.
 */
public class DistanceTest {

  @Test
  public void testDistance() {
    Point p2 = new Point (5,5);
    Point p1 = new Point (1, 2);
    Assert.assertEquals(p1.distance(p2), 5.0);
  }

}
