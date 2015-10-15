package com.exilegl.bot.command;

public enum CommandIdentifier {

	Default("."), Explanation("!");
	
	CommandIdentifier(String id){
		this.ID = id;
	}
	
	public final String ID;
	
	//The list of command identifiers which commands should be activated by
	public static final CommandIdentifier[] IDENTIFIERS = {Default, Explanation};
	
}
