package com.parse.starter;

import android.widget.Button;

public class TicketHolder {
	private String name;
	private String phone;
	private String email;
	private Button close;
	public int id;
	public TicketHolder(String name, String phone, String email, Button close, int id) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.close = close;
		this.id = id;
		
		
	}
	
	public Button getButton(){
		return close;
	}
	
	public int getId(){
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
