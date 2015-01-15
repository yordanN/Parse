package com.parse.starter;

import java.io.ByteArrayOutputStream;
import java.util.List;

import android.app.Application;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ParseException;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseCrashReporting;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class ParseApplication extends Application {
	
		
  @Override
  public void onCreate() {
    super.onCreate();
    // Initialize Crash Reporting.
    ParseCrashReporting.enable(this);
    // Add your initialization code here
    // Keys from parse representing our app
    Parse.initialize(this, "ExZgMR3sMmGQaa1h7UPnxJM4i6bcifU9FmtrFKj7", "R2RaSGwcAaQMlUhILN4oMvYWo0JrePOxH3c6wIky");
    ParseUser.enableAutomaticUser();
    ParseACL defaultACL = new ParseACL();
    // If you would like all objects to be private by default, remove this line.
    defaultACL.setPublicReadAccess(true);
    ParseACL.setDefaultACL(defaultACL, true);
  }
  
  public static void addEventToDatabase(Event event){
	  ByteArrayOutputStream stream = new ByteArrayOutputStream();
	  event.getEventImage().compress(Bitmap.CompressFormat.PNG, 100, stream);
	  byte[] imageInByte = stream.toByteArray();
	  ParseFile image = new ParseFile("image.bmp", imageInByte);
	  image.saveInBackground();
	  
	  ParseObject testObject = new ParseObject("Chiquelo");
	  testObject.put("Type", "Event");
	  testObject.put("Id", event.getId());
	  testObject.put("Image", image);
	  testObject.put("Name", event.getEventTitle());
	  testObject.put("Street", event.getAddressStreet());
	  testObject.put("City", event.getAddressCity());
	  testObject.put("Postalcode", event.getAddressPostalCode());
	  testObject.put("Date", event.getEventDate());
	  testObject.put("Time", event.getEventTime());
	  testObject.put("Description", event.getEventDescription());
	  testObject.put("NumTicketHs", event.getNumberTicketHolders());
	  testObject.put("THSNames", event.getTicketHoldersStringNames());
	  testObject.put("THSPhones", event.getTicketHoldersStringPhones());
	  testObject.put("THSEmails", event.getTicketHoldersStringEmail());
	  testObject.put("Amount", event.getAmountSpent());
	  testObject.saveInBackground();
  }
}
