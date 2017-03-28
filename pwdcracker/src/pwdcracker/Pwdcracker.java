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
        
        ParseBible pB = new ParseBible("Bible.txt");
        
        pB.parseBible(); 
        pB.hashBible(); 
        
    }
    

    
}
