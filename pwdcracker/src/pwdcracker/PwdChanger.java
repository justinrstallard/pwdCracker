/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwdcracker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import static pwdcracker.PwdTesterThread.lock1;
import static pwdcracker.PwdTesterThread.pwds;

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
        appendPrependZeroToNine(); 
        appendPrependZeroToNineLowerAndUpperCase();
        try {
            crazyTests();
            //System.out.println("End of Tests.");
        } catch (InterruptedException ex) {
            Logger.getLogger(PwdChanger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void add(String s){
        //while(pwds.size()>1000000){
            //System.out.println("Blocked add"); 
        //}
        synchronized(lock1){
            PwdTesterThread.pwds.add(s);             
        }   
        addWSalt(s);
    }
    
    private void addWSalt(String s){
        for (int i = 0; i < users.size(); i++) {
            if(!users.get(i).getSalt().equals("")){
                //while(pwds.size()>1000000){
                    //System.out.println("Blocked addWSalt"); 
                //}
                synchronized(lock1){
                    PwdTesterThread.pwds.add(s + users.get(i).getSalt()); 
                }
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
    
    private void crazyTests() throws InterruptedException{
        Iterator it = getIterator(); 
        
        while(it.hasNext()){
            
            String pwdString = (String)it.next();
            for(long i = 0; i<1048576; i++) {
                
                
                String pwdStringTemp = pwdString;
                String s = String.format("%32s", Long.toBinaryString(i));
                if(s.charAt(31)=='1'){
                    pwdStringTemp = pwdStringTemp.replace('a', '@'); 
                }
                if(s.charAt(30)=='1'){
                    pwdStringTemp = pwdStringTemp.replace('s', '$');
                }
                if(s.charAt(29)=='1'){
                    pwdStringTemp = pwdStringTemp.replace('o', '0');
                }
                if(s.charAt(28)=='1'){
                    pwdStringTemp = pwdStringTemp.replace('e', '3');
                }
                if(s.charAt(27)=='1'){
                    pwdStringTemp = pwdStringTemp.replace('l', '!');
                }
                if(s.charAt(26)=='1'){
                    pwdStringTemp = pwdStringTemp.replace('s', '5');
                }
                if(s.charAt(25)=='1'){
                    pwdStringTemp = append(pwdStringTemp, "!");
                }
                if(s.charAt(24)=='1'){
                    pwdStringTemp = append(pwdStringTemp, "1"); 
                }
                if(s.charAt(23)=='1'){
                    pwdStringTemp = append(pwdStringTemp, "2"); 
                }
                if(s.charAt(22)=='1'){
                    pwdStringTemp = append(pwdStringTemp, "3"); 
                }
                if(s.charAt(21)=='1'){
                    pwdStringTemp = append(pwdStringTemp, "4"); 
                }
                if(s.charAt(20)=='1'){
                    pwdStringTemp = append(pwdStringTemp, "5"); 
                }
                if(s.charAt(19)=='1'){
                    pwdStringTemp = append(pwdStringTemp, "6"); 
                }
                if(s.charAt(18)=='1'){
                    pwdStringTemp = append(pwdStringTemp, "7"); 
                }
                if(s.charAt(17)=='1'){
                    pwdStringTemp = append(pwdStringTemp, "8"); 
                }
                if(s.charAt(16)=='1'){
                    pwdStringTemp = append(pwdStringTemp, "9"); 
                }
                if(s.charAt(15)=='1'){
                    pwdStringTemp = append(pwdStringTemp, "0"); 
                }
                if(s.charAt(14)=='1'){
                    pwdStringTemp = append(pwdStringTemp, "#"); 
                }
                if(s.charAt(13)=='1'){
                    pwdStringTemp = append(pwdStringTemp, "?"); 
                }
                if(s.charAt(12)=='1'){
                    pwdStringTemp = append(pwdStringTemp, "?"); 
                }
                
                add(pwdStringTemp);
            }
        }
        System.out.println("done with crazy tests");
    }
    
    private void appendPrependZeroToNine(){
        String ints = "1234567890";
        
        for(int i = 1; i<ints.length(); i++){
            Iterator it = getIterator();
            
            while(it.hasNext()){
                String s = (String)it.next();
                add(s + ints.substring(0,i));
                add(ints.substring(0,i) + s);
            }
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

    private String append(String pwd, String ap){
        return pwd + ap;
    }
    
    private String prepend(String pre,String pwd){        
        return pre + pwd;
    }
}
