package pwdcracker;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author justinrstallard
 */
public class HashFile {
    
    String filename = "";
    HashMap users = new HashMap(); 
   // ArrayList<User> users = new ArrayList<>();
    
    HashFile(String fn){
        filename = fn;
    }
    
    public void parse() throws FileNotFoundException{
        
        Scanner sc = new Scanner(new File(filename)).useDelimiter(":|\\r\n");
        
        while(sc.hasNext()){
            String user = sc.next();
            String salt = sc.next();
            String hash = sc.next();
            users.put(hash, new User(user, hash, salt));    
        }
    }
    
    public User findHash(String h){
        return (User)users.get(h);
    }
}
