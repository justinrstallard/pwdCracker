/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwdcracker;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author justinrstallard
 */
public class Pwdcracker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(getHash("HI").toString()); 
        
        parseBible.parseBible(); 
        
    }
    
    private static byte[] getHash(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            // run an update 
            md.update(str.getBytes());
            // get byte data 
            return md.digest(); 
        }
        catch (NoSuchAlgorithmException e1) {
        }
        return null; 
    }
    
}
