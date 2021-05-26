import javafx.scene.canvas.GraphicsContext;

public class MyPolygon extends MyShape {
    // Setting variables
    private int N; // Number of the polygon’s equal side lengths and equal interior angles
    private int r; // Radius
    private MyColor color; // Polygon's color (can be any color)
    
    public MyPolygon(int N, int r, MyPoint p, MyColor c) 
    { 
        this.N = N;
        this.r = r;
        this.color = c;
        super.p = p;
    }
    public int getRadius(){return this.r;}
    //getArea — get area of any regular polygon [side_length^2*N) / (4*tan(180/N)]
    @Override
    public double getArea () { return (Math.pow(getSide(),2)*N)/(4*Math.tan(Math.PI/N)) ; }
    // getPerimeter — get perimeter of any regular polygon (#_of_sides*side_length)
    @Override
    public double getPerimeter(){ return N*getSide(); }
    //getAngle — get the interior angle (in degrees) of the polygon [(180*(N-2))/N]
    public double getAngle(){ return (180*(N-2))/N; }
    //getSide — get the polynomial's side length
    public double getSide(){ return (2*r)/Math.sin(Math.PI/N); }
    //toString — displays string showing the polygon's number of sides, side length, interior angle, perimeter, and area;
    @Override
    public String toString() { return "The polygon has "+N+" sides each of length "+getSide()+", an interior angle of "+getAngle()+", a perimeter of "+getPerimeter()+", and an area of "+getArea(); }
    //draw — draws a polygon inscribed in a circle centered at (x, y) and of radius r
    @Override
    public void draw(GraphicsContext hexagon) {
        double[] xValues = new double[N]; // array of all x points
        double[] yValues = new double[N]; // array of all y points
        double angle = Math.toRadians(getAngle()) * N + Math.PI/2; // get the angle to go to the next value
        for(int i = 0; i < N; i++){
            xValues[i] = this.r*Math.cos(angle) + p.getX(); // get the x value of the point
            yValues[i] = this.r*Math.sin(angle) + p.getY(); // get the y value of the point
            angle += 2*(Math.PI/N); // get next angle
        }
        hexagon.setFill(color.getColor()); // fill polygon with specific color from MyColor
        hexagon.fillPolygon(xValues, yValues, N); // fill polygon
    }
    
    
    
  
   @Override
   public MyRectangle getMyBoundingRectangle()
   {
       MyRectangle output = new MyRectangle(this.p,2*this.r,2*this.r,MyColor.BLACK);  
       return output;
   }
   
   @Override
     public boolean pointInMyShape(MyPoint p)
     {
        int x1 = p.getX();
        int y1= p.getY();
        int x = this.p.getX();
        int y = this.p.getY();

        double w = Math.pow(this.r/2,2);
        double h = Math.pow(this.r/2,2);

        double tl = Math.pow(x1-x,2)/w;
        double tr = Math.pow(y1-y,2)/h;
         
       return tl+tr<=1;
     }

     @Override
    public double intersectMyShape(MyShape shape1) {
       return 0;
    }
   
}