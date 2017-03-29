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
public class ParseBible {
    
    private String filename = ""; 
    
    private final TreeSet bibleTS = new TreeSet(); 
    HashMap bibleHM = new HashMap();
    
    ParseBible(String fn){
        filename = fn; 
    }
    
    public TreeSet parseBible() throws FileNotFoundException{
            File file = new File(filename); 
            Scanner sc = new Scanner(file).useDelimiter("[.,:;()?!\"\\s]+");
            String currWord;
            while(sc.hasNext()){
                currWord = sc.next();
                bibleTS.add(currWord);
                bibleTS.add(currWord.toLowerCase());
                bibleTS.add(currWord.toLowerCase() + "1234");
                bibleTS.add(currWord.replace('s', '$').toLowerCase());
            }
            return bibleTS;
    }
    
    public void hashBible() throws NoSuchAlgorithmException{
        Iterator i = bibleTS.iterator();
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
            bibleHM.put(anotherString, s);
        }
    }
    
    public void addSaltToPasswords(String salt){
        Object[] bibleArray = bibleTS.toArray();
        for (Object bibleArray1 : bibleArray) {
            bibleTS.add(bibleArray1.toString() + salt);
        }
    }
}
