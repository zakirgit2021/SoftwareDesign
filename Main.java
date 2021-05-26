import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application{
   
    @Override
    public void start(Stage stage) {
        // Setting up the display
        Group root = new Group(); // creates root node where all other java classes link back to
       
        Scene scene = new Scene(root); // creates container window where all visuals will appear
        int w = 800, h = 500;
        Canvas canvas = new Canvas(w, h); // creates a canvas of size 800 x 500
        GraphicsContext graphics = canvas.getGraphicsContext2D(); // put all graphics into the canvas
        root.getChildren().add(canvas); // send all children to the canvas
        stage.setScene(scene); // set the scene to display to be the window container

        MyPoint origin = new MyPoint();
        MyPoint mid = new MyPoint(w/2,h/2);
        MyPoint end = new MyPoint(w,h);
        
        MyPoint lt = new MyPoint(0,0);
        MyPoint rt = new MyPoint(w,0);
        MyPoint tm = new MyPoint(w/2,0);
        
        
        int w1 = w/4;
        int h1 = h/4;
        int r = 50;
        
        int radius = 250;
        
        MyOval ov3 = new MyOval(mid,3*w1,3*h1,MyColor.RED);
        
       
        MyRectangle rec3 = new MyRectangle(mid,3*w1,3*h1,MyColor.GREY);
        MyRectangle rec4 = new MyRectangle(mid,4*w1,4*h1,MyColor.BLUE);
       
        MyCircle c1 = new MyCircle(mid,2*r,MyColor.PINK);
        MyCircle c2 = new MyCircle(mid,3*r,MyColor.GREY);
        MyCircle c3 = new MyCircle(mid,r,MyColor.BLACK);
        
        MyPolygon p1 = new MyPolygon(5,2*r,mid,MyColor.YELLOW);
        MyPolygon p2 = new MyPolygon(8,3*r,mid,MyColor.GREEN);
        MyPolygon p3 = new MyPolygon(4,r,mid,MyColor.AQUA);
        MyPolygon p4 = new MyPolygon(8,(5/3)*r,mid,MyColor.BLUE);
        
        MyLine l1 = new MyLine(lt,mid,MyColor.BLACK);
        MyLine l2 = new MyLine(rt,mid,MyColor.BLACK);
        
        
      
        /*
        rec4.draw(graphics);
        rec3.draw(graphics);
        ov3.draw(graphics);
        c2.draw(graphics);
        p2.draw(graphics);
        c1.draw(graphics);
        p1.draw(graphics);
        
        l1.draw(graphics);
        l2.draw(graphics);
        c3.draw(graphics);
        p3.draw(graphics);
        p4.draw(graphics);
        */
        
        
        
    
        
        System.out.println(rec4);
        System.out.println(rec3);
        System.out.println(ov3);
        System.out.println(rec3);
        System.out.println(c2);
        System.out.println(p2);
        System.out.println(c1);
        System.out.println(p1);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(c3);
        System.out.println(p3);
        System.out.println(p4);
         
       //point, radius , startAngle, Angle , color 
       MyArc a1 = new MyArc(mid,200,0,90,MyColor.GREY);
       
       
       
    
       //a1.draw(graphics);
       
       //Slice a1 = new Slice (mid,200,180,90,MyColor.BLUE);
       
        
        
        //Map<Character, Integer> map = hist.getNMostFreqEvents(10);
        //map.forEach((k,v)->System.out.println(k+" : "+v));
        
        
        //hist.probabilities(10);
        
       
        
        //System.out.println(hist.getFreqOfAllEvents());
      
        //System.out.println(hist.getNMostFreqEvents(10));
        
        //System.out.println(hist.getMap());
       // System.out.println(hist.getFreqOfAllEvents());
        
       
        HistogramAlphaBet hist = new HistogramAlphaBet();
        MyPieChart pie = new MyPieChart(hist,26,mid,radius);
        pie.draw(graphics);
        
       
                
        
      stage.show(); // display canvas

    }
    public static void main(String[] args) {
        launch(args);
    } // run the code
}