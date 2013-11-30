

/**
 *
 * @author andreasmosti
 */

import org.jibble.pircbot.PircBot;

public class mostiBotMain {
    public static void main(String[]args) throws Exception {
        
        mostiBot bot = new mostiBot(); 
        
        bot.setVerbose(true);
        bot.connect("irc.freenode.org");
        bot.joinChannel("#hyggenett");
        
        
    }
    
}
