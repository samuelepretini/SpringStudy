package simpletest.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.SubscribableChannel;

import simpletest.SimpleMessage;
import simpletest.SimpleMessageHandler;

public class Receiver extends Thread{
	
	private ApplicationContext ctx = null;
	
	private String receiverName = "";

	public Receiver(ApplicationContext ctx,String receiverName) {
		super();
		this.ctx = ctx;
		this.receiverName = receiverName;
	}

	@Override
	public void run() {
	     SimpleMessageHandler simpleMessageHandler = ctx.getBean("simpleMessageHandler", SimpleMessageHandler.class);
	     
	     SubscribableChannel p2pChannel = ctx.getBean("directChannel", DirectChannel.class);
	     
	     System.out.println(receiverName+"--"+this.getName()+": " +"Subscribing...");
	     p2pChannel.subscribe(simpleMessageHandler);
	     
	     System.out.println(receiverName+"--"+this.getName()+": " +"Subscribed");
	}

}
