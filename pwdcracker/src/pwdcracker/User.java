/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwdcracker;

/**
 *
 * @author justinrstallard
 */
public class User {    
    private final String userName;
    private final String hash;
    private final String salt;
    private String password; 
    
    User(String uN, String h, String s){
        userName = uN;
        hash = h;
        salt = s;
    }
    
    public String getSalt(User u){
        return u.salt;
    }
    public String getUserName(User u){
        return u.userName;
    }
    public String getHash(User u){
        return u.hash;
    }
    
    public void print(long startTime, String pwd){
        password = pwd; 
        long currTime = System.nanoTime();
        long elapsed = currTime - startTime;
        long seconds = elapsed / 1000000000;
        long ms = (elapsed-seconds*1000000000)/1000000;
        System.out.print(userName + " \t");
        System.out.print(pwd + " \t");
        System.out.println(seconds + "s "+ ms + "ms ");
    }
}
