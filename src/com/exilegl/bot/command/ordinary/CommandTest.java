package com.exilegl.bot.command.ordinary;

import com.exilegl.bot.command.Command;
import com.skype.ChatMessage;
import com.skype.SkypeException;

public class CommandTest extends Command{

	public CommandTest() {
		super("test", "The example command");
		
	}

	@Override
	public void perform(ChatMessage received) throws SkypeException {
		//Display wait message and make instance to edit when we're done
		ChatMessage wait = this.performWait(received);
		//Perform logic
		String response = ("Hey, " + received.getSender().getFullName().toString() + "!");
		//Edit wait message to our logic's answer now that we are done
		wait.setContent(response);
	}

}
