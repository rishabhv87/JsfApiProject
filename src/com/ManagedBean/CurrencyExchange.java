package com.ManagedBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


import org.json.JSONObject;

import com.Controller.APIClient;

public class CurrencyExchange {

	private String baseCurrency;
	private String date;
	private Map<String, Double> exchangeRates;
	private ArrayList<String> keyList;
	
	public ArrayList<String> getKeyList() {
		return keyList;
	}
	public void setKeyList(ArrayList<String> keyList) {
		this.keyList = keyList;
	}
	public String getBaseCurrency() {
		return baseCurrency;
	}
	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}
	public Map<String, Double> getExchangeRates() {
		return exchangeRates;
	}
	public void setExchangeRates(Map<String, Double> exchangeRates) {
		this.exchangeRates = exchangeRates;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	
	public String getExchangeRatesList() {
		
	
		APIClient apiClient = new APIClient();
		String httpUrl = "https://dnbapistore.com/hackathon/currencies/1.0/currency/exchange?base=" 
										+ this.baseCurrency +  "&date=" + this.date;
		String httpGetResponseText = apiClient.callApi("GET", httpUrl , null);
		JSONObject obj = new JSONObject(httpGetResponseText);
		obj= obj.getJSONObject("rates");
		Iterator<?> keyset = obj.keys();
		keyList = new ArrayList<String>();
		exchangeRates =new HashMap<String, Double>();
		
		while (keyset.hasNext()) {
            String key =  (String) keyset.next();
            Object value = obj.get(key);
            exchangeRates.put(key, (Double) value);
		}
		
		keyList = new ArrayList<String>(exchangeRates.keySet());
		return "sucessExchangeRates";
	}
	
}
