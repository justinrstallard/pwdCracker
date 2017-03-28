package pwdcracker;

import java.io.FileNotFoundException;

/**
 *
 * @author justinrstallard
 */
public class Pwdcracker {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
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
        
        //Compare hashfile with hashed bible and output
            for (int j = 0; j < pHS.users.size(); j++) {
                if(pB.bibleHM.containsKey(pHS.users.get(j).hash)) {
                    long currTime = System.nanoTime();
                    long elapsed = currTime - startTime;
                    long seconds = elapsed / 1000000000;
                    long ms = (elapsed-seconds*1000000000)/1000000;
                    System.out.print("Username: " + pHS.users.get(j).userName);
                    System.out.print(" Password: " + pB.bibleHM.get(pHS.users.get(j).hash) + " ");
                    System.out.println(seconds + "s "+ ms + "ms ");
                }
            }
    }
    
}
