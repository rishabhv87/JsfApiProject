package com.ManagedBean;

import org.json.JSONObject;

import com.Controller.APIClient;

public class Customer {

	private String customerID;
	private String personalNumber;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private String nationality;
	private String phoneNumber;
	private String email;
	private String idnumber;
	private String idType;
	private Address address;
	
	
	
	/*public  Customer(String customerID) {
		this.customerID = customerID;
	}*/
	
	public String getCustomerID() {
		return customerID;
	}



	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}



	public String getPersonalNumber() {
		return personalNumber;
	}



	public void setPersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getNationality() {
		return nationality;
	}



	public void setNationality(String nationality) {
		this.nationality = nationality;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getIdnumber() {
		return idnumber;
	}



	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}



	public String getIdType() {
		return idType;
	}



	public void setIdType(String idType) {
		this.idType = idType;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
	}
	
	public String updateCustomer() {
		
		APIClient apiClient = new APIClient();
		String httpUrl = "https://dnbapistore.com/hackathon/customers/1.0/customer/" + this.customerID;
		String httpGetResponseText = apiClient.callApi("GET", httpUrl , null);
		
		 JSONObject obj = new JSONObject(httpGetResponseText);
	      this.personalNumber = obj.getString("personalNumber");
	      this.firstName = obj.getString("firstName");
	      this.lastName = obj.getString("lastName");
	      this.dateOfBirth = obj.getString("dateOfBirth");
	      this.gender = obj.getString("gender");
	      this.nationality = obj.getString("nationality");
	      this.phoneNumber = obj.getString("phoneNumber");
	      this.email = obj.getString("email");
	      this.idType = obj.getString("idType");
	      this.idnumber = obj.getString("idnumber");
	      address = new Address();
	      address.setStreet(obj.getJSONObject("address").getString("street"));
	      address.setCity(obj.getJSONObject("address").getString("city"));
	      address.setPostalcode(obj.getJSONObject("address").getString("postalCode"));
	      address.setCountry(obj.getJSONObject("address").getString("country"));
	      
	      System.out.println(personalNumber + " " + firstName + " " + lastName);
	      
	      return "customerSuccess";
	}

}
