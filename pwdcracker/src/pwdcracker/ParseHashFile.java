package pwdcracker;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author justinrstallard
 */
public class ParseHashFile {
    
    String filename = "";
    ArrayList<User> users = new ArrayList<>();
    ArrayList<User> usersWSalt = new ArrayList<>();
    ArrayList<User> usersWOSalt = new ArrayList<>();
    
    ParseHashFile(String fn){
        filename = fn;
    }
    
    public void parseHashFile() throws FileNotFoundException{
        
        Scanner sc = new Scanner(new File(filename)).useDelimiter(":|\\r\n");
        
        while(sc.hasNext()){
            String user = sc.next();
            String salt = sc.next();
            String hash = sc.next();
            if(salt == ""){
                usersWOSalt.add(new User(user, salt, hash));
            }
            else{
                usersWSalt.add(new User(user, salt, hash));    
            }
            users.add(new User(user, salt, hash));    
        }
    }
}
