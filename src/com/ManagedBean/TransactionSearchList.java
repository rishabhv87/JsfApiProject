package com.ManagedBean;

import java.util.SortedMap;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.Controller.APIClient;

public class TransactionSearchList {

	
	private String customerID;
	private String accountNumber;
	private String dateFrom;
	private String dateTo;
	
	SortedMap< Long,Transaction> txnList;

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

	public SortedMap<Long, Transaction> getTxnList() {
		return (SortedMap<Long, Transaction>) txnList;
	}

	public void setTxnList(SortedMap<Long,Transaction> txnList) {
		this.txnList = (SortedMap<Long, Transaction>) txnList;
	} 
	
	public String updateTransactionDetails(){
		txnList = new TreeMap<Long, Transaction>() ;
		
		
		APIClient apiClient = new APIClient();
		String httpUrl = "https://dnbapistore.com/hackathon/accounts/1.0/account?accountNumber="
		 + this.accountNumber + "&customerID=" + this.customerID + 
		 "&dateFrom="  + this.dateFrom + "&dateTo=" + this.dateTo;
		String httpGetResponseText = apiClient.callApi( "GET",httpUrl, null);
		
		JSONObject obj = new JSONObject(httpGetResponseText);

		
		if(obj.isNull("success")) {
			JSONArray transacationList = obj.getJSONArray("transactions");
		for(int i = 0 ; i < transacationList.length() ; i++){
			Transaction txn = new Transaction();
			txn.setCustomerID(this.customerID);
			txn.setAccountNumber(Long.toString(obj.getLong("accountNumber")));
			long txnId = transacationList.getJSONObject(i).getLong("transactionID");
		txn.setTransactionID(txnId);
		txn.setDate(transacationList.getJSONObject(i).getString("date"));
		txn.setTransactionType(transacationList.getJSONObject(i).getInt("transactionType"));
		double amount = transacationList.getJSONObject(i).getDouble("amount");
		txn.setAmount(Math.abs(amount));
		if(amount<0) {
			txn.setDebitOrCredit("Debit");
		}else {
			txn.setDebitOrCredit("Credit");
		}
		txn.setMsgOrKid(transacationList.getJSONObject(i).getString("message/KID"));
		txn.setTransactionAccountName(transacationList.getJSONObject(i).getString("transactionAccountName"));
		txn.setTransactionAccountNumber(Long.toString(transacationList.getJSONObject(i).getLong("transactionAccountNumber")));

		this.txnList.put(txnId , txn);
		}
		}
		return "TransactionDetailSuccess";
	}
	
}
