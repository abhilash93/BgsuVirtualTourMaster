package com.bgsu.tour;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;


//import com.bgsu.vtour.BGSUVTour;

public class BGSUVirtualTourActivity extends Activity implements OnClickListener, OnInitListener{
    /** Called when the activity is first created. */
	TextToSpeech mTts;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
   	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
      
        //---Setting text on top of the app-----
        
        View titleView = getWindow().findViewById(android.R.id.title);
    	if (titleView != null) 
    	{
    	  ViewParent parent = titleView.getParent();
    	  if (parent != null && (parent instanceof View)) 
    	  {
    	    View parentView = (View)parent;
    	    parentView.setBackgroundColor(Color.rgb(156,166,57));
    	  }
    	}
    	//setting the title of activity
    	setTitle("Bowling Green State University");
    	setTitleColor(Color.rgb(240,103,36));
       //------end of title--------
    	
    	 mTts = new TextToSpeech(this, this  );
        View walkingTour = findViewById(R.id.button1);
        walkingTour.setOnClickListener(this);
        
        View mapDisplay =findViewById(R.id.button2);
        mapDisplay.setOnClickListener(this);
        
        View PhotoDisplay =findViewById(R.id.button3);
        PhotoDisplay.setOnClickListener(this);
        
        View VideoDisplay =findViewById(R.id.button4);
        VideoDisplay.setOnClickListener(this);
        
        View contactDisplay =findViewById(R.id.button5);
        contactDisplay.setOnClickListener(this);
    }
    private void sayHello() {
        // Select a random hello.
        //int helloLength = HELLOS.length;
        String hello = "Welcome to Bowling Green State University";
        mTts.speak(hello,TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
            null);
    }

    public void onInit(int status) {
    	sayHello();
    }
    public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.button1:
			Log.i("Button","Button 1 pushed");
			Intent wtIntent = new Intent(this,BGSUVTour.class);
			startActivity(wtIntent);
			break;
			
		case R.id.button2:
			Log.i("Button","Button 1 pushed");
			Intent mapIntent = new Intent(this,MapDisplayStart.class);
			startActivity(mapIntent);
			break;
			
		case R.id.button3:
			//Log.i("Button","Button 3 pushed");
			Intent pictureIntent = new Intent(this,ImageListActivity.class);
			startActivity(pictureIntent);
			break;
			
		case R.id.button4:
			//Log.i("Button","Button 4 pushed");
			Intent videoIntent = new Intent(this,VideoListActivity.class);
			startActivity(videoIntent);
			break;
		
		case R.id.button5:
			//Log.i("Contact Button","Button 5 pushed");
			Intent contactIntent = new Intent(this,ContactListActivity.class);
			startActivity(contactIntent);
			break;
		}
	}
    
    
}