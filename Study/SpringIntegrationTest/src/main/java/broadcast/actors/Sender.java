package broadcast.actors;

import org.springframework.context.ApplicationContext;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.SubscribableChannel;

import simpletest.SimpleMessage;

public class Sender extends Thread{
	
private ApplicationContext ctx = null;
	
	private static Object sem = new Object();

	public Sender(ApplicationContext ctx) {
		super();
		this.ctx = ctx;
	}
	
	public void run() {
		System.out.println(this.getName()+": " +"Start sender: "+this.getId());
		SimpleMessage simpleMessage = (SimpleMessage)ctx.getBean("simpleMessage", new Object[]{"**** Hello World!!! ******"});
        
		PublishSubscribeChannel publishChannel = ctx.getBean("publishSubscribeChannel", PublishSubscribeChannel.class);
        
        System.out.println(this.getName()+": " +"Sending");
        publishChannel.send(simpleMessage);
        System.out.println(this.getName()+": " +"Sent...");
        
        try {
        	synchronized(sem){
        		System.out.println(this.getName()+": " +"Waiting...");
    			sem.wait();
        	}
        	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void unblock(){
		synchronized(sem){
		System.out.println(this.getName()+": " +"Sender unblocking");
		sem.notify();
		}
	}

}
