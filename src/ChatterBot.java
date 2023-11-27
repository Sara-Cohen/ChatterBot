import java.util.*;

/**
 * Base file for the ChatterBot exercise.
 * The bot's replyTo method receives a statement.
 * If it starts with the constant REQUEST_PREFIX, the bot returns 
 * whatever is after this prefix. Otherwise, it returns one of
 * a few possible replies as supplied to it via its constructor.
 * In this case, it may also include the statement after 
 * the selected reply (coin toss).
 * @author Dan Nirel
 */
class ChatterBot {
	static final String REQUEST_PREFIX = "say ";
	
	Random rand = new Random();
	String name;
	String[] repliesToLegalRequest;
	String[] repliesToIllegalRequest;

	ChatterBot(String name, String[] repliesToLegalRequest, String[] repliesToIllegalRequest) {
		this.repliesToLegalRequest = new String[repliesToLegalRequest.length];
		for(int i = 0 ; i < repliesToLegalRequest.length ; i++)
			this.repliesToLegalRequest[i] = repliesToLegalRequest[i];
		this.repliesToIllegalRequest = new String[repliesToIllegalRequest.length];
		for(int i = 0 ; i < repliesToIllegalRequest.length ; i++)
			this.repliesToIllegalRequest[i] = repliesToIllegalRequest[i];
		this.name = name;
	}

	String replyTo(String statement) {
		if(statement.startsWith(REQUEST_PREFIX)) {
			return respondToLegalRequest(statement);
		}
		return respondToIllegalRequest(statement);
	}
	
	String respondToIllegalRequest(String statement) {
		int randomIndex = rand.nextInt(repliesToIllegalRequest.length);
		String reply = repliesToIllegalRequest[randomIndex];
		if(rand.nextBoolean()) {
			reply = reply + statement;
		}
		return reply;
	}

	String respondToLegalRequest(String statement) {
		String phrase=statement.replaceFirst(REQUEST_PREFIX, "");
		int randomIndex = rand.nextInt(repliesToLegalRequest.length);
		String reply = repliesToLegalRequest[randomIndex].replaceAll("<phrase>",phrase);
		if(rand.nextBoolean()) {
			reply = reply + statement;
		}
		return reply;
	}
	String getName (){
		return this.name;
	}
}
