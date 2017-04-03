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
        
        // start Threads
        PwdTesterThread testerThread = new PwdTesterThread("Tester1", hashFile); 
        testerThread.start(); 
        
        PwdTesterThread testerThread2 = new PwdTesterThread("Tester2", hashFile); 
        testerThread2.start(); 
        
        PwdTesterThread testerThread3 = new PwdTesterThread("Tester3", hashFile); 
        testerThread3.start(); 
        
        PwdTesterThread testerThread4 = new PwdTesterThread("Tester4", hashFile); 
        testerThread4.start(); 
        
        PwdTesterThread testerThread5 = new PwdTesterThread("Tester5", hashFile); 
        testerThread5.start(); 
        
        PwdTesterThread testerThread6 = new PwdTesterThread("Tester6", hashFile); 
        testerThread6.start(); 
        
        PwdTesterThread testerThread7 = new PwdTesterThread("Tester7", hashFile); 
        testerThread7.start(); 
        
        PwdTesterThread testerThread8 = new PwdTesterThread("Tester8", hashFile); 
        testerThread8.start(); 
        
        PwdTesterThread testerThread9 = new PwdTesterThread("Tester9", hashFile); 
        testerThread9.start(); 
        
        PwdTesterThread testerThread10 = new PwdTesterThread("Tester10", hashFile); 
        testerThread10.start(); 
        
        
        // start guessing passwords 
        PwdChanger changer = new PwdChanger(); 
        changer.runTests();
        
        // and the program will never end. probably. 
    }
}