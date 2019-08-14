package com.ManagedBean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.faces.context.FacesContext;

import org.apache.commons.collections.SortedBag;

public class PaymentOverview {

	private String customerID;
	private String dateFrom;
	private String dateTo;
	private SortedMap<Long,Transaction> sortedMap = new TreeMap<Long, Transaction>();
	private List<Transaction> transactionList = new ArrayList<Transaction>();
	
	public List<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

	public List<Transaction> getKeyList(){
		ArrayList<Transaction> keyList = new ArrayList<Transaction>(sortedMap.values());
		
	     return keyList;
	}
	
	public String getCustomerID() {
		return customerID;
	}



	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}



	public String getDateFrom() {
		return dateFrom;
	}



	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}



	public String getDateTo() {
		return dateTo;
	}



	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}



	public SortedMap<Long, Transaction> getSortedMap() {
		return sortedMap;
	}



	public void setSortedMap(SortedMap<Long, Transaction> sortedMap) {
		this.sortedMap = sortedMap;
	}



	public  String getAllAccountTxnStatement(){
		
	Customer customer = (Customer)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("customer");
	this.customerID = customer.getCustomerID();
		
	AccountOverview accountOverview = new AccountOverview();
	accountOverview.setCustomerID(this.customerID);
	accountOverview.getAccountListed();
	List<Account> accountList = accountOverview.getAccountList();
	Iterator<Account> accountIterator = accountList.iterator();
	while (accountIterator.hasNext()) {
	    Account account = accountIterator.next();
	    TransactionSearchList accountTxnList =  new TransactionSearchList();
	    accountTxnList.setCustomerID(this.customerID);
	    accountTxnList.setAccountNumber(Long.toString(account.getAccountNumber()));
	    accountTxnList.setDateFrom("07092017");
	    accountTxnList.setDateTo("09102017");
	    accountTxnList.updateTransactionDetails();
	    accountTxnList.getTxnList();
	    sortedMap.putAll(accountTxnList.getTxnList());
	    
	}
	return "allAccTxnDetailFetched";
}
}
