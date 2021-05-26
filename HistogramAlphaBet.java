import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import static java.util.stream.Collectors.toMap;

public class HistogramAlphaBet {
    private Map<Character, Integer> MAP; // map of all characters in text file
    private int frequencyOfAllEvents; // frequency of all items (# of letters)
    
    public HistogramAlphaBet() 
    {
      MAP = new HashMap<>(26); // MAP of all characters (26 letters of the alphabet
      createHashMap();
    }
    
    
    
    
    public void createHashMap() 
    { // get frequency of letter
        try {
            File file = new File("/Users/MunerKhan/Desktop/Alice In Wonderland.txt"); // file path name
            Scanner scan = new Scanner(file); // scan file
            String story = "";
            
            while (scan.hasNextLine()) { // make file into single line and make it a string
            story = story.concat(scan.nextLine());
            }
            
            story = story.replaceAll("[^A-Za-z]", "").toLowerCase(); // make string only contain lowercase letters, no symbols
            
            frequencyOfAllEvents = story.length();
            for (int i = 0; i < story.length(); i++) 
            {
                char letter = story.charAt(i);
                if (!MAP.containsKey(letter)) 
                { // if letter not in map
                    MAP.put(letter,1); // add letter with an occurrence of 1
                } 
                else 
                { // else letter is in map
                    int freq = MAP.get(letter); //get value at letter 
                    MAP.put(letter, ++freq); // add frequency of letter by 1
                }
            }
        }
        catch (FileNotFoundException e) { System.out.println("File not found"); } // if pathname not found display error
    }
    public Map<Character, Integer> getNMostFreqEvents(int n) 
    {
        //create a map of ALL the letters in decreasing order and store into sortedByValueDesc 
        Map<Character, Integer> sortedByValueDesc = new HashMap<>(); 
        sortedByValueDesc = MAP.entrySet() .stream() .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()) .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        
        
        //nMostFreqEvents contains the n highest elements with its frequency as the value   
        Map<Character, Integer> nMostFreqEvents = new HashMap<>(); 
        int count = 0;
        for (Map.Entry<Character,Integer> entry:sortedByValueDesc.entrySet()) 
        {
            if (count >= n) break; 
            nMostFreqEvents.put(entry.getKey(), entry.getValue());
            count++;
        }
        
        //Sort them in decreasing order and return
        nMostFreqEvents=nMostFreqEvents.entrySet() .stream() .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()) .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return nMostFreqEvents;
        
      
    }
    public Map<Character, Double> probabilities(int n)
    {
        Map<Character, Integer> map = this.getNMostFreqEvents(n);
        int all = this.frequencyOfAllEvents;
        System.out.println(all);
        Map<Character, Double> output = new HashMap<>();
        
        for (Map.Entry<Character,Integer> entry:map.entrySet()) 
        {
            double prob = (double)entry.getValue()/all;
            output.put(entry.getKey(),prob);
        }
        
       return output; 
    }
    public int getFreqOfAllEvents(){return this.frequencyOfAllEvents;}
    
    public Map<Character, Integer> getMap(){ return this.MAP;}
    
}


