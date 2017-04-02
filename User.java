/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwdcracker;

import java.util.HashMap;

/**
 *
 * @author justinrstallard
 */
public class User {    
    private final String userName;
    private final String hash;
    private final String salt;
    private String password;
    public static int count = 0;
    
    // stores all found Users:  (userName, User Object)
    private static HashMap found = new HashMap(); 
    
    User(String uN, String h, String s){
        userName = uN;
        hash = h;
        salt = s;
    }
    
    public String getSalt(){
        return salt;
    }
    public String getUserName(){
        return userName;
    }
    public String getHash(){
        return hash;
    }
    
    public void print(long startTime, String pwd){
        // check if this user is already found 
        if(!found.containsKey(userName)){
            // save the password for this user 
            password = pwd; 
            
            // add user to found HashMap
            found.put(userName, this);
            
            // print results 
            long currTime = System.nanoTime();
            long elapsed = currTime - startTime;
            long seconds = elapsed / 1000000000;
            long ms = (elapsed-seconds*1000000000)/1000000;
            System.out.print(++count + "\t" + userName + " \t");
            System.out.print(pwd + " \t");
            System.out.println(seconds + "s "+ ms + "ms ");
        }
    }
}
