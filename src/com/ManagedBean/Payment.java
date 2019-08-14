package com.ManagedBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import org.json.JSONObject;

import com.Controller.APIClient;

public class Payment {

	private String customerID;
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	private String debitAccountNumber;
	private String creditAccountNumber;
	private String message;
	private String paymentDate;
	private String paymentStatus;
	private double amount;
	private long paymentIDNumber;
	private double threshold = 12000;
	
	public String getDebitAccountNumber() {
		return debitAccountNumber;
	}
	public void setDebitAccountNumber(String debitAccountNumber) {
		this.debitAccountNumber = debitAccountNumber;
	}
	public String getCreditAccountNumber() {
		return creditAccountNumber;
	}
	public void setCreditAccountNumber(String creditAccountNumber) {
		this.creditAccountNumber = creditAccountNumber;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getPaymentIDNumber() {
		return paymentIDNumber;
	}
	public void setPaymentIDNumber(long paymentIDNumber) {
		this.paymentIDNumber = paymentIDNumber;
	}
	 
	public String processPayment() {
		
		  String apiResponse = callPaymentAPI(this.debitAccountNumber, this.creditAccountNumber, this.message,
				  this.amount, this.paymentDate);
		  JSONObject obj = new JSONObject(apiResponse);
	      this.debitAccountNumber = Long.toString(obj.getLong("debitAccountNumber"));
	      this.creditAccountNumber = Long.toString(obj.getLong("creditAccountNumber"));
	      this.message = obj.getString("message");
	      this.amount = obj.getDouble("amount");
	      this.paymentDate = obj.getString("paymentDate");
	      this.paymentStatus = obj.getString("paymentStatus");
	      this.paymentIDNumber = obj.getLong("paymentIDNumber");
		  double updatedAccBal = getAccountBalance() ;
	      if (updatedAccBal < threshold) {
	    	  System.out.println("fund low");
	    	  intiateIntraPayment(5000);
	      }
		return "paymentwithoutKIDSuccess";
	}
	
	public String callPaymentAPI(String debitAccountNumber , String creditAccountNumber , String message,
			 double amount, String paymentDate) {
		
		JSONObject jsonRequest = new JSONObject();
		jsonRequest.put("debitAccountNumber",debitAccountNumber);
		jsonRequest.put("creditAccountNumber",creditAccountNumber);
		jsonRequest.put("message",message);
		jsonRequest.put("amount",amount);
		jsonRequest.put("paymentDate",paymentDate);
		
		APIClient apiClient = new APIClient();
		String httpUrl = "https://dnbapistore.com/hackathon/payments/1.0/payment";
		String httpGetResponseText = apiClient.callPutRequest( httpUrl , jsonRequest);
		return httpGetResponseText;
		
	}
	
	
	
	public String searchPayment() {
		
		
		APIClient apiClient = new APIClient();
		String httpUrl = "https://dnbapistore.com/hackathon/payments/1.0/payment/" + paymentIDNumber;
		String httpGetResponseText = apiClient.callApi( "GET",httpUrl, null);
		
		JSONObject obj = new JSONObject(httpGetResponseText);
	      this.debitAccountNumber = Long.toString(obj.getLong("debitAccountNumber"));
	      this.creditAccountNumber = Long.toString(obj.getLong("creditAccountNumber"));
	      this.message = obj.getString("message");
	      this.amount = obj.getDouble("amount");
	      this.paymentDate = obj.getString("paymentDate");
	      this.paymentIDNumber = obj.getLong("paymentIDNumber");
		return "paymentSearchConfirmed";
		
	}
	
	
public double getAccountBalance() {
	APIClient apiClient = new APIClient();
	Customer customer = (Customer)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("customer");
	this.customerID = customer.getCustomerID();
	String httpUrl = "https://dnbapistore.com/hackathon/accounts/1.0/account/balance?accountNumber=" + this.debitAccountNumber
			+ "&customerID=" + this.customerID;
	String httpGetResponseText = apiClient.callApi( "GET",httpUrl, null);
	
	JSONObject obj = new JSONObject(httpGetResponseText);
	return obj.getDouble("availableBalance");
	
}

public void intiateIntraPayment( double lackingFund) {
	
	String cCreditAccNo = this.debitAccountNumber;
	double maxAmount = 0;
	long debitAccount = 0;
	AccountOverview accountOverview = new AccountOverview();
	accountOverview.setCustomerID(this.customerID);
	accountOverview.getAccountListed();
	List<Account> accountList = accountOverview.getAccountList();
	
	Iterator<Account> accountIterator = accountList.iterator();
	while (accountIterator.hasNext()) {
    Account account = accountIterator.next();
    if (account.getAccountBalance() > maxAmount) {
    	maxAmount = account.getAccountBalance();
    	debitAccount = account.getAccountNumber(); }
	}
	String cDebitAccNo = Long.toString(debitAccount);
	String msg = " Automated Cash manager threshold balance adjustment";
	callPaymentAPI(cDebitAccNo, cCreditAccNo , msg, lackingFund , this.paymentDate) ;
	System.out.println("intra payment succeeded");
}

}
