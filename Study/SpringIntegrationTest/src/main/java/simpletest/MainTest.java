package simpletest;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.GenericMessage;

import simpletest.consumer.Receiver;
import simpletest.consumer.Receiver2;
import simpletest.producer.Sender;

public class MainTest {
	
	public static void main(String... args) throws Exception {
        @SuppressWarnings("resource")
		ApplicationContext ctx =  new ClassPathXmlApplicationContext("simpletest/context.xml");
       
        
        //Registering message channel
        MessageChannel inChannel = ctx.getBean("numberChannel", MessageChannel.class);
        //inChannel.send(new GenericMessage<String>("5"));
        
        //Using point-to-point channel
        
        
        System.out.println("Creating receiver1");
        Receiver receiver1 = new Receiver(ctx,"Receiver1");
        receiver1.start();
        
       /* System.out.println("Creating receiver2");
        Receiver2 receiver2 = new Receiver2(ctx,"Receiver2");
        receiver2.start();
        */
        Thread.sleep(1000);
        
        System.out.println("Create sender");
        Sender sender = new Sender(ctx);
        sender.start();
        
        Sender sender2 = new Sender(ctx);
        sender2.start();
        
        
        
        Thread.sleep(5000);
        System.out.println("Stopping........");
        sender.unblock();
        sender2.unblock();
        
    }

}
