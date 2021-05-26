import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
public class Slice extends MyShape 
{
    private MyPoint center;
    int radius;
    double startAngle;
    double angle;
    double rStartAngle,rAngle,rEndAngle;
    MyColor color;
    
    public Slice(MyPoint p, int r, double startAngle, double angle, MyColor color)
    {
        this.center = p;
        this.radius = r;
        this.startAngle = startAngle;
        this.angle = angle;
        this.color = color;
        
        //angles in radian 
        this.rStartAngle = Math.toRadians(startAngle);
        this.rAngle = Math.toRadians(angle);
    }
    
    //getter methods
    public int getRadius()
    {
        return this.radius;
    }
    public MyPoint getCenter()
    {
        return this.center;
    }
    public double getStartAngle()
    {
        return this.startAngle;
    }
        public double getAngle()
    {
        return this.angle;
    }
    public double getArcLength()
    {
        return (double)radius*rAngle;
    }
    public MyColor getColor()
    {
        return this.color;
    }
    
    public double area ()
    {
        return 0.5*rAngle*Math.pow(radius,2);
    }
    
    public double perimeter()
    {
        return getArcLength();
    }
    
    
     @Override
    public String toString ()
    {
        
       return "Slice centered at ("+center.getX()+","+
                center.getY()+"), with radius "+radius +
                " Starting angle "+startAngle+", Angle "
                +angle+ " and color "+color.getColor();
        
    }
    
    
     public void draw(GraphicsContext GC)
    {
        GC.setFill(color.getColor());
        GC.fillArc(center.getX()-radius,center.getY()-radius, 2*radius, radius, startAngle, angle, ArcType.ROUND);
        
    }
     
     
    @Override // get bounding rectangle
    public MyRectangle getMyBoundingRectangle() 
    {
        double start = startAngle * (Math.PI / 180);
        double end = (startAngle + angle) * (Math.PI / 180);

        MyPoint p1 = new MyPoint((int)(center.getX() + radius * Math.cos(start)),(int)(center.getY() + radius * Math.sin(start))); // get first endpoint
        MyPoint p2 = new MyPoint((int)(center.getX() + radius * Math.cos(end)),(int)(center.getY() - radius * Math.sin(end))); // get second endpoint
        // Getting top left anchoring point
        double x = 0, y = 0;
        // Getting x
        if (startAngle <= 180 && startAngle + angle > 180) x = center.getX() - radius; // left most corner side
        else if (startAngle + angle == 180 && startAngle == 0)
        x = center.getX() - radius; // so values don't get confused
        else 
        { // get minimumx value in arc
            x = (p2.getX() <= p1.getX()) ? p2.getX() : p1.getX();
            x = (center.getX() <= x) ? center.getX() : x;
        }
        // Getting y
        if (startAngle <= 90 && startAngle + angle > 90) y = center.getY() - radius; // top most corner
        else if (p2.getY() == center.getY()) y = p1.getY() - 2 * (p1.getY() - p2.getY());
        else 
        {
            y = (p2.getY() <= p1.getY()) ? p2.getY() : p1.getY();
            y = (center.getY() <= y) ? center.getY() : y;
        }
        if (startAngle >= 180) y = center.getY(); // making sure y isn't too low
        MyPoint topLeft = new MyPoint((int)x,(int)y);
        // Getting W & H
        double w = 0, h = 0, h2 = 0;
        // Getting W
        if (startAngle == 0 || startAngle == 360) w = center.getX() + radius;
        else if (startAngle + angle == 360) w = center.getX() + radius;
        else {
        w = (p2.getX() < p1.getX()) ? p1.getX() : p2.getX();
        w = (center.getX() <= w) ? w : center.getX();
        }
        w -= x;
        // Getting H
        if (startAngle < 270 && startAngle+angle > 270) h =
        center.getY() + radius;
        else {
        h = (p2.getY() < p1.getY()) ? p1.getY() : p2.getY();
        h = (center.getY() < h) ? h : center.getY();
        }
        // making sure that h is not too high or too low
        if (startAngle < 180 && h > radius) h = center.getY()-topLeft.getY();
        else if (startAngle >= 180 && h > radius) h = radius;

        MyPoint p = new MyPoint ((int)(topLeft.getX()+radius/2),(int)(topLeft.getY()));

        return new MyRectangle(p, (int)w,(int)h, MyColor.BLACK);
    } 

    
     
    @Override
    public boolean pointInMyShape(MyPoint p) 
    {
        int x1 = center.getX();
        int y1= center.getY();
        int x = this.p.getX();
        int y = this.p.getY();

        double w = Math.pow(this.radius,2);
        double h = Math.pow(Math.cos(this.angle),2);

        double tl = Math.pow(x1-x,2)/w;
        double tr = Math.pow(y1-y,2)/h;

       return tl+tr<=1;
    }

    @Override
    public double intersectMyShape(MyShape shape1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
