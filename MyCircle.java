public class MyCircle extends MyOval{
    
    public MyCircle(MyPoint p1, int r, MyColor color) {
        super(p1, 2*r, 2*r, color);
    }
    @Override
   public String toString(){ return "The Circle has a center point at ("+p.getX()+","+p.getY()+"), a radius of " + getWidth()/2+", a perimeter of " + getPerimeter() + ", and an area of " + getArea();}
   
   public int getRadius()
   {
       return this.getWidth()/2;
   }
     
}