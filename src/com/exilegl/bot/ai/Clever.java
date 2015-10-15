package com.exilegl.bot.ai;


import java.net.UnknownHostException;

import chatterbotapi.ChatterBot;
import chatterbotapi.ChatterBotFactory;
import chatterbotapi.ChatterBotSession;
import chatterbotapi.ChatterBotType;

public class Clever { //Fetched this from an older project, so the code isn't that neat.

	private ChatterBotFactory factory;
	private ChatterBot bot;
	private ChatterBotSession bot_session;
	
	private String failed = ("Expansive was unable to think. Did it get to the soda, or is the API out of date?");
	
	public Clever(){
		try {
			System.out.println("Initiating cleverbot");
			this.factory = new ChatterBotFactory();
			this.bot = factory.create(ChatterBotType.CLEVERBOT);
			this.bot_session = bot.createSession();
			System.out.println("Done initiating cleverbot");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public String think(String message){
		String output = (failed);
		try {
			output = (bot_session.think(message));
		} catch (Exception e) {
			output = failed;
		}
		
		return output;
	}
	
}
