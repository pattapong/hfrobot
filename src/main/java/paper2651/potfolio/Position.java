package paper2651.potfolio;

import com.ib.client.Contract;

public class Position {

	private String account;

	private Contract contract;

	private int position;

	private double avgCost;

	public void setAccount(String account) {
		this.account = account;

	}

	public void setContract(Contract contract) {
		this.contract = contract;

	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void setAverageCost(double avgCost) {
		this.avgCost = avgCost;
	}

	public double getAvgCost() {
		return avgCost;
	}

	public void setAvgCost(double avgCost) {
		this.avgCost = avgCost;
	}

	public String getAccount() {
		return account;
	}

	public Contract getContract() {
		return contract;
	}

	public int getPosition() {
		return position;
	}

}
