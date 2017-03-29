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
        long startTime = System.nanoTime();
        
        //Parse given hash file
        ParseHashFile pHS = new ParseHashFile("pa3hashes.txt");        
        pHS.parseHashFile();
        
        //Parse bible
        ParseBible pB = new ParseBible("Bible.txt");        
        pB.parseBible();    
        
        //add salt to passwords
        for (int i = 0; i < pHS.users.size(); i++) {
            if(pHS.users.get(i).getSalt(pHS.users.get(i)).length() >= 1){
                pB.addSaltToPasswords(pHS.users.get(i).getSalt(pHS.users.get(i)));
            }
        }
           
        pB.hashBible();   
        //Compare hashfile with hashed bible and output
        for (int j = 0; j < pHS.users.size(); j++) {
            if(pB.bibleHM.containsKey(pHS.users.get(j).getHash(pHS.users.get(j)))) {
                long currTime = System.nanoTime();
                long elapsed = currTime - startTime;
                long seconds = elapsed / 1000000000;
                long ms = (elapsed-seconds*1000000000)/1000000;
                System.out.print(pHS.users.get(j).getUserName(pHS.users.get(j)) + " \t");
                System.out.print(pB.bibleHM.get(pHS.users.get(j).getHash(pHS.users.get(j))) + " \t");
                System.out.println(seconds + "s "+ ms + "ms ");
            }
        }
    }
    
}
