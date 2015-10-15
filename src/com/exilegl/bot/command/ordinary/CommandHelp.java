package com.exilegl.bot.command.ordinary;

import com.exilegl.bot.command.Command;
import com.exilegl.bot.command.Commands;
import com.skype.ChatMessage;
import com.skype.SkypeException;

public class CommandHelp extends Command{

	public CommandHelp() {
		super("help", "Displays available commands");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void perform(ChatMessage received) throws SkypeException {
		//Display wait message and make instance to edit when we're done
		ChatMessage wait = this.performWait(received);
		//List each command
		String output = ("-----Expansive Commands-----");
		for(Command c : Commands.commands){
			output = (output + "\n" + c.getCommand() + " - " + c.getDescription());
		}
		//Edit wait message to our logic's answer now that we are done
		wait.setContent(output);
	}

}
