/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwdcracker;

import java.util.Iterator;

/**
 *
 * @author jlarson
 */
public class PwdChanger {
    
    
    PwdChanger(){
        Iterator i = Wordlist.wordlistTS.iterator();
        while(i.hasNext()){
            add((String)i.next()); 
        }
    }
    
    public void add(String s){
        PwdTesterThread.pwds.add(s); 
    }
    
    public void runTests(){
        appendZeroToNine(); 
    }
    
    
    
    
    /////// ALL THE TESTS //////////
    private void appendZeroToNine(){
        String intAppend = "1234567890"; 
        
        
    }
    
    private void append(String ap1, String ap2){
        
    }
    
    private void prepend(String pre){
        
    }
}
