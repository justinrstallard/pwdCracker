package pwdcracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author justinrstallard
 */
public class Wordlist {
    private String filename = ""; 
    
    private final TreeSet wordlistTS = new TreeSet(); 
    HashMap wordlistHM = new HashMap();
    
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
                wordlistTS.add(currWord.toLowerCase());
                wordlistTS.add(currWord.toLowerCase() + "1234");
                wordlistTS.add(currWord.replace('s', '$').toLowerCase());
            }
            
            return wordlistTS;
    }
    
    public void hashWordlist() throws NoSuchAlgorithmException{
        Iterator i = wordlistTS.iterator();
        String s ;
        
        while(i.hasNext()) {
            s = i.next().toString();
            
            //MD5 hash function
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(s.getBytes());            
            byte[] barr = md.digest();
            
            //turn byte into hash string
            String anotherString = new BigInteger(1, barr).toString(16);
            
            //store in hash map
            wordlistHM.put(anotherString, s);
        }
    }
    
    public void addSaltToWordlist(String salt){
        Object[] wlArray = wordlistTS.toArray();
        for (Object bibleArray1 : wlArray) {
            wordlistTS.add(bibleArray1.toString() + salt);
        }
    }
}
