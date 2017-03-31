        //add salt to passwords
        for (int i = 0; i < pHS.users.size(); i++) {
            if(pHS.users.get(i).getSalt(pHS.users.get(i)).length() >= 1){
                wl.addSaltToWordlist(pHS.users.get(i).getSalt(pHS.users.get(i)));
            }
        }
        
        // hash normal passwords 
        wl.hashWordlist();  
        // hash pwds with salt 
        wl.hashSaltedWordlist(); 
        
        // hash pwds with numbers and salt
        // for all users 
        String intAppend = "1234567890"; 
        for (int i = 0; i < pHS.users.size(); i++) {
            for(int j=1; j<intAppend.length(); j++){
                wl.appendPasswordWith(intAppend.substring(0, j), pHS.users.get(i).getSalt(pHS.users.get(i))); 
            }
        }

        //Compare hashfile with wordlist and print
        for (int j = 0; j < pHS.users.size(); j++) {
            if(wl.wordlistHM.containsKey(pHS.users.get(j).getHash(pHS.users.get(j)))) {
                print(pHS, wl, j, startTime); 
            }
        }