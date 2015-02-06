package broadcast.actors;

import org.springframework.context.ApplicationContext;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.SubscribableChannel;

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
	     
	     PublishSubscribeChannel publishChannel = ctx.getBean("publishSubscribeChannel", PublishSubscribeChannel.class);
	     
	     System.out.println(receiverName+"--"+this.getName()+": " +"Subscribing...");
	     publishChannel.subscribe(simpleMessageHandler);
	     
	     System.out.println(receiverName+"--"+this.getName()+": " +"Subscribed");
	}

}
