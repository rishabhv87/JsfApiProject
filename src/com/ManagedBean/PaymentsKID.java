package com.ManagedBean;

import org.json.JSONObject;

import com.Controller.APIClient;

public class PaymentsKID {

	private String debitAccountNumber;
	private String creditAccountNumber;
	private String KIDNumber;
	private String amount;
	private String paymentDate;
	
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
	public String getKIDNumber() {
		return KIDNumber;
	}
	public void setKIDNumber(String kIDNumber) {
		KIDNumber = kIDNumber;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	public String processPayment() {
		
		String jsonRequest = createJsonRequest();
		
		APIClient apiClient = new APIClient();
		String httpUrl = "https://dnbapistore.com/hackathon/payments/1.0/payment/kid";
		String httpGetResponseText = apiClient.callApi("PUT", httpUrl , jsonRequest);
		
		return "PaymentWithKidSuccessful";
	} 
	
	private String createJsonRequest() {
		
		JSONObject json = new JSONObject();
		json.put("debitAccountNumber",debitAccountNumber);
		json.put("creditAccountNumber",creditAccountNumber);
		json.put("KIDNumber",KIDNumber);
		json.put("amount",amount);
		json.put("paymentDate",paymentDate);
		
		 return json.toString();
		
	}
	
}
