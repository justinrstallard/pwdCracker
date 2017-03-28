/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwdcracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author justinrstallard
 */
public class ParseBible {
    
    TreeSet bibleTS = new TreeSet(); 
    ArrayList<byte[]> bibleHash = new ArrayList<byte[]>(); 
    
    ParseBible(){
    }
    
    public TreeSet parseBible(){        
        try {
            File file = new File("Bible.txt"); 
            Scanner sc = new Scanner(file).useDelimiter("[.,:;()?!\"\\s]+");
            String currWord;
            while(sc.hasNext()){
                currWord = sc.next();
                bibleTS.add(currWord);
            }
            return bibleTS;
        }
        catch (FileNotFoundException e1){
            
        }
        return null; 
    }
    
    public void hashBible(){
        Iterator i = bibleTS.iterator();
        
        while(i.hasNext()) {
            bibleHash.add(getHash(i.next().toString()));
        }
        
        printBytes(bibleHash.get(0));
    }
    
    private static void printBytes(byte[] barr){
        
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
