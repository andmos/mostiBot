/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andreasmosti
 */

import org.jibble.pircbot.*;

public class mostiBot extends PircBot {
    public mostiBot(){
        this.setName("mostiBot");
    }
    
    public void onMessage(String channel, String sender,
                       String login, String hostname, String message) {
        if (message.equalsIgnoreCase("time")) {
            String time = new java.util.Date().toString();
            sendMessage(channel, sender + ": The time is now " + time);
        }
    
    }
}