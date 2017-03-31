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
    
    public void runTests(){
        toLowerCase();
        toUpperCase(); 
        appendPrependZeroToNine(); 
    }
    
    private void add(String s){
        PwdTesterThread.pwds.add(s); 
    }
    
    private Iterator getIterator(){
        return Wordlist.wordlistTS.iterator(); 
    }
    
    
    /////// ALL THE TESTS //////////
    private void toLowerCase(){
        Iterator it = getIterator(); 
        
        while(it.hasNext()){
            add(((String)it.next()).toLowerCase()); 
        }
    }
    
    private void toUpperCase(){
        Iterator it = getIterator(); 
        
        while(it.hasNext()){
            add(((String)it.next()).toUpperCase()); 
        }
    }
    
    private void appendPrependZeroToNine(){
        String ints = "1234567890";
        
        for(int i = 0; i<ints.length(); i++){
            append(ints.substring(0, i), ""); 
            prepend(ints.substring(0,i)); 
        }
    }
    
    private void appendPrependZeroToNineLowerAndUpperCase(){
        String ints = "1234567890";
        
        for(int i = 0; i<ints.length(); i++){
            Iterator it = getIterator(); 
            String str = "";  
            String pend = ints.substring(0, i); 
            
            while(it.hasNext()){
                str = (String)it.next(); 
                add(str.toLowerCase() + pend);
                add(str.toUpperCase() + pend);
                add(pend + str.toUpperCase());
                add(pend + str.toLowerCase());
            }
        }
    }

    private void append(String ap1, String ap2){
        Iterator it = getIterator(); 
        
        while(it.hasNext()){
            add((String)it.next() + ap1 + ap2); 
        }
    }
    
    private void prepend(String pre){
        Iterator it = getIterator(); 
        
        while(it.hasNext()){
            add(pre + (String)it.next());
        }
    }
}
