package simpletest;

import org.springframework.messaging.support.GenericMessage;

public class SimpleMessage extends GenericMessage<String>{

	public SimpleMessage(String payload) {
		super(payload);
	}
	
	public SimpleMessage() {
		super("");
	}
	
}