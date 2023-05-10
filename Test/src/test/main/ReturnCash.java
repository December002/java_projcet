	package test.main;

public class ReturnCash {
	public int balance=10000;
	public int cashIn=1000;
	public int cashOut=4000;
	
	public int cashInResult() {
		balance += cashIn;
		return balance;
	}
	
	public int cashOutResult() {
		balance -= cashOut;
		return balance;
	}
	
	public static void main(String[] args) {
		ReturnCash rc = new ReturnCash();
		System.out.println(rc.cashInResult());
		
		System.out.println(rc.cashOutResult());
	}
	
	
}
