package pwdcracker;

/**
 *
 * @author justinrstallard
 */
public class Pwdcracker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ParseBible pB = new ParseBible("Bible.txt");
        
        pB.parseBible(); 
        pB.hashBible(); 
        
    }
}
