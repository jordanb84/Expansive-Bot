package com.exilegl.bot.command.ordinary;

import java.util.Random;

import com.exilegl.bot.command.Command;
import com.skype.ChatMessage;
import com.skype.Skype;
import com.skype.SkypeException;

public class CommandSpam extends Command{

	public CommandSpam() {
		super("spam", "spam <username> <times> - Spams the user with random messages, up to 100 times");
		
	}

	@Override
	public void perform(ChatMessage received) throws SkypeException {
		//Display wait message and make instance to edit when we're done
		ChatMessage wait = this.performWait(received);
		//Perform logic
		int times = (Integer.parseInt(received.getContent().split(" ")[2]));
		String username = (received.getContent().split(" ")[1]);
		
		Random r = new Random();
		for(int i = 0; i < times; i++){
			Skype.getUser(username).send("" + r.nextInt(10000));
		}
		
		String response = ("Successfully spammed " + username + " " + times + " times. What a bitch.");
		//Edit wait message to our logic's answer now that we are done
		wait.setContent(response);
	}

}
