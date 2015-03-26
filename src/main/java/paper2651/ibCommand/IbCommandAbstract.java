package paper2651.ibCommand;

import com.ib.client.EClientSocket;

public class IbCommandAbstract {
	
	public final EClientSocket clientSocket = IbCommandManager.getInstance().getClientSocket();
}
