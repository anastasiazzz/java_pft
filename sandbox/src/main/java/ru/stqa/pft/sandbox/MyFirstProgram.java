package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    Point p1 = new Point(4,22);

    Point p2 = new Point(8,25);
    System.out.println("Расстояние между двумя точками с координатами(x,y): "+"("+p2.x+";"+p2.y+")"+" и "+"("+p1.x+";"+p1.y+")"+" равно "+p1.distance(p2));
   // System.out.println("Расстояние между двумя точками с координатами(x,y): "+"("+p2.x+";"+p2.y+")"+" и "+"("+p1.x+";"+p1.y+")"+" равно "+distance(p1,p2));

    }


}
