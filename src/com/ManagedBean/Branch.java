package com.ManagedBean;


import org.json.JSONObject;

import com.Controller.APIClient;

public class Branch {

	private String branchID;
	private String branchName;
	private String phoneNumber;
	private Location location;	
	private String zipCode;
	
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	private Address branchAddress;
	
	public String getBranchID() {
		return branchID;
	}
	public void setBranchID(String branchId) {
		this.branchID = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Address getBranchAddress() {
		return branchAddress;
	}
	public void setBranchAddress(Address branchAddress) {
		this.branchAddress = branchAddress;
	}
	
public String getBranchDetails() {
		

	String httpUrl ="";
	if(this.branchID !=null && !this.branchID.equalsIgnoreCase(""))
	{
		 httpUrl = "https://dnbapistore.com/hackathon/banks/1.0/bank/branch/" + this.branchID;
	}
	if(this.zipCode !=null && !this.zipCode.equalsIgnoreCase(""))
	{
		 httpUrl = "https://dnbapistore.com/hackathon/banks/1.0/bank/branch/zip/" + this.zipCode;
	}
		APIClient apiClient = new APIClient();
		String httpGetResponseText = apiClient.callApi("GET", httpUrl , null);
		
		 JSONObject obj = new JSONObject(httpGetResponseText);
	      this.branchID = obj.getString("branchID");
	      this.branchName = obj.getString("branchName");
	      this.phoneNumber = obj.getString("phoneNumber");
	      branchAddress = new Address();
	      branchAddress.setStreet(obj.getJSONObject("branchAddress").getString("street"));
	      branchAddress.setCity(obj.getJSONObject("branchAddress").getString("city"));
	      branchAddress.setPostalcode(obj.getJSONObject("branchAddress").getString("postalCode"));
	      branchAddress.setCountry(obj.getJSONObject("branchAddress").getString("country"));
	      this.setZipCode(zipCode);
	      location = new Location();
	      location.setLatitude(obj.getJSONObject("location").getString("latitude"));
	      location.setLongitude(obj.getJSONObject("location").getString("longitude"));
	           
	      return "branchSuccess";
	}
	
	
}
