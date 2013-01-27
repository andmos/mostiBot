/**
 *
 * @author andreasmosti
 * 
 * Try to keep the code dynamic, NO HARD CODING HERE 


*/

import org.jibble.pircbot.*;
import java.util.ArrayList; 
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class mostiBot extends PircBot {
    
    ArrayList<String> noList = new ArrayList<String>();
    ArrayList<String> options = new ArrayList<String>(); 
    
    public mostiBot(){
        this.setName("mostiBot");
        options.add("!time");
        options.add("!users"); 
        options.add("!uptime");
        options.add("!next");
    }
    
    @Override
    public void onMessage(String channel, String sender, String login, String hostname, String message) {
            
           if (message.equalsIgnoreCase("!time")) {
            String time = new java.util.Date().toString();
            
            sendMessage(channel, sender + ": The time is now " + time);
        }if (message.equalsIgnoreCase("!help")){
            String ut = " "; 
            for (int i = 0; i <options.size(); i++) {
                ut += options.get(i) + " "; 
            }
            sendMessage(channel, sender + " The options are:" + ut); 
        }if(message.equalsIgnoreCase("!users")) {
            User[] users = new User[getUsers(channel).length]; 
                users = getUsers(channel); 
                String ut = ""; 
                for (int i = 0; i < users.length; i++) {
                    ut += users[i].getNick() + " "; 
         }
                sendMessage(channel, sender + ": users: " + ut); 
         }if(message.equalsIgnoreCase("!quit") && sender.equalsIgnoreCase("mosti")){
             quitServer(sender + " killed me!"); 
         
         }if(message.equalsIgnoreCase("!uptime")){
             try{
                 String host = getHostName(); 
                 String uptime = "";
                 uptime = getBash("uptime")[0];
                 sendMessage(channel, "Uptime for " + getHostName() + ": " +uptime); 
             }catch(Exception e) { 
                 System.out.println(e.getMessage());
                 sendMessage(channel, e.getMessage()); 
             }
         }if(message.equalsIgnoreCase("!next")){
           Timeplan plan = new Timeplan(); 
           sendMessage(channel, plan.getNextLecture()); 
         }
       }
    
    public String getHostName(){
        String host = ""; 
        try{
            host = getBash("hostname")[0]; 
            return host; 
        }catch(Exception e){
            System.out.println(e.getMessage());
            host = e.getMessage();
        }
        return host; 
    }	
        
    
    
    public String[] getBash(String command) {
			String[] cmd = {"/bin/sh","-c",command};
			String[] out = new String[10];
			int i = 0;	
                        try {
				Process proc = Runtime.getRuntime().exec(cmd);
				BufferedReader read = new BufferedReader(new InputStreamReader(proc.getInputStream()));
				out[i] = read.readLine();
				while (read.ready()&&i<9) {
                                    out[i] = read.readLine();
                                    i++;
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 


			return out;
		}
		
	
	}
       
    
    
    
 