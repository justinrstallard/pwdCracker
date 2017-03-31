/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwdcracker;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author jlarson
 */
public class Hasher {
    
    Hasher(){
    }
    
    public String hash(byte[] b) throws NoSuchAlgorithmException{
            //MD5 hash function
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(b);            
            byte[] barr = md.digest();
            
            //turn byte into hash string
            String hashedValue = new BigInteger(1, barr).toString(16);
        return hashedValue; 
    }
}
