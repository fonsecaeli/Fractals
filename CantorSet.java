//eli f.
//draws the cantor set 
//11/27/15

public class CantorSet {

   public static final int SIZE = 512;
      
   public static void main(String[] args) {
      DrawingPanelPlus p = new DrawingPanelPlus(SIZE, SIZE);
      p.setCanvasSize(SIZE, SIZE);
      p.setYscale(0,SIZE);
      p.setXscale(0,SIZE);
      double x = 0;
      double y = SIZE-10.0;
      double length = SIZE;
      cantor(x, y, length, p);
   }
   
   public static void cantor(double x, double y, double length, DrawingPanelPlus p) {
      if(length > 1) {
         p.line(x,y,x+length,y);
         
         y -= 20;
         
         cantor(x,y,length/3, p);
         cantor(x+length*2/3, y, length/3, p);
      }
   }
}