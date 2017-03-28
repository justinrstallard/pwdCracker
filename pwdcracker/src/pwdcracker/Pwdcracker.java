package pwdcracker;

import java.io.FileNotFoundException;
import java.util.Iterator;

/**
 *
 * @author justinrstallard
 */
public class Pwdcracker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.nanoTime(); 
        //Parse bible
        ParseBible pB = new ParseBible("Bible.txt");
        
        pB.parseBible(); 
        pB.hashBible(); 
        
        //Parse given hash file
        ParseHashFile pHS = new ParseHashFile("pa3hashes.txt");
        
        pHS.parseHashFile();
        
        //Compare hashfile with hashed bible
        
        Object obj; 
        Iterator it = pB.bibleHM.entrySet().iterator();
        
        while(it.hasNext()){
            obj = pHS.findUser((String)it.next());
            if (obj!=null){
                print((User)obj, startTime); 
            }
        }
    }
    
    private static void print(User u, long st){
        System.out.print(u.getUsername()); 
        System.out.print("  " + u.getSalt());
        System.out.print("  " + u.getHash());
        
        // print time 
        long currTime = System.nanoTime(); 
        
        long elapsed = currTime - st; 
        long seconds  = elapsed / 1000000000; 
        long ms = (elapsed-seconds*1000000000)/1000000; 
        System.out.println(seconds + "s " + ms + "ms "); 
    }
}
