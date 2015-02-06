package messagingchannel;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.SubscribableChannel;

public class SimpleSubscribableChannel implements SubscribableChannel{

	@Override
	public boolean send(Message<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean send(Message<?> arg0, long arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean subscribe(MessageHandler arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unsubscribe(MessageHandler arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
