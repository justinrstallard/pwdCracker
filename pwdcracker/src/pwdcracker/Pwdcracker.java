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
        
        ParseBible pB = new ParseBible("Bible.txt");
        
        pB.parseBible(); 
        pB.hashBible(); 
        
        ParseHashFile.parseHashFile();
    }
}
