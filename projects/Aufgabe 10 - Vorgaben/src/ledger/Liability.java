package ledger;

import exceptions.AccountClosedException;
import exceptions.AmountInsufficientException;

public class Liability extends Account {

	public Liability(String name) {
		super(name);
	}

	@Override
	public void credit(int value)
			throws AmountInsufficientException, AccountClosedException {

			if(!this.isOpen())
				throw new AccountClosedException("Cannot debit! Reason: The account is Closed");

			if(this.value < value)
				throw new AmountInsufficientException("Cannot debit! Reason: Insufficient Founds");

			delta -= value;
	}

	@Override
	public void debit(int value) {
		delta += value;
	}

}
