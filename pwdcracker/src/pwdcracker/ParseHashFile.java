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
    
    public static void parseHashFile() throws FileNotFoundException{
        ArrayList<User> users = new ArrayList<>();
        Scanner sc = new Scanner(new File("pa3hashes.txt")).useDelimiter(":|\\r\n");
        
        while(sc.hasNext()){
            String user = sc.next();
            String salt = sc.next();
            String hash = sc.next();
            
            users.add(new User(user, salt, hash));
        }
    }
}
