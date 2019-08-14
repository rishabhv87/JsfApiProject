package com.ManagedBean;


import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.json.JSONObject;

import com.Controller.APIClient;


public class Account {

	private String customerID;
	private long accountNumber;
	private String iban;
	private String accountType;
	private double accountBalance;
	private double bookBalance;
	private String accountStatus;
	private String created;
	private String currency;
	private double equivalentNokBalance;
	private String bankName;
	
	
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public double getEquivalentNokBalance() {
		return equivalentNokBalance;
	}
	public void setEquivalentNokBalance(double equivalentNokBalance) {
		this.equivalentNokBalance = equivalentNokBalance;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public double getBookBalance() {
		return bookBalance;
	}
	public void setBookBalance(double bookBalance) {
		this.bookBalance = bookBalance;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public String getAccountDetail() {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		Map m = context.getRequestParameterMap();
		
		if(this.customerID == null || this.customerID.equalsIgnoreCase("")) 
		{
	
		this.customerID = m.get("customerID").toString();
		}
		if(this.accountNumber == 0) {
		String accountNumber = m.get("accountNumber").toString();
		this.accountNumber = Long.parseLong(accountNumber);
		}
		APIClient apiClient = new APIClient();
		String httpUrl = "https://dnbapistore.com/hackathon/accounts/1.0/account/details?accountNumber=" 
										+ this.accountNumber +  "&customerID=" + this.customerID;
		String httpGetResponseText = apiClient.callApi("GET", httpUrl , null);
		JSONObject obj = new JSONObject(httpGetResponseText);
		
		setAccountBalance(obj.getInt("availableBalance"));
		setBookBalance(obj.getInt("bookBalance"));
		setAccountNumber(obj.getLong("accountNumber"));
		this.accountStatus = obj.getString("accountStatus");
		this.accountType = obj.getString("accountType");
		this.created = obj.getString("created");
		this.customerID = obj.getString("customerID");
		this.iban = obj.getString("iban");
		this.currency = obj.getString("currency");
		if(!currency.equalsIgnoreCase("NOK")) {
			setEquivalentNokBalance(getEquivalentNOKConversionAmount(this.accountBalance , currency)); 
		}else {
			setEquivalentNokBalance(this.accountBalance);
		}
		
		this.setBankName(getBankName(Long.toString(this.accountNumber)));
		
		context.getSessionMap().put("account", this);
		
		return "success";
	}
	
	public String getBankName(String accountNumber) {
		 String bankName = "";
		 if (accountNumber.endsWith("44")){
			 bankName = "DNB ASA, Norway";
		 }else if(accountNumber.endsWith("83"))
		 {
			 bankName= "Sparebank, Norway";
		 }else if(accountNumber.endsWith("97"))
		 {
			 bankName= "Nordea, Norway";
		 }
		 else if(accountNumber.endsWith("07"))
		 {
			 bankName= "Danske Bank, Norway";
		 }
		 else if(accountNumber.endsWith("08"))
		 {
			 bankName= "SWED Bank, Sweden";
		 }
		 else if(accountNumber.endsWith("09"))
		 {
			 bankName= "Nordea, Sweden";
		 }else {
			 bankName= "DNB ASA";
		 }
		 
		 return bankName;
		
	}
	
	public double getEquivalentNOKConversionAmount(double baseAmount, String baseCurrency) {
		
		APIClient apiClient = new APIClient();
		String httpUrl = "https://dnbapistore.com/hackathon/currencies/1.0/currency/convert?base=" 
										+ baseCurrency +  "&foreignCurrency=NOK&amount=" + baseAmount + "&date=2017-09-07" ;
		String httpGetResponseText = apiClient.callApi("GET", httpUrl , null);
		JSONObject obj = new JSONObject(httpGetResponseText);
		
		return obj.getDouble("amount");
		
	}
	
}

