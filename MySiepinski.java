//Author: Eli Fonseca
//draws siepinski's fractal using DrawingPanelPlus
//11/26/15

import java.util.Scanner;
import java.awt.Color;
import java.awt.Point;


public class MySiepinski {

   public static int SIZE;

   /**
   * Entry point of program, where it all begins
   *
   *@param args user input from console
   */
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      explanation();
      do {
         SIZE = Inputter.getNumber(input, "What size window would you like? ", 1, 100);
         SIZE *= 100;
         int level = Inputter.getNumber(input, "What level would you like? ", 1, 100);
         DrawingPanelPlus window = new DrawingPanelPlus(SIZE, SIZE);

         window.setCanvasSize(SIZE, SIZE);
         window.setYscale(0, SIZE);
         window.setXscale(0, SIZE);
         window.clear(Color.BLACK);

         int triangleHeight = (int) (SIZE*Math.sqrt(3.0))/2;
         int sizeFactor = (SIZE-triangleHeight)/2;
         Point a = new Point(0, sizeFactor);
         Point b = new Point(SIZE/2, triangleHeight+sizeFactor);
         Point c = new Point(SIZE, sizeFactor);
         subTriangle(a, b, c, level, window);
      }
      while(again(input));
      System.exit(0);
   }

   public static boolean again(Scanner input) {
      System.out.print("Would you like to draw anything else? ");
      String answer = input.next();
      return answer.startsWith("y") || answer.startsWith("Y");
   }

   public static void explanation() {
      System.out.println("This program generates Siepinski's Sieve");
      System.out.println("a fractal and attractive fixed set with");
      System.out.println("the overall shape of an equilateral triangle");
      System.out.println();
   }

   public static void subTriangle(Point a, Point b, Point c, int level, DrawingPanelPlus window) {
      if(level == 1) {
         Polygon2D poly = new Polygon2D(3);
         poly.addPoint(a.x, a.y);
         poly.addPoint(b.x, b.y);
         poly.addPoint(c.x, c.y);
         Color color = randColor();
         window.setPenColor(color);
         window.filledPolygon(poly);
         //window.setPenRadius(.000001);
         //window.polygon(poly);
      }
      else {
         Point mid1 = midPoint(a,b);
         Point mid2 = midPoint(a,c);
         Point mid3 = midPoint(b,c);

         subTriangle(a, mid1, mid2, level-1, window);
         subTriangle(mid1, b, mid3, level-1, window);
         subTriangle(mid2, mid3, c, level-1, window);
      }
   }

   public static Point midPoint(Point p1, Point p2) {
      Point mid = new Point((p1.x+p2.x)/2, (p1.y+p2.y)/2);
      return mid;
   }

   public static Color randColor() {
      int r = (int) (Math.random()*255);
      int g = (int) (Math.random()*255);
      int b = (int) (Math.random()*255);
      return new Color(r, g, b);
   }
}
