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
}
