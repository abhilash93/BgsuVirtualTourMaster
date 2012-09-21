package com.bgsu.tour;

import java.util.Arrays;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ImageListActivity extends ListActivity  {
	 
     String dept;    
	  
    int i=0; 
    String[] deptNames={"Computer Science","Geology","Union","Biology","Maths","Arts","Music"};

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
        setContentView(R.layout.picturelist);
        Arrays.sort(deptNames);
       // gestureDetector = new GestureDetector(this);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,deptNames));      
    }
    public void onListItemClick(ListView parent, View v,int position, long id) 
    	    {   
    	//      dept=deptNames[position];
    	      Intent photosIntent =new Intent(this,ImageShowActivity.class);
    	      photosIntent.putExtra("index_of_department", position);
    		  startActivity(photosIntent);
    	      
    	    }
  
}