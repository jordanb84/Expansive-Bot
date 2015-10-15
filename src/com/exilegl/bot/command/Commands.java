package com.exilegl.bot.command;

import java.util.ArrayList;
import java.util.List;

import com.skype.ChatMessage;
import com.skype.SkypeException;

public class Commands {

	//The full list of registered commands
	public static List<Command> commands = new ArrayList<Command>();
	
	//Message sent to the user if a command fails
	public static final String error = ("Error: An API related error occurred while performing this command.");
	
	/**
	 * Returns whether or not the given
	 * identifier is a command, and if so,
	 * calls it
	 * 
	 * (when it returns false I should send a "Unknown command" message)
	 * @throws SkypeException 
	 */
	public static boolean checkCommand(String identifier, ChatMessage received) throws SkypeException{
		boolean valid = false;
		for(Command c : commands){
			System.out.println("Checking command " + c.getCommand());
			for(CommandIdentifier i : CommandIdentifier.IDENTIFIERS)
			{
			if(received.getContent().toString().split(" ")[0].equals(i.ID + c.getCommand())){
				valid = true;
				try {
					c.perform(received);
				} catch (SkypeException e) {
					//An error has occurred while performing the command, so tell the user
					try {
						received.getSender().send(error);
					} catch (SkypeException e1) {
						//Something is wrong beyond the command
						e1.printStackTrace();
					}
					e.printStackTrace();
				}
			}
		}
		}
		return valid;
	}
	
	/**
	 * Adds a new command to the list
	 */
	public static void register(Command command){
		commands.add(command);
	}
	
}
