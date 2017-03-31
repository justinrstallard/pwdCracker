/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwdcracker;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jlarson
 */
public class PwdTesterThread implements Runnable {
    private Thread t; 
    private String threadName; 
    private HashFile hashFile; 
    
    public static Queue<String> pwds = new ArrayDeque<String>();
    
    PwdTesterThread(String name, HashFile hf){
        threadName = name; 
        hashFile = hf; 
        System.out.println("Created");
    }
    
    @Override
    public void run() {
        long startTime = System.nanoTime();
        String password = ""; 
        String hash = ""; 
        Hasher hMachine = new Hasher(); 
        int index = 0;
        
        User testUsr = new User("", "", ""); 

        while(true){
            // index++; 
            if(!pwds.isEmpty()){
                // pop 
                password = pwds.remove(); 
                
                // hash pwd
                try {
                    hash = hMachine.hash(password.getBytes());
                } catch (NoSuchAlgorithmException ex) {
                    System.out.println("MD5 Hasher: NoSuchAlgorithException thrown.");
                }

                // test pwd
                testUsr = hashFile.findHash(hash); 

                // if passed, print User 
                if(testUsr!=null){
                    testUsr.print(startTime, password); 
                }
            }
            /*if(index%1000==0){
                System.out.println(index); 
            }*/
        }
    }
    
    public void start() {
        if (t==null){
            t=new Thread(this, threadName);
            t.start(); 
        }
    }
    
}
