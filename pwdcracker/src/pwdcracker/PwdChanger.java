/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwdcracker;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jlarson
 */
public class PwdChanger {
    ArrayList <User> users= new ArrayList();
    
    PwdChanger(){
        Iterator i = Wordlist.wordlistTS.iterator();
        users = HashFile.getUsers();
        while(i.hasNext()){
            String s = (String) i.next();
            add(s);
        }
    }
    
    public void runTests(){
        toLowerCase();
        toUpperCase();
        replaceChar();        
        appendPrependZeroToNine(); 
        appendPrependZeroToNineLowerAndUpperCase();
        appendPunctuation();
        //System.out.println("End of Tests.");
    }
    
    private void add(String s){
        PwdTesterThread.pwds.add(s); 
        addWSalt(s);
    }
    
    private void addWSalt(String s){
        for (int i = 0; i < users.size(); i++) {
            if(!users.get(i).getSalt().equals("")){
                PwdTesterThread.pwds.add(s + users.get(i).getSalt()); 
            }
        }        
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
    
    private void replaceChar(){
        Iterator it = getIterator();
        
        while(it.hasNext()){
            String s = (String)it.next();
            add(s.replace('a', '@')); 
            add(s.replace('a', '4')); 
            add(s.replace('s', '$')); 
            add(s.replace('l', '!')); 
        }
    }
    
    private void appendPunctuation(){
        String ints = "!?.@#$^&*()<>;:";
        
        for(int i = 0; i<ints.length(); i++){
            append(ints.substring(i, i+1), ""); 
            prepend(ints.substring(i,i+1)); 
        }
    }
    
    private void crazyTests(){
        Iterator it = getIterator(); 
        
        while(it.hasNext()){
            int tests = 0;

            for(int i = 0; i<3; i++) {
                String s = Integer.toBinaryString(i);
                if(s.charAt(0)=='1'){
                    
                }
                if(s.charAt(1)=='1'){
                    
                }
                if(s.charAt(2)=='1'){
                    
                }
                if(s.charAt(3)=='1'){
                    
                }
                if(s.charAt(4)=='1'){
                    
                }
                if(s.charAt(5)=='1'){
                    
                }
                if(s.charAt(6)=='1'){
                    
                }
                if(s.charAt(7)=='1'){
                    
                }
                if(s.charAt(8)=='1'){
                    
                }
                if(s.charAt(8)=='1'){
                    
                }
                if(s.charAt(10)=='1'){
                    
                }
                if(s.charAt(11)=='1'){
                    
                }
        }
        }
    }
    
    private void appendPrependZeroToNine(){
        String ints = "1234567890";
        
        for(int i = 1; i<ints.length(); i++){
            append(ints.substring(0, i), ""); 
            prepend(ints.substring(0,i)); 
        }
    }
    
    private void appendPrependZeroToNineLowerAndUpperCase(){
        String ints = "1234567890";
        
        for(int i = 1; i<ints.length(); i++){
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
