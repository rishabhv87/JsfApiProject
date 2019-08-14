package com.ManagedBean;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.json.JSONArray;
import org.json.JSONObject;

import com.Controller.APIClient;
import com.Controller.DBAccessController;

public class AccountOverview {

	private String customerID;
	private List<Account> accountList;
	private double totalLiquidity;
	
	public double getTotalLiquidity() {
		return totalLiquidity;
	}

	public void setTotalLiquidity(double totalLiquidity) {
		this.totalLiquidity = totalLiquidity;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public String getAccountListed()
	{
		accountList = new ArrayList<Account>();
		if(this.customerID == null || this.customerID.equalsIgnoreCase("")) {
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
			Map m = context.getRequestParameterMap();
			String customerid = m.get("customerID").toString();
		  //Map<String,String> params =   getFacesContext().getRequestParameterMap();
		 // String idString = params.get("myId");
		 // long id = Long.parseLong(idString);
		
		this.customerID= customerid;
		}
		APIClient apiClient = new APIClient();
		String httpUrl = "https://dnbapistore.com/hackathon/accounts/1.0/account/customer/" + this.customerID;
		String httpGetResponseText = apiClient.callApi("GET", httpUrl , null);
		
		 JSONObject obj = new JSONObject(httpGetResponseText);
		 
		totalLiquidity =0;
		 JSONArray accountArray = obj.getJSONArray("accounts");
		 for(int i = 0 ; i < accountArray.length() ; i++){
			 Account account = new Account();
			 account.setCustomerID(this.customerID);
			 account.setAccountNumber(accountArray.getJSONObject(i).getLong("accountNumber"));
			 account.setAccountType(accountArray.getJSONObject(i).getString("accountType"));
			 account.setAccountBalance(accountArray.getJSONObject(i).getDouble("availableBalance"));
			 account.getAccountDetail();
			 totalLiquidity = totalLiquidity + account.getEquivalentNokBalance();
			 accountList.add(account);
		 }
		 
	/*	 DBAccessController dbController = new DBAccessController();
		 try {
		 ResultSet rs = dbController.callDB("Select DisponentAccId from DISPONENT_ACCOUNT where CustId = " +this.customerID);
		 while(rs.next())  {
		 Account account = new Account();
		 account.setAccountNumber(Long.parseLong(rs.getString(1)));
		 account.setAccountType("disponent");
		 accountList.add(account);
		 }
		 }catch(Exception e){ System.out.println(e);}*/
		return "accountSuccess";
	}
	
	
}
