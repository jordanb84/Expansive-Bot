package com.exilegl.bot.command.ordinary;

import com.exilegl.bot.command.Command;
import com.exilegl.bot.json.JsonParser;
import com.skype.ChatMessage;
import com.skype.SkypeException;

public class CommandYomama extends Command{

	public CommandYomama() {
		super("yomama", "Gets a yomama joke");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void perform(ChatMessage received) throws SkypeException {
		//Display wait message and make instance to edit when we're done
		ChatMessage wait = this.performWait(received);
		//Perform logic
		JsonParser parser = new JsonParser();
		String response = (parser.getFromUrl("joke", "http://api.yomomma.info/"));
		//Edit wait message to our logic's answer now that we are done
		wait.setContent(response);
	}

}
