package com.parse.starter;

import java.util.Arrays;

import android.graphics.Bitmap;
import android.util.Log;

public class Event {
	private Bitmap imageSource;
	private String title;
	private String addressStreet;
	private String addressCity;
	private String addressPostalCode;
	private String date;
	private String time;
	private String description;
	private int numberTicketHolders;
	private TicketHolder[] ticketHoldersArray;
	private int posArray;
	private String id;
	private Bitmap bitmap;
	private double amountSpent;
	
	public Event(Bitmap imageSource, String title, String street, String city,
			String postalCode, String date, String time, String description,
			int numberTicketHolders, double amountSpent) {
		this.imageSource = imageSource;
		this.title = title;
		this.addressStreet = street;
		this.addressCity = city;
		this.addressPostalCode = postalCode;
		this.date = date;
		this.time = time;
		this.description = description;
		this.numberTicketHolders = numberTicketHolders;
		this.amountSpent=amountSpent;
		ticketHoldersArray = new TicketHolder[this.numberTicketHolders];
		posArray = 0;
	}

	public String getEventTitle() {
		return title;
	}

	public void setEventTitle(String eventTitle) {
		this.title = eventTitle;
	}
	public boolean hasBitmap(){
		if(bitmap == null)
			return false;
		return true;
	}
	public Bitmap getBitmap(){
		return bitmap;
	}
	public void setBitmap(Bitmap bm){
		bitmap = bm;
	}
	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressPostalCode() {
		return addressPostalCode;
	}

	public void setAddressPostalCode(String addressPostalCode) {
		this.addressPostalCode = addressPostalCode;
	}
	
	public String getCompleteAddress() {
		if (this.addressCity != "") {
			return this.addressStreet + "\n" + this.addressCity + " "
					+ this.addressPostalCode;
		} else {
			return this.addressStreet + "\n" + this.addressPostalCode;
		}
	}

	public String getEventDate() {
		return date;
	}

	public void setEventDate(String date) {
		this.date = date;
	}

	public String getEventTime() {
		return time;
	}

	public void setEventTime(String time) {
		this.time = time;
	}

	public String getCompleteTime() {
		return this.date + "\n" + this.time;
	}

	public String getEventDescription() {
		return description;
	}

	public void setEventDescription(String description) {
		this.description = description;
	}

	public int getNumberTicketHolders() {
		return numberTicketHolders;
	}

	public void setNumberTicketHolders(int numberTicketHolders) {
		this.numberTicketHolders = numberTicketHolders;
	}

	public void addTicketHolders(String ticketHolderName,
			String ticketHolderPhone, String ticketHolderEmail) {
		if (posArray < numberTicketHolders) {
			ticketHoldersArray[posArray] = new TicketHolder(ticketHolderName,
					ticketHolderPhone, ticketHolderEmail, null, 0);
			posArray = posArray + 1;
		}
	}

	public TicketHolder getTickerHolderFromArray(int pos) {
		return ticketHoldersArray[pos];
	}

	public TicketHolder[] getTicketHoldersArray() {
		return ticketHoldersArray;
	}

	public void setTicketHoldersArray(TicketHolder[] list) {
		for (int i = 0; i < list.length; i++) {
			ticketHoldersArray[i] = list[i];
		}
	}

	public void setTicketHoldersArray(String[] names, String[] phones,
			String emails[]) {

	}

	public String[] getTicketHoldersArrayNames() {
		String names[] = new String[numberTicketHolders];
		for (int i = 0; i < numberTicketHolders; i++) {
			names[i] = ticketHoldersArray[i].getName();
		}
		return names;
	}

	public String getTicketHoldersStringNames() {
		String names = "";
		for (int i = 0; i < numberTicketHolders; i++) {
			names = names + ticketHoldersArray[i].getName() + ";";
		}
		return names;
	}

	public String getTicketHoldersStringPhones() {
		String phones = "";
		for (int i = 0; i < numberTicketHolders; i++) {
			phones = phones + ticketHoldersArray[i].getPhone() + ";";
		}
		return phones;
	}

	public String getTicketHoldersStringEmail() {
		String email = "";
		for (int i = 0; i < numberTicketHolders; i++) {
			email = email + ticketHoldersArray[i].getEmail() + ";";
		}
		return email;
	}

	public String[] getTicketHoldersArrayPhones() {
		String phones[] = new String[numberTicketHolders];
		for (int i = 0; i < numberTicketHolders; i++) {
			phones[i] = ticketHoldersArray[i].getPhone();
		}
		return phones;
	}

	public String[] getTicketHoldersArrayEmails() {
		String emails[] = new String[numberTicketHolders];
		for (int i = 0; i < numberTicketHolders; i++) {
			emails[i] = ticketHoldersArray[i].getEmail();
		}
		return emails;
	}

	public void setTicketHoldersFromStrings(String names, String phones,
			String emails) {

		String namesArr[] = names.split(";");
		Log.d("Split namesArr: ", Arrays.toString(namesArr));
		String phonesArr[] = phones.split(";");
		Log.d("Split phonesArr: ", Arrays.toString(phonesArr));
		String emailsArr[] = emails.split(";");
		Log.d("Split emailsArr: ", Arrays.toString(emailsArr));

		for (int i = 0; i < numberTicketHolders; i++) {
			this.addTicketHolders(namesArr[i], phonesArr[i],
					emailsArr[i]);
		}
	}

	public Bitmap getEventImage() {
		return imageSource;
	}

	public void setEventImage(Bitmap imageSource) {
		this.imageSource = imageSource;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getAmountSpent() {
		return amountSpent;
	}

	public void setAmountSpent(double amountSpent) {
		this.amountSpent = amountSpent;
	}
}
