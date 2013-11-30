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
    
    private ArrayList<String> noList = new ArrayList<String>();
    private ArrayList<String> options = new ArrayList<String>(); 
    private ArrayList<String> greetings = new ArrayList<String>(); 
    
    public mostiBot(){
        this.setName("mostiBot");
        options.add("!time");
        options.add("!users"); 
        options.add("!uptime");
        options.add("!next");
        options.add("!hei"); 
        addGreetingsToList(greetings); 
    }
    
    @Override
    public void onMessage(String channel, String sender, String login, String hostname, String message) {
            
           if (message.equalsIgnoreCase("!time")) {
            String time = new java.util.Date().toString();
            sendMessage(channel, sender + ": The time is now " + time);
        }
           if (message.equalsIgnoreCase("!help")){
            String ut = " "; 
            for (int i = 0; i <options.size(); i++) {
                ut += options.get(i) + " "; 
            }
            sendMessage(channel, sender + " The options are:" + ut); 
           }
           if(message.equalsIgnoreCase("!users")) {
            User[] users = new User[getUsers(channel).length]; 
                users = getUsers(channel); 
                String ut = ""; 
                for (int i = 0; i < users.length; i++) {
                    ut += users[i].getNick() + " "; 
                }
                sendMessage(channel, sender + ": users: " + ut); 
           }
           if(message.equalsIgnoreCase("!quit") && sender.equalsIgnoreCase("mosti")){
             quitServer(sender + " killed me!"); 
         
         }
           if(message.equalsIgnoreCase("!uptime")){
             try{
                 String host = getHostName(); 
                 
                 String uptime = getBashCommandOutput("uptime")[0];
                 sendMessage(channel, "Uptime for " + host + ": " + uptime); 
                }catch(Exception e) { 
                 System.out.println(e.getMessage());
                 sendMessage(channel, e.getMessage()); 
             }
         }if(message.equalsIgnoreCase("!hello")){
             try{ 
                 java.util.Random ran = new java.util.Random(); 
                 sendMessage(channel, greetings.get(ran.nextInt(greetings.size()))); 
                 
                }catch(Exception e) {
                 System.out.println(e.getMessage());
                 sendMessage(channel, e.getMessage()); 
             }
         }
       }
    
    private void addGreetingsToList(ArrayList listToAddTo){
        listToAddTo.add("Hello!");
        listToAddTo.add("Morn du!");
        listToAddTo.add("Hur går det?");
        listToAddTo.add("Have a nice one!");
    }
    
    private String getHostName(){
        String host = ""; 
        try{
            host = getBashCommandOutput("hostname")[0]; 
            return host; 
        }catch(Exception e){
            System.out.println(e.getMessage());
            host = e.getMessage();
        }
        return host; 
    }	

    private String[] getBashCommandOutput(String command) {
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
    
 