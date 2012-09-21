package com.bgsu.tour;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.MediaController;
import android.widget.VideoView;

public class ToPlayVideoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	int position;
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
		//code to play video from server
    	this.setContentView(R.layout.videoplay);
    	//take value of position from previous activity
		Bundle extras=getIntent().getExtras();
		position=extras.getInt("index_of_department");
		
		VideoView videoView=(VideoView)this.findViewById(R.id.videoView1);
        MediaController mc=new MediaController(this);
        videoView.setMediaController(mc);
        position= position+1;
        videoView.setVideoURI(Uri.parse("http://voyager.cs.bgsu.edu/cpotdar/videos/video"+position+".mp4"));
        videoView.requestFocus();
        videoView.setFocusable(true);
        videoView.start();
    	
        super.onCreate(savedInstanceState);
        
        /*VideoView v=(VideoView)this.findViewById(R.id.videoView1);
        MediaController mc=new MediaController(this);
        v.setMediaController(mc);
        v.setVideoURI(Uri.parse("http://voyager.cs.bgsu.edu/cpotdar/videos/1.mp4"));
        v.requestFocus();
       v.start();*/
        
    }
}