package com.exilegl.bot.command.ordinary;

import com.exilegl.bot.ai.Clever;
import com.exilegl.bot.command.Command;
import com.exilegl.bot.command.CommandIdentifier;
import com.skype.ChatMessage;
import com.skype.SkypeException;

public class CommandAi extends Command{

	//Cleverbot used for gathering clever messages
	private Clever clever;
	
	public CommandAi() {
		super("ai", "Asks the clever AI a question");
		clever = new Clever();
	}

	@Override
	public void perform(ChatMessage received) throws SkypeException {
		//Display wait message and make instance to edit when we're done
		ChatMessage wait = this.performWait(received);
		//Perform logic
		String message = (received.getContent());
		message = message.replace("ai", "");
		String response = ("Clever: " + "'" + message + "' - " + clever.think(message));
		//Edit wait message to our logic's answer now that we are done
		wait.setContent(response);
	}

	public Clever getClever() {
		return clever;
	}

	public void setClever(Clever clever) {
		this.clever = clever;
	}

}
