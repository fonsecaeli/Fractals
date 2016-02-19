//eli f
//dragon curve fractal with drawing panel
//12/25/15

import java.util.Scanner;
import java.awt.Point;

public class Dragon {

   public static final int SIZE = 2000;
   public static final int LEVEL = 5;
   
   public static void main(String[] args) {
      DrawingPanel p = new DrawingPanel(SIZE, SIZE);
      Graphic g = p.getGraphics();
      Point a = new Point(SIZE/2-50,SIZE/2);
      Point b = new Point(SIZE/2+50, SIZE/2);
      drawCurve(p, g, a, b);
   }
   
   public static void drawCurve(DrawingPanel p, Graphics g, Point a, Point b) {
      if(level == 1) {
         draw(p, g);
         return;
      }
      else {
            
      }   
   }
}