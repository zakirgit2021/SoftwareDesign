import javafx.scene.canvas.GraphicsContext;
public class MyOval extends MyShape{
    
   MyPoint p;
   int width,height;
   MyColor color;
 
  public MyOval(MyPoint p1, int w, int h, MyColor color){ 
    this.p = p1;
    this.width = w;
    this.height = h;
    this.color = color;
  } 
  
  public void setWidth(int w){this.width = w; }
  public void  setHeight(int h){this.height= h; }
  public void setPoint(MyPoint p ){this.p = p;}
  public void setColor(MyColor c){this.color = c;}
  
  public int getWidth(){return this.width;}
  public int getHeight(){return this.height;}
  @Override
  public double getArea(){ 
    double w = this.width/2; double h= this.height/2;
    return Math.PI*w*h;
   }
  @Override
   public double getPerimeter(){
       double w = Math.pow((this.width/2), 2);  double h = Math.pow((this.height/2), 2); double sum = Math.sqrt((w+h)/2);
       return 2*Math.PI*sum;
   }
  @Override
   public String toString(){ return "The oval has a center point at ("+p.getX()+","+p.getY()+"), a width of " + getWidth() + ", a height of "+getHeight()+", a perimeter of " + getPerimeter() + ", and an area of " + getArea();}
   
  
   
   
   @Override
    public void draw(GraphicsContext MyOval) {
        MyOval.setFill(color.getColor()); // fill circle with specific color from MyColor
        double diameter = this.getWidth();
        double r = diameter/2;
        //getx -r
        MyOval.fillOval(p.getX()-this.width/2,p.getY()-this.height/2, this.width, this.height); // fill an oval with the dimensions MyOval.fillOval(p.getX()-this.width/2,p.getY()-this.height/2, this.width, this.height);
    } 
    
    
    @Override
    public MyRectangle getMyBoundingRectangle()
    {
        MyRectangle output = new MyRectangle(this.p,this.width,this.height,MyColor.BLACK);  
        return output;
    }

     @Override
     public boolean pointInMyShape(MyPoint point)
     {
         //formula x-h/(width/2)^2  + y-k/(height/2)^2
        int x1 = point.getX();
        int y1= point.getY();
        int x = this.p.getX();
        int y = this.p.getY();

        double w = Math.pow(this.width/2,2);
        double h = Math.pow(this.height/2,2);

        double tl = Math.pow(x1-x,2)/w;
        double tr = Math.pow(y1-y,2)/h;
         
       return tl+tr<=1; 
       
     }

     @Override
     public double intersectMyShape(MyShape shape1) {
        return 0;
     }
    
     
    
}   