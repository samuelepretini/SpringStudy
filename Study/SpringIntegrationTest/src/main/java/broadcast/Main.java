package broadcast;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




import broadcast.actors.Receiver;
import broadcast.actors.Sender;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		ApplicationContext ctx =  new ClassPathXmlApplicationContext("simpletest/context.xml");
		
		
	    System.out.println("Creating receiver1");
	    Receiver receiver = new Receiver(ctx, "Receiver1");
	    receiver.start();
	    Receiver receiver2 = new Receiver(ctx, "Receiver2");
	    receiver2.start();
	    Receiver receiver3 = new Receiver(ctx, "Receiver3");
	    receiver3.start();
	    
	    Thread.sleep(1000);
	    
	    System.out.println("Create sender");
        Sender sender = new Sender(ctx);
        sender.start();
        
        Thread.sleep(5000);
        System.out.println("Stopping........");
        sender.unblock();
	}

}
