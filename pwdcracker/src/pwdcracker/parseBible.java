/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwdcracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author justinrstallard
 */
public class parseBible {
    public static TreeSet parseBible(){        
        try {
            TreeSet bibleTS = new TreeSet();
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
}
