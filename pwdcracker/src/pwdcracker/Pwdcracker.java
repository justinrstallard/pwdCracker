package pwdcracker;

import java.io.FileNotFoundException;

/**
 *
 * @author justinrstallard
 */
public class Pwdcracker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        //Parse bible
        ParseBible pB = new ParseBible("Bible.txt");
        
        pB.parseBible(); 
        pB.hashBible(); 
        
        //Parse given hash file
        ParseHashFile pHS = new ParseHashFile("pa3hashes.txt");
        
        pHS.parseHashFile();
        
        //Compare hashfile with hashed bible
        
    }
}
