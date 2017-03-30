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
    private TreeSet wordlistTSSalted = new TreeSet();
    private TreeSet wordlistTSAppend = new TreeSet();
    
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
                wordlistTS.add(currWord.replace('S', '$'));
                wordlistTS.add(currWord.replace('r', '4').toLowerCase());
                wordlistTS.add(currWord.replace('R', '4'));
                wordlistTS.add(currWord.replace('o', '0').toLowerCase());
                wordlistTS.add(currWord.replace('O', '0'));
                
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
    
    public void hashSaltedWordlist() throws NoSuchAlgorithmException{
        Iterator i = wordlistTSSalted.iterator();
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
        Iterator i = wordlistTS.iterator(); 
        while(i.hasNext()){
            wordlistTSSalted.add((String)i.next()+salt); 
        }
    }
    
    public void appendPasswordWith(String app, String app2){
        Iterator i = wordlistTS.iterator(); 
        String pwd = ""; 
        
        while(i.hasNext()){
            pwd = (String)i.next(); 
            wordlistTSSalted.add(pwd+app); 
            
            if(app2!=""){
              wordlistTSSalted.add(pwd+app+app2); 
            }
        }
    }
}
