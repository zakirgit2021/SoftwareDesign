import javafx.scene.canvas.GraphicsContext;
public class MyRectangle extends MyShape{
    
    private MyPoint p;
    private int width, height;
    private MyColor color;
    //default constructor 
    public MyRectangle()
    {
        p.setX(500);
        p.setY(500);
        this.width = 100;this.height = 100;
        
    }
    public MyRectangle (MyPoint p1,int width,int height,MyColor color)
    {
        this.p = p1;
        this.width = width;this.height = height;
        this.color = color;
    }
    //getter method
    public int getWidth(){return this.width;}
    public int getHeight(){return this.height;}
    public int getX(){return p.getX();}
    public int getY(){return p.getY();}
    @Override
    public double getPerimeter(){return 2*width+2*height;}
    @Override
    public double getArea(){return width*height;}
    @Override
    public String toString(){
        int xc= getX()-this.width/2;
        int yc= getY()-this.height/2;
        return ("The reactangle is at ("+xc+","+yc+") has width "+width+", Height "+height+" perimeter of "+this.getPerimeter()+", and Area of "+this.getArea() );}
    @Override
    public void draw(GraphicsContext rectangle){
        
        int w = this.width;int h = this.height;
        rectangle.setFill(color.getColor()); // fill rectangle with specific color from MyColor
        rectangle.fillRect(p.getX()-w/2, p.getY()-h/2, w, h);
        
    }
    
    
   @Override
   public MyRectangle getMyBoundingRectangle()
   {
       MyRectangle output = new MyRectangle(this.p,this.width,this.height,this.color);  
       return output;
   }
   
    @Override
    public boolean pointInMyShape(MyPoint point)
    {
        int x1 = point.getX();
        int y1 = point.getY();
        int x = this.p.getX()-this.width/2;
        int y = this.p.getY()-this.height/2;
        if (x1>x &&x1<x+width && y1>y &&y1<y+height)
        {
            return true;
        }
        return false;
    }
    
    

    @Override
    public double intersectMyShape(MyShape shape1) {
       return 0;
    }

    
    
    
} 