import javafx.scene.paint.Color;
public enum MyColor {
   
    GREY(0.5,0.5,0.5,1),
    
    BLACK(0,0,0,1),
    BLUE(0,0,1,1),
    GREEN(0,1,0,1),
    PINK(0.8,0,0.8,1),
    RED(1,0,0,1),
    AQUA(0,1,1,1),
    OLIVE(0.5,0.5,0,1),
    PERU(0.8,0.5,0.24,1),
    TEAL(0,0.5,0.5,1),
    MAGENTA(1,0,1,1),
    LIME(0,0.8,1,1),
    DARKRED(0.5,0,0,1),
    YELLOW(1,1,0.1,1),
    KHAKI(0.94,0.9,0.54,1),
    LAWNGREEN(0.48,0.98,0,1),
    GOLD(1,0.64,0,1),
    TURQUOISE(0.25,0.87,0.81,1),
    MIDNIGHTBLUE(0.09,0.09,0.43,1),
    SIENNA(0.62,0.32,0.25,1),
    GREENYELLOW(0.67,1,0.18,1),
    STEELBLUE(0.27,0.50,0.70,1),
    DARKGREEN(0,0.39,0,1),
    GOLDENROD(0.85,0.64,0.04,1),
    ORAGNGERED(1,0.27,0,1),
    TOMATO(1,0.38,0.27,1),
    DEEPSKYBLUE(0,0.74,1,1),
    WHITE(1,1,1,1),
    
    ;
    
    private double r,g,b,argb;
    private MyColor(double r, double g, double b,double argb)
    {
        this.r = r;
        this.g = g;
        this.b = b;
        this.argb = argb;
        
    }
    public Color getColor()
    {
       return new Color(r,g,b,argb);
    }
     public static MyColor [] getMyColors()
    {
        return MyColor.values();
    }
          
    
}
