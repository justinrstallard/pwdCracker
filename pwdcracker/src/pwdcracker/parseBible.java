/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwdcracker;

import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author justinrstallard
 */
public class parseBible {
    public TreeSet parseBible(){        
        TreeSet bibleTS = new TreeSet();
        Scanner sc = new Scanner("Bible.txt");
        String currWord;
        while(sc.hasNext()){
            currWord = sc.next();
            bibleTS.add(currWord);
        }
        return bibleTS;
    }
}
