package com.bgsu.tour;


import java.util.Arrays;
import android.content.Intent;
import android.graphics.Color;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ContactListActivity extends ListActivity {
   
		/** Called when the activity is first created. */
	
	String[] deptNames={"Computer Science","Geology","Economics","Graduate College","Center for International Programs","Maths","Arts"};
	
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
        setContentView(R.layout.contacts);
        Arrays.sort(deptNames);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,deptNames)); 
        
    }
    @Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
    	Intent  contactIntent = new Intent(this,DisplayContact.class);
	    contactIntent.putExtra("index_of_department", position);
		startActivity(contactIntent);
	}
  
	
	   
}



