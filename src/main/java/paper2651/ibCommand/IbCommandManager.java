package paper2651.ibCommand;

import paper2651.ib.IBWrapper;

import com.ib.client.EClientSocket;

public class IbCommandManager {

	private static final String HOSTNAME = "localhost";

	private static IbCommandManager instance;

	private static EClientSocket clientSocket;

	public static IbCommandManager getInstance() {

		if (instance == null) {

			final IBWrapper ibWrapper = IBWrapper.getInstance();

			clientSocket = new EClientSocket(ibWrapper);

			clientSocket.eConnect(HOSTNAME, 7496, 1);

			instance = new IbCommandManager();
		}
		return instance;
	}

	public EClientSocket getClientSocket() {
		return clientSocket;
	}
}
