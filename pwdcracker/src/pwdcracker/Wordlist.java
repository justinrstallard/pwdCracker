package pwdcracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author justinrstallard
 */

public class Wordlist {
    private String filename = ""; 
    
    public static TreeSet wordlistTS = new TreeSet();
    
    Wordlist(String fn){
        filename = fn; 
    }
    
    public TreeSet parseWordlist() throws FileNotFoundException{
            File file = new File(filename); 
            Scanner sc = new Scanner(file).useDelimiter("[.,:;()?!\"\\s]+");
            String currWord;
            
            while(sc.hasNext()){
                currWord = sc.next();
                wordlistTS.add(currWord);
            }
            
            return wordlistTS;
    }
}