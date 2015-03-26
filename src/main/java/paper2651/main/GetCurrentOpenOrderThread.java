package paper2651.main;

import paper2651.ibCommand.IbCommand;
import paper2651.ibCommand.IbCommandEnum;
import paper2651.ibCommand.IbCommandFactory;

public class GetCurrentOpenOrderThread extends Thread {

	private int interval = 1000;

	public GetCurrentOpenOrderThread(final int milliseconds) {
		this.interval = milliseconds;
	}

	public void run() {
		System.out.println("Start getting current open order every " + interval
				+ " milliseconds");

		final IbCommand ibRequestOpenOrder = IbCommandFactory
				.getIbCommand(IbCommandEnum.RequestOpenOrder);

		while (true) {
			
			ibRequestOpenOrder.execute(null);
			
			try {
				Thread.sleep(interval);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
