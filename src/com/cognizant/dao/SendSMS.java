package com.cognizant.dao;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SendSMS {

	public static void sendSMS(String id,String name,String role,String mobile,String password,String status) {
		try {
			String recipient = mobile ;
			String message="";
			if(role.equals("Manager"))
			{
			if(status.equals("Approved"))
			{
			message="Hello "+role+", \n"+"Your Registration Status : "+status+"\n"+
			"Your "+role+" ID : "+id+"\n"+
			"Password : "+password;
			}
			else
			{
				message="Hello "+role+", \n"+"Your Registration Status : "+status+"\n"+
						"Try After Sometime";				
			}
			}
			else
			{
				message="Hello "+role+", \n"+"Your "+role+" ID : "+id+"\n"+
						"Password : "+password;
			}
			String username = "admin";
			String password1 = "admin";
			String originator = "9891839659";
			String requestUrl  = "http://127.0.0.1:9501/api?action=sendmessage&" +
			 "username=" + URLEncoder.encode(username, "UTF-8") +
			 "&password=" + URLEncoder.encode(password1, "UTF-8") +
			 "&recipient=" + URLEncoder.encode(recipient, "UTF-8") +
			 "&messagetype=SMS:TEXT" +
			 "&messagedata=" + URLEncoder.encode(message, "UTF-8") +
			 "&originator=" + URLEncoder.encode(originator, "UTF-8") +
			 "&serviceprovider=GSMModem1" +
			 "&responseformat=html";
			URL url = new URL(requestUrl);
			HttpURLConnection uc = (HttpURLConnection)url.openConnection();
			System.out.println(uc.getResponseMessage());
			uc.disconnect();
			} catch(Exception ex) {
			System.out.println(ex.getMessage());
			}

	}

}
