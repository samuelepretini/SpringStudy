package messagingchannel;

import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;

public class SimplePollableChannel implements PollableChannel{

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
	public Message<?> receive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message<?> receive(long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
