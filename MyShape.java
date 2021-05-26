import javafx.scene.canvas.GraphicsContext;

public abstract class MyShape implements MyShapeInterface{
 
    
    
   @Override
   public double getArea(){return 0;}
   
   @Override
   public  double getPerimeter(){return 0;}
   
   @Override
   public abstract void draw(GraphicsContext shapeCont);
   
   
   
   @Override
   public MyRectangle getMyBoundingRectangle(){return new MyRectangle();}
   
   
   @Override
   public abstract boolean pointInMyShape(MyPoint p);
   
   
   public abstract double intersectMyShape(MyShape shape1);









//private int x, y; // reference points x and y variables (x,y)
    private MyColor color; //  Mycolor
    MyPoint p;
    
    /*public MyPoint getP() {return this.p;}
    
    
    
    public Color getColor(){ return color.getColor();} 
    
    
    
    public void setP(MyPoint p) { this.p = p; }
    public void setColor(MyColor colorVal) { color = colorVal;} 
    @Override
    public String toString() { return "This space has a width of " + p.getX() + ", a height of " + p.getY() + ", and is of color " + color; } 
    @Override
    public abstract void draw(GraphicsContext shapeCont);
    
    @Override
    public MyRectangle getMyBoundingRectangle(){return new MyRectangle(p,0,0,color);}
    
    */
    
    
    
       
       
      
   
    /*
    @Override
    public double getArea(){return 0;}
    @Override
    public double getPerimeter(){return 0;}
    @Override
    public MyRectangle getMyBoundingRectangle(){return new MyRectangle(p,0,0,color);}
    
    
    public boolean pointInMyShape(MyPoint point)
    {
      return point.getX()==this.p.getX()&&point.getY()==this.p.getY();
    }
   */
}
