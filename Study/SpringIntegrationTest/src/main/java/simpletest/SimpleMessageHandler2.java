package simpletest;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

public class SimpleMessageHandler2 implements MessageHandler{
	
	@Override
	public void handleMessage(Message<?> arg0) throws MessagingException {
		System.out.println(Thread.currentThread().getName()+": " +"---------- Handling message 2 ------------");
		System.out.println(Thread.currentThread().getName()+": " +"Message payload 2: "+arg0.getPayload());
	}

}
