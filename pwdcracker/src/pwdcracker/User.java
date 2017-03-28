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
    String userName;
    String hash;
    String salt;
    
    User(String uN, String h, String s){
        userName = uN;
        hash = h;
        salt = s;
    }
}
