package com.ManagedBean;

import java.util.ArrayList;

import org.json.JSONObject;

import com.Controller.APIClient;

public class Transaction {

	
	private String customerID;
	private String accountNumber;
	private long transactionID;
	private String date;
	private int transactionType;
	private double amount;
	private String msgOrKid;
	private String transactionAccountNumber;
	private String transactionAccountName;
	private String debitOrCredit;
	
	public String getDebitOrCredit() {
		return debitOrCredit;
	}
	public void setDebitOrCredit(String debitOrCredit) {
		this.debitOrCredit = debitOrCredit;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getMsgOrKid() {
		return msgOrKid;
	}
	public void setMsgOrKid(String msgOrKid) {
		this.msgOrKid = msgOrKid;
	}
	public String getTransactionAccountNumber() {
		return transactionAccountNumber;
	}
	public void setTransactionAccountNumber(String transactionAccountNumber) {
		this.transactionAccountNumber = transactionAccountNumber;
	}
	public String getTransactionAccountName() {
		return transactionAccountName;
	}
	public void setTransactionAccountName(String transactionAccountName) {
		this.transactionAccountName = transactionAccountName;
	}
	

	
	
	
	
	
	
}
