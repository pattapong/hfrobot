package paper2651.main;

import paper2651.ibCommand.IbCommand;
import paper2651.ibCommand.IbCommandEnum;
import paper2651.ibCommand.IbCommandFactory;

public class GetCurrentPositionThread extends Thread {

	private int interval = 3000;

	public GetCurrentPositionThread(final int milliseconds) {
		this.interval = milliseconds;
	}

	public void run() {
		System.out.println("Start getting current position every " + interval
				+ " milliseconds");

		final IbCommand ibPosition = IbCommandFactory
				.getIbCommand(IbCommandEnum.Position);
		
		while (true) {
			
			ibPosition.execute(null);
			
			try {
				Thread.sleep(interval);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
