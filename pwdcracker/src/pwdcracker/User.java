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
    private String userName;
    private String hash;
    private String salt;
    private byte[] hashBt; 
    
    User(String uN, String h, String s){
        userName = uN;
        hash = h;
        salt = s;
        hashBt = hash.getBytes(); 
    }
    
    public String getUsername(){
        return userName; 
    }
    public String getHash() {
        return hash; 
    }
    public byte[] getHashBytes() {
        return hashBt; 
    }
    public String getSalt() {
        return salt; 
    }
}
