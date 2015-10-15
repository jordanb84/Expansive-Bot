package com.exilegl.bot;

import com.exilegl.bot.command.ordinary.CommandAi;
import com.exilegl.bot.command.ordinary.CommandHelp;
import com.exilegl.bot.command.ordinary.CommandSpam;
import com.exilegl.bot.command.ordinary.CommandTest;
import com.exilegl.bot.command.ordinary.CommandYomama;

public class Launcher {
	
	public static BotClient client;
	
    public static void main(String[] args) throws Exception {
    	//Create new client
    	client = new BotClient();
    	//Initiate commands
    	initiate();
    }
    
    /**
     * Initiates commands
     */
    public static void initiate(){
    	//When new instances of commands are created, they are automatically registered and can then be used
    	//Ordinary commands
    	new CommandHelp();
    	new CommandTest();
    	new CommandYomama();
    	new CommandSpam();
    	new CommandAi();
    }
    
    
}