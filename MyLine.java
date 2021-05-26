import javafx.scene.canvas.GraphicsContext;
public class MyLine extends MyShape{ 
  
    private MyPoint origin,end;
    private MyColor color; // Line's color
    
    public MyLine()
    {
        origin.setX(0); origin.setY(0);
        end.setX(100); end.setY(100);
        this.color = MyColor.BLACK;
        
    }
    //MyLine constructor with parameters given
    public MyLine(MyPoint p1,MyPoint p2, MyColor color)
    {
        this.origin = p1;
        this.end = p2;
        this.color = color;
    }
    
    
    //returns the length of the line formula --> sqrt((x2-x1)^2 +(y2-y1)^2)
    public double getLength()
    {
        return Math.sqrt(Math.pow((end.getX()-origin.getX()),2)+Math.pow((end.getY()-origin.getY()),2));
    }
    //returns angle in degree with respect to the x - axis 
    public double get_xAngle(){return Math.toDegrees(Math.atan2((end.getY()-origin.getY()),(end.getX()-origin.getX()))); }
    //override superclass toString Method 
    
    @Override
    public String toString() 
    { 
        double len = this.getLength();
        double ang = this.get_xAngle();
        return "The endpoints of the line are ("+origin.getX()+","+origin.getY()+") and ("+end.getX()+","+origin.getY()+"). The length of the line is " +len+ ". The angle of the line with the x-axis is " + ang; 
    }
    @Override
    public void draw(GraphicsContext line){
        line.setStroke(color.getColor()); // set line color
        line.setLineWidth(4); // set line width
        line.strokeLine(origin.getX(),origin.getY(),end.getX(),end.getY()); // set line starting and ending points
    }
    
    @Override
    public  MyRectangle getMyBoundingRectangle() {
        
        MyPoint c = new MyPoint(Math.abs((end.getX()-origin.getX())/2),Math.abs(end.getY()-origin.getY())/2);
        
        return new MyRectangle(this.origin,Math.abs(end.getX()-origin.getX()),Math.abs(end.getY()-origin.getY()),color);
    }
    @Override
    public double getArea() { return 0;}
    
    @Override
     public boolean pointInMyShape(MyPoint p)
     {
         return false;
     }
    
     @Override
    public double getPerimeter() {return 0;}
    
    @Override
    public double intersectMyShape(MyShape shape1)
    {
        return 0;
    }

 
    
}