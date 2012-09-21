package com.bgsu.tour;


import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class DisplayContact extends ListActivity{
		
	String dept;
	String[] pass;
	String[] csContact={"Computer Science Department","Chair: Dr. Walter Maner","4193722337","dgraha@bgsu.edu","http://www.cs.bgsu.edu"};
	String[] geoContact={"Geology Department","Chair: Sheila J. Roberts","4193722886","geology@bgsu.edu","http://www.bgsu.edu/departments/geology/index.html"};
	String[] ecoContact={"Department of Economics","Chair: Dr. Mary Ellen Benedict","419-372-2646","mbenedi@bgsu.edu","http://www.business.bgsu.edu/econ/index.html"};
	String[] gradCollegeContact={"Graduate College","Dean: Dr. Michael Ogawa","4193722791","gradcol@bgsu.edu","http://www.bgsu.edu/gradcoll/page27074.html"};
	String[] cipContact={"Center for International Programs","Director: Paul Hofmann","4193722247","cip@bgsu.edu","http://www.bgsu.edu/international/page91422.html"};
	String[] mathsContact={"Mathematics and Statistics Department","Chair: Kit Chan","4198192636","math-stat@bgsu.edu","http://www.bgsu.edu/departments/math/grad/index.html"};
	String[] artContact={"Art Department","Director: Dr. Katerina Rüedi Ray","4193725529","lmolnar@bgsu.edu","http://www.art.bgsu.edu"};
	
	
	int menuItem_deptName =0;
	int menuItem_deptHead=1;
    int menuItem_deptPhone = 2;
    int menuItem_deptEmail = 3;
    int menuItem_deptWebsite = 4;
	int position1;
   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
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
		setContentView(R.layout.contactsdisplay);
		Bundle extras=getIntent().getExtras();
        if(extras!=null)
        {
        	position1=extras.getInt("index_of_department");
        }
		if(position1==0)
		{
			pass=artContact;
		}
		else if(position1==1)
		{
			pass=cipContact;
		}
		else if(position1==2)
		{
			pass=csContact;
		}
		else if(position1==3)
		{
			pass=ecoContact;
		}
		else if(position1==4)
		{
			pass = geoContact;
		}		
		else if(position1==5)
		{
			pass=gradCollegeContact;
		}
		else if(position1==6)
		{
			pass=mathsContact;
		}
		
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,pass));	
		
	}
	
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		//super.onListItemClick(l, v, position, id);
		String itemSelected=(String) l.getItemAtPosition(position);
		if(position==menuItem_deptPhone)
		{
			try{
			//setDefaultKeyMode(DEFAULT_KEYS_DIALER);
			Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+itemSelected));
            startActivity(intent);
			}
			catch(Exception e)
			{
				//
			}
		}
		if(position==menuItem_deptWebsite)
		{
			try{
			//setDefaultKeyMode(DEFAULT_KEYS_DIALER);
				Uri uri = Uri.parse(itemSelected);
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(intent);
			}
			catch(Exception e)
			{
				//
			}
		}
		if(position==menuItem_deptEmail)
		{
			String recipient=itemSelected;
			try{
				Intent intent = new Intent(android.content.Intent.ACTION_SEND);	
				intent.setType("plain/text");
		        intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{recipient});
		        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Email to Department");
		        intent.putExtra(android.content.Intent.EXTRA_TEXT, "Email is sent via BGSU Virtual Tour android application.");
		        
		        startActivity(Intent.createChooser(intent,"Send email..."));
			}
			catch(Exception e)
			{
				//
			}
		}
	}

	

}
