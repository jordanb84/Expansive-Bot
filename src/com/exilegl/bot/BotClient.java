package com.exilegl.bot;

import com.skype.ChatMessageAdapter;
import com.skype.Skype;
import com.skype.SkypeException;

public class BotClient {

	/**
	 * The bot's client, used for managing the API
	 * @throws SkypeException 
	 */
	BotClient() throws SkypeException{
		//Setup the API
		Skype.setDaemon(false);
		Skype.addChatMessageListener(new ClientListener());
	}
	
	
	
}
