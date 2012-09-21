package com.bgsu.tour;

import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;



public class MapDisplayStart extends MapActivity {
	 /** Called when the activity is first created. */
		MapView map;
		long start;//variables to handle overlay
		long stop;//create points from clicking to release of mouse on map overlay
		MyLocationOverlay compass;//to get location
		MapController controller;
		
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
	        setContentView(R.layout.mapstart);
	        
	         
	        map = (MapView)findViewById(R.id.mvMain);
	        map.setBuiltInZoomControls(true);
	        
	        map.setSatellite(true);
	        //map.setStreetView(true);
	        
	        //listener won't work properly bcoz map is very complicated so need another layer on map for working
	        
	        //instance of new class
	      Touchy t=new Touchy();
	        //list of overlays
	       List<Overlay> overlayList = map.getOverlays();
	        //add touchy instance to list of overlay
	       overlayList.add(t);
	        compass = new MyLocationOverlay(MapDisplayStart.this, map);
	        overlayList.add(compass);
	        controller = map.getController();//use to animated
	        
	        GeoPoint point = new GeoPoint(41377573,-83640874);
	        controller.animateTo(point);
	        controller.setZoom(18);
	    }
	    @Override
		protected void onPause() {
			// TODO Auto-generated method stub
			compass.disableCompass();
			super.onPause();
			
		}

		@Override
		protected void onResume() {
			// TODO Auto-generated method stub
			compass.enableCompass();
			super.onResume();
		}

		@Override
		protected boolean isRouteDisplayed() {
			// TODO Auto-generated method stub
			return false;
		}
		
//}

		//adding touchy class to add touch feature to map; handle all touch events like motion events
		class Touchy extends Overlay{
			public boolean onTouchEvent(MotionEvent e, MapView mv)
			{
				long start=0, stop=0;;
				if(e.getAction() == MotionEvent.ACTION_DOWN)
				{
					start=e.getEventTime();				
				}
				//judging velocity of how fast moves hands
				if(e.getAction() == MotionEvent.ACTION_UP)
				{
					stop = e.getEventTime();
				}
				if(stop - start > 6000)//1.5 sec in millisec
				{
					AlertDialog alert = new AlertDialog.Builder(MapDisplayStart.this).create();
					alert.setTitle("Pick an option");
					alert.setMessage("Select View of BGSU");
					alert.setButton("Toggle View",new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							if(map.isSatellite())
							{
								map.setSatellite(false);
								map.setStreetView(true);								
							}
							else
							{
								map.setStreetView(false);
								map.setSatellite(true);															
							}
						}
					} );
					alert.setButton2("Default View",new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://voyager.cs.bgsu.edu/cpotdar/mapview/campusmap.pdf"));
							//intent.setType("application/PDP");
							startActivity(intent);
						}
					} );
					
					alert.show();
					return true;
				}
				
					return false;
			}
}
}


