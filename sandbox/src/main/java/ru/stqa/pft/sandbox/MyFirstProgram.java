package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    Point p1 = new Point();
    p1.y = 4;
    p1.x = 22;

    Point p2 = new Point();
    p2.y = 8;
    p2.x = 25;
    System.out.println("Расстояние между двумя точками с координатами(x,y): "+"("+p2.x+";"+p2.y+")"+" и "+"("+p1.x+";"+p1.y+")"+" равно "+distance(p1,p2));

    }
  public static double distance(Point p1, Point p2) {
    return Math.sqrt((p2.y-p1.y)*(p2.y-p1.y)+(p2.x-p1.x)*(p2.x-p1.x));
  }
}