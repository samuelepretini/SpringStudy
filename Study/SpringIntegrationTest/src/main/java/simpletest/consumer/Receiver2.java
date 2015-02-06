package simpletest.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.SubscribableChannel;

import simpletest.SimpleMessageHandler;
import simpletest.SimpleMessageHandler2;

public class Receiver2 extends Thread{
	
private ApplicationContext ctx = null;
	
	private String receiverName = "";

	public Receiver2(ApplicationContext ctx,String receiverName) {
		super();
		this.ctx = ctx;
		this.receiverName = receiverName;
	}

	@Override
	public void run() {
	     SimpleMessageHandler2 simpleMessageHandler = ctx.getBean("simpleMessageHandler2", SimpleMessageHandler2.class);
	     
	     SubscribableChannel p2pChannel = ctx.getBean("directChannel", DirectChannel.class);
	     
	     System.out.println(receiverName+"--"+this.getName()+": " +"Subscribing...");
	     p2pChannel.subscribe(simpleMessageHandler);
	     
	     System.out.println(receiverName+"--"+this.getName()+": " +"Subscribed");
	}

}
