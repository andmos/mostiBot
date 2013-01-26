/**
 *
 * @author andreasmosti
 */

import org.jibble.pircbot.*;
import java.util.ArrayList; 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class mostiBot extends PircBot {
    
    ArrayList<String> noList = new ArrayList<String>();
    ArrayList<String> options = new ArrayList<String>(); 
    
    public mostiBot(){
        this.setName("mostiBot");
        options.add("time");
    }
    
    public void onMessage(String channel, String sender, String login, String hostname, String message) {
            
           if (message.equalsIgnoreCase("time")) {
            String time = new java.util.Date().toString();
            
            sendMessage(channel, sender + ": The time is now " + time);
        }if (message.equalsIgnoreCase("help")){
            String ut = " "; 
            for (int i = 0; i <options.size(); i++) {
                ut += options.get(i) + " "; 
            }
            sendMessage(channel, sender + " The options are:" + ut); 
        }if(message.equalsIgnoreCase("users")) {
            User[] users = new User[getUsers(channel).length]; 
                users = getUsers(channel); 
                String ut = ""; 
                for (int i = 0; i < users.length; i++) {
                    ut += users[i].getNick(); 
         }
                sendMessage(channel, sender + ": users: " + ut); 
         }
       }
        
        
    }
