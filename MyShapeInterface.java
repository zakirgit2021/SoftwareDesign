import javafx.scene.canvas.GraphicsContext;
/**
 *
 * @author MunerKhan
 */
public interface MyShapeInterface {
    
   public abstract double getArea();
   public abstract double getPerimeter();
   public abstract void draw(GraphicsContext shapeCont);
   public abstract MyRectangle getMyBoundingRectangle();
   public abstract boolean pointInMyShape(MyPoint p);
   public abstract double intersectMyShape(MyShape shape1);
   
   
}
