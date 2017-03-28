/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwdcracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author justinrstallard
 */
public class ParseBible {
    
    String filename = ""; 
    
    private TreeSet bibleTS = new TreeSet(); 
    private HashMap bibleHM = new HashMap();
    
    ParseBible(String fn){
        filename = fn; 
    }
    
    public TreeSet parseBible(){        
        try {
            File file = new File(filename); 
            Scanner sc = new Scanner(file).useDelimiter("[.,:;()?!\"\\s]+");
            String currWord;
            while(sc.hasNext()){
                currWord = sc.next();
                bibleTS.add(currWord.toLowerCase());
                bibleTS.add(currWord.toLowerCase() + "1");
                bibleTS.add(currWord.toLowerCase() + "123");
            }
            return bibleTS;
        }
        catch (FileNotFoundException e1){
        }
        return null; 
    }
    
    public void hashBible(){
        Iterator i = bibleTS.iterator();
        String s ;
        
        while(i.hasNext()) {
            s = i.next().toString();
            bibleHM.put(bytesToString(getHash(s)), s);
        }
    }
    
    private static String bytesToString(byte[] barr){
        return new BigInteger(1, barr).toString(16);
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
