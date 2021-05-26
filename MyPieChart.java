import java.util.HashMap;
import javafx.scene.canvas.GraphicsContext;
import java.util.Map;

public class MyPieChart {
private HistogramAlphaBet histogram; // histogram of text


private int n; // number of most freq characters
private MyPoint center; // center point of pie chart
private int r; // pie chart's radius
private double angle;
private double startingAngle;

Map<Character, Integer> map;//map of all the most freq n letters 
private int total;     // total freq
Map<String, Integer> gMAP;
//accepts histogram, n is the number slices 
public MyPieChart(HistogramAlphaBet histogram, int n, MyPoint center,int radius)
{
    this.histogram = histogram;
    this.n = n;
    this.center = center;
    this.r = radius;
    this.total = histogram.getFreqOfAllEvents();
    this.map = histogram.getNMostFreqEvents(n);
    this.startingAngle = 0;

}
public void draw(GraphicsContext arc) 
{
    map = histogram.getNMostFreqEvents(n);
    startingAngle = 0;
    Slice s;
    int sum = 0; // sum of the n most frequencies 
    
    double prob;
    int count = 0;
    int space = 14;
    
    for (Map.Entry<Character,Integer> entry:map.entrySet()) 
    {
        if (count >= n) break; 
        sum+=entry.getValue();
        prob = (double)entry.getValue()/total;
        angle = prob*360;
        s = new Slice (this.center,this.r,startingAngle,angle,MyColor.values()[count]);
        startingAngle+=angle;
        s.draw(arc);
        
        System.out.println(s);
        
        arc.fillText(entry.getKey()+ ", " + (float)entry.getValue()/total, this.n, space);
        
        // this displays the frequency of each letter on the right side of the window.
        arc.fillText(entry.getKey()+ ", " +entry.getValue(), 1.8*center.getX(), space);
        //space = space between letters 
        space+=14;
        count++;
        
    }
    
    
    int allOther = (total-sum);
    prob = (double)allOther/total;
    
    angle = prob*360;
    
    s = new Slice (this.center,this.r,startingAngle,angle,MyColor.values()[count]);
    s.draw(arc);
    arc.fillText("All Other Letters "+(float)allOther/total, this.n, space);
   
    
    System.out.println(s);
    
    
}


public MyPieChart (Map<String, Integer> map,int n, MyPoint center,int radius)
{
    this.n = n;
    this.center = center;
    this.r = radius;
    this.gMAP = map;
    this.startingAngle = 0;
    
}

public void Draw(GraphicsContext arc) 
{
    Slice s;
    int count = 0;
    int sum = 0;
    double prob;
    int space = 14;
    int t = 0;
    for (Map.Entry<String,Integer> entry:gMAP.entrySet()) 
    {
        t+=entry.getValue();
    }
    
    
    
    for (Map.Entry<String,Integer> entry:gMAP.entrySet()) 
    {
        if (count >= n) break; 
        sum+=entry.getValue();
        prob = (double)entry.getValue()/t;
        angle = prob*360;
        s = new Slice (this.center,this.r,startingAngle,angle,MyColor.values()[count]);
        startingAngle+=angle;
        s.draw(arc);
        
        System.out.println(s);
        
        arc.fillText(entry.getKey()+ ", " + (float)entry.getValue()/t, this.n, space);
        
        // this displays the frequency of each letter on the right side of the window.
        arc.fillText(entry.getKey()+ ", " +entry.getValue(), 1.8*center.getX(), space);
        //space = space between letters 
        space+=14;
        count++;
        
    }
    
}







} 