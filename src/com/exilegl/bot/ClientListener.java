package com.exilegl.bot;

import com.exilegl.bot.command.CommandIdentifier;
import com.exilegl.bot.command.Commands;
import com.skype.ChatMessage;
import com.skype.ChatMessageAdapter;
import com.skype.SkypeException;

public class ClientListener extends ChatMessageAdapter{

	//Non valid command message
	private final String invalid = ("That is not a valid command!");
	
	@Override
	public void chatMessageReceived(ChatMessage received) throws SkypeException{
		//If it is a normal message, check if it's a command and call the correct command if so
		if(received.getType().equals(ChatMessage.Type.SAID)){
			boolean success = Commands.checkCommand(received.getContent(), received);
			if(!success){
				for(CommandIdentifier i : CommandIdentifier.IDENTIFIERS){
				if(received.getContent().substring(0, 1).equals(i.ID)){
				received.getSender().send(invalid);
				}
				}
			}
		}
	}
	
}
