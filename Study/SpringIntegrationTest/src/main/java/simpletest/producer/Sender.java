package simpletest.producer;

import org.springframework.context.ApplicationContext;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.SubscribableChannel;

import simpletest.SimpleMessage;
import simpletest.SimpleMessageHandler;

public class Sender extends Thread{
	
	private ApplicationContext ctx = null;
	
	private static Object sem = new Object();

	public Sender(ApplicationContext ctx) {
		super();
		this.ctx = ctx;
	}

	@Override
	public void run() {
		System.out.println(this.getName()+": " +"Start sender: "+this.getId());
		SimpleMessage simpleMessage = (SimpleMessage)ctx.getBean("simpleMessage", new Object[]{"**** Hello World!!! ******"});
        
        SubscribableChannel p2pChannel = ctx.getBean("directChannel", DirectChannel.class);
        
        System.out.println(this.getName()+": " +"Sending");
        p2pChannel.send(simpleMessage);
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
