/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andreasmosti
 */

// This class is FAR from finnished. 


import java.util.*;

public class Timeplan {
        private ArrayList<String> timer = new ArrayList(); 
        
        
        public Timeplan(){
            timer.add("Mandag 08.30: Statistikk, K-AUD");
            timer.add("Tirsdag 12.30: Systemering, K-AUD");
            timer.add("Onsdag 12.30: Kjemi, K351");
            timer.add("Torsdag 10.15: Systemering, K-AUD");
            timer.add("Fredag 10.15: Datakommunikasjon, K-AUD, 12.30: Kjemi, K351");
        }
        public String getTimeplan(){
            String ut = ""; 
            for (int i = 0; i < timer.size(); i++) {
                ut += i + " " + timer.get(i) + "\n"; 
            }
            return ut; 
            
        }
        public void getTimeplanOnDay(){
        
        
        
            
        }
        public String getNextLecture(){
        Date now = new Date(); 
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(now);  
        int day = calendar.get(Calendar.DAY_OF_WEEK); // the day of the week in numerical format  
        
            if(day == 7 || day == 6 || day == 5){
               day = 1;    
        }
            System.out.println(day);
            return timer.get(day - 1);    
            
        }
        public static void main(String[] args) {
            Timeplan plan = new Timeplan(); 
            System.out.println(plan.getNextLecture());    }
}