public class MyPoint
{
    private int x, y;
    public MyPoint()
    {
        this.x = 0;
        this.y = 0;
    }
    
    public MyPoint(int a, int b)
    {
        this.x = a;
        this.y = b;
    }
    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }
   
    @Override
    public String toString()
    {
        return "("+this.getX()+","+this.getY()+")";
    }
   
    
   
}