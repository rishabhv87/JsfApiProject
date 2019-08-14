package com.ManagedBean;



public class Login {

	private String customerID;
	private String password;
	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String verifyLogin() {
	//if(password == "password")	{
		//Customer.customerID = this.customerID;
		//customer.updateCustomer();
		return "success";
	//}else {
	//	return "failed";
//	}
		
		
	} 
	
	
	
}
