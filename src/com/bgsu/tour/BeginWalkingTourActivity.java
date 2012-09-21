package com.bgsu.tour;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.View.OnClickListener;

public class BeginWalkingTourActivity extends Activity implements OnClickListener{
    
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	//setting the background color of title
    	View titleView = getWindow().findViewById(android.R.id.title);
    	if (titleView != null) {
    	  ViewParent parent = titleView.getParent();
    	  if (parent != null && (parent instanceof View)) {
    	    View parentView = (View)parent;
    	    parentView.setBackgroundColor(Color.rgb(156,166,57));
    	  }
    	}
    	//setting the title of activity
    	setTitle("Bowling Green State University");
    	setTitleColor(Color.rgb(240,103,36));
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.begintour);
        View btn_SelfTour = findViewById(R.id.button1);
        btn_SelfTour.setOnClickListener(this); 
        
        View btn_DefaultTour = findViewById(R.id.button2);
        btn_DefaultTour.setOnClickListener(this); 
    }
      
    @Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
    	switch(v.getId()){
		case R.id.button1:
			Log.i("Button","Button 1 pushed");
			Intent selfTourIntent =new Intent(this,BGSUVTour.class);
			startActivity(selfTourIntent);
		
		case R.id.button2:
			Log.i("Button","Button 1 pushed");
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://voyager.cs.bgsu.edu/cpotdar/walkingtour/BGSU_Campus_Tour.mp4")));			
	}

    }
    
}


