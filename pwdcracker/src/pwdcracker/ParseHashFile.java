package pwdcracker;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author justinrstallard
 */
public class ParseHashFile {
    
    String filename = "";
    ArrayList<User> users = new ArrayList<>();
    ArrayList<User> usersWSalt = new ArrayList<>();
    ArrayList<User> usersWOSalt = new ArrayList<>();
    
    Hashtable usersHT; 
    
    ParseHashFile(String fn){
        filename = fn;
    }
    
    public void parseHashFile() throws FileNotFoundException{
        
        Scanner sc = new Scanner(new File(filename)).useDelimiter(":|\\r\n");
        
        while(sc.hasNext()){
            String user = sc.next();
            String salt = sc.next();
            String hash = sc.next();
            
            // add the users to various lists
            if(salt == ""){
                usersWOSalt.add(new User(user, hash, salt));
            }
            else{
                usersWSalt.add(new User(user, hash, salt));    
            }
            users.add(new User(user, hash, salt));
            usersHT.put(hash, new User(user, hash, salt));
        }
    }
    
    public Object findUser(String hash){
        return usersHT.get(hash);
    }
}