/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwdcracker;

/**
 *
 * @author jlarson
 */
public class PwdChanger {
    
    PwdChanger(){
        
    }
    
    public void runTests(){
        PwdTesterThread.pwds.add("hi");
    }
}
