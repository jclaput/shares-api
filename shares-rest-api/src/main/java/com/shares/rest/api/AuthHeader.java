package com.shares.rest.api;

import java.sql.Timestamp;
import java.util.Base64;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

public class AuthHeader {
			
	private String authHead;
	private String token;
	
	private String id;
	private String subject;
	private Date issueDate;
	private Date expirationDate;
			
	public AuthHeader(HttpServletRequest request) {		
		this.authHead = request.getHeader("Authorization");
		
		this.token = authHead.replace(Constants.getPrefix() + " ", "");
		
        String[] splitString = this.token.split("\\.");
        //String base64EncodedHeader = splitString[0];
        String base64EncodedBody = splitString[1];
        //String base64EncodedSignature = splitString[2];
        
		
		String body = new String(Base64.getDecoder().decode(base64EncodedBody));
		JSONObject jsonBody = new JSONObject(body);
		
		this.id = jsonBody.getString("jti");
		this.subject = jsonBody.getString("sub");
		
		Timestamp tsIssueDate = new Timestamp(jsonBody.getLong("iat"));
		this.issueDate = new Date(tsIssueDate.getTime());
		
		Timestamp tsExpirationDate = new Timestamp(jsonBody.getLong("exp"));
		this.expirationDate = new Date(tsExpirationDate.getTime());
	}

	public String getId() {
		return id;
	}
	
	public String getSubject() {
		return subject;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}
	
	public boolean isAnonymous() {		
		return this.subject.equalsIgnoreCase("anonymous");
	}
}