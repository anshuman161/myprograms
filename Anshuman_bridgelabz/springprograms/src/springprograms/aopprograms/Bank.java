package springprograms.aopprograms;

public class Bank {
private int amount=5000;
private String accountno="sbi12345";
public int deposite(int amount,String accountno)
{
  if (accountno.equals(this.accountno))
  {
	 
	this.amount=this.amount+amount;
	return this.amount;
  }	
  else {
	 throw new AccountNumberException();
}
}
}
