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
        Wordlist wl = new Wordlist("Bible.txt");
        wl.parseWordlist();
        
        //add salt to passwords
        for (int i = 0; i < pHS.users.size(); i++) {
            if(pHS.users.get(i).getSalt(pHS.users.get(i)).length() >= 1){
                wl.addSaltToWordlist(pHS.users.get(i).getSalt(pHS.users.get(i)));
            }
        }
        
        // hash normal passwords 
        wl.hashWordlist();  
        // hash pwds with salt 
        wl.hashSaltedWordlist(); 
        
        // hash pwds with numbers and salt
        // for all users 
        String intAppend = "123456789"; 
        for (int i = 0; i < pHS.users.size(); i++) {
            for(int j=1; j<intAppend.length(); j++){
                wl.appendPasswordWith(intAppend.substring(0, j), pHS.users.get(i).getSalt(pHS.users.get(i))); 
            }
        }

        
        //Compare hashfile with wordlist and print
        for (int j = 0; j < pHS.users.size(); j++) {
            if(wl.wordlistHM.containsKey(pHS.users.get(j).getHash(pHS.users.get(j)))) {
                print(pHS, wl, j, startTime); 
            }
        }
    }
    
    private static void print(ParseHashFile pHS, Wordlist wl, int j, long startTime){
        long currTime = System.nanoTime();
        long elapsed = currTime - startTime;
        long seconds = elapsed / 1000000000;
        long ms = (elapsed-seconds*1000000000)/1000000;
        System.out.print(pHS.users.get(j).getUserName(pHS.users.get(j)) + " \t");
        System.out.print(wl.wordlistHM.get(pHS.users.get(j).getHash(pHS.users.get(j))) + " \t");
        System.out.println(seconds + "s "+ ms + "ms ");
    }
}
