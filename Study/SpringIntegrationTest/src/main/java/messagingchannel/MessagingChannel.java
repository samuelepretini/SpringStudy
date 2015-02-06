package messagingchannel;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

public class MessagingChannel implements MessageChannel{

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

}
