package pwdcracker;

import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author justinrstallard
 */
public class Pwdcracker {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.security.NoSuchAlgorithmException
     */
    
    public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException {
        //Parse given hash file
        HashFile hashFile = new HashFile("pa3hashes.txt");        
        hashFile.parse();
        
        //Parse bible
        Wordlist wl = new Wordlist("Bible.txt");
        wl.parseWordlist();
        
        // start Thread
        PwdTesterThread testerThread = new PwdTesterThread("Tester1", hashFile); 
        testerThread.start(); 
        
        
        // start guessing passwords 
        PwdChanger changer = new PwdChanger(); 
        changer.runTests();
        
        // and the program will never end. probably. 
    }
}