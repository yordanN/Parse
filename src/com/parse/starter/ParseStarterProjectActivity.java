package com.parse.starter;

import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ParseException;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.parse.FindCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class ParseStarterProjectActivity extends Activity {
	private static final String TABLE_EVENTS = "events";
	// Contacts Table Columns names
		private String EVENT_ID;
		private Bitmap EVENT_IMAGE ;
		private String EVENT_TITLE;
		private String EVENT_STREET;
		private String EVENT_CITY;
		private String EVENT_POSTALCODE;
		private String EVENT_DATE;
		private String EVENT_TIME;
		private String EVENT_DESCRIPTION;
		private String EVENT_NUMBERTICKETHOLDERS;
		private String EVENT_TICKETHOLDERNAME;
		private String EVENT_TICKETHOLDERPHONE;
		private String EVENT_TICKETHOLDEREMAIL;
		private double EVENT_AMOUNT;
		private ImageView img;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ParseAnalytics.trackAppOpenedInBackground(getIntent());

	    /*    WRITE A NEW OBJECT  */
	    Bitmap image = BitmapFactory.decodeResource(getApplicationContext().getResources(),
	            R.drawable.sample);
	    Event test = new Event(image, "FIRST PARSE EVENT", "275 av. Cacacoucou", "Montreal", "H9K6L8", "23/12/2015", "22:00", "To access the Google Maps servers with the Maps API, you have to add a Maps API key to your application. The key is free, you can use it with any of your applications that call the Maps API, and it supports an unlimited number of users.", 3, 25);
	    test.setId("9");
	    test.addTicketHolders("Eduardo", "514-255-6985", "chiquelo@hotmail.com");
	    test.addTicketHolders("Yordan", "514-488-1538", "daka@yahoo.com");
	    test.addTicketHolders("Arthur", "514-146-8596", "arthur@gmail.com");
	    //ParseApplication.addEventToDatabase(test);
	    
	    /*    READ AND STORE ALL OBJECTS INSIDE A LIST     */
	    ParseQuery query = new ParseQuery("Chiquelo");
	    query.whereEqualTo("Type", "Event");
	    query.findInBackground(new FindCallback<ParseObject>() {
	        public void done(List<ParseObject> eventList, ParseException e) {
	        }
			@Override
			public void done(List<ParseObject> eventList, com.parse.ParseException e) {
		           if (e == null) {
		                Log.d("score", "Retrieved " + eventList.size() + " events");
		                //Print Events id and name
		                for(int i =0; i<eventList.size();i++){
		            	  EVENT_ID= eventList.get(i).getString("Id");
		           
		                  ParseFile bum = (ParseFile) eventList.get(i).get("Image");
		                  byte[] image;
						try {
							image = bum.getData();
							EVENT_IMAGE = BitmapFactory.decodeByteArray(image,0,image.length);
						    //Log.d("GOOD", ""+EVENT_IMAGE.getWidth());
							setContentView(R.layout.mainm);
							img = (ImageView) findViewById(R.id.homePic);
						    img.setImageBitmap(EVENT_IMAGE);				
						} catch (com.parse.ParseException e1) {
							// TODO Auto-generated catch block
							Log.d("Error: ", "Fucked up Image");
							e1.printStackTrace();
						}
		                  EVENT_TITLE = eventList.get(i).getString("Name");	
		                  EVENT_STREET = eventList.get(i).getString("Street");	
		                  EVENT_CITY = eventList.get(i).getString("City");	
		                  EVENT_POSTALCODE = eventList.get(i).getString("Postalcode");	
		                  EVENT_DATE = eventList.get(i).getString("Date");	
		                  EVENT_TIME = eventList.get(i).getString("Time");	
		            	  EVENT_DESCRIPTION =  eventList.get(i).getString("Description");
		            	  EVENT_NUMBERTICKETHOLDERS = eventList.get(i).getString("NumTicketHs");	
		            	  EVENT_TICKETHOLDERNAME = eventList.get(i).getString("THSNames");	
		            	  EVENT_TICKETHOLDERPHONE = eventList.get(i).getString("THSPhones");	
		            	  EVENT_TICKETHOLDEREMAIL = eventList.get(i).getString("THSEmails");
		            	  EVENT_AMOUNT = eventList.get(i).getDouble("Amount");
		            	  
		            	  Log.d("ID: ",EVENT_ID);
		            	  Log.d("NAME: ",EVENT_TITLE);
		                }
		            } else {
		                Log.d("score", "Error: " + e.getMessage());
		            }
			}
	    });
	}
	
}
