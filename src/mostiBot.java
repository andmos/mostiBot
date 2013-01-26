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
    
    public mostiBot(){
        this.setName("mostiBot");
    }
    
    public void onMessage(String channel, String sender, String login, String hostname, String message) {
        
           if (message.equalsIgnoreCase("time")) {
            String time = new java.util.Date().toString();
            sendMessage(channel, sender + ": The time is now " + time);
        }
    
    }
}