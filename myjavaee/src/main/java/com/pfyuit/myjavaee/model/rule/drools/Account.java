package com.pfyuit.myjavaee.model.rule.drools;

/**
 * @author yupengfei
 */
public class Account {

	private Integer balance;

	public Account() {
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Account(Integer balance) {
		super();
		this.balance = balance;
	}

	public void withdraw(int money) {
		balance -= money;
	}

	public void printBalance() {
		System.out.println("Balance is: " + balance);
	}

}