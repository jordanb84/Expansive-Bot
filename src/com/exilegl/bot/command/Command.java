package com.exilegl.bot.command;

import com.skype.ChatMessage;
import com.skype.SkypeException;

public abstract class Command {

	//The command's name
	private String command;
	
	//Command wait message, shown when the command is being performed before finally edited into the response
	private String waitMessage;
	
	//The command's description displayed in /help
	private String description;
	
	public Command(String command, String description){
		this.setCommand(command);
		this.setDescription(description);
		//Register the command for calling later on
		Commands.register(this);
		//Set default wait message
		this.setWaitMessage("Performing command...");
	}
	
	/**
	 * Called when the command is performed
	 * @param received The chat message which is calling this command
	 */
	public abstract void perform(ChatMessage received) throws SkypeException;

	/**
	 * Returns a wait message to edit and
	 * displays it
	 */
	public ChatMessage performWait(ChatMessage received){
		ChatMessage message = null;
		try {
			message = (received.getSender().send(this.getWaitMessage()));
		} catch (SkypeException e) {
			e.printStackTrace();
		}
		return message;
	}
	
	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getWaitMessage() {
		return waitMessage;
	}

	public void setWaitMessage(String waitMessage) {
		this.waitMessage = waitMessage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
