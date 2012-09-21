
package com.bgsu.tour;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


import com.bgsu.tour.R;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.Toast;


public class BGSUVTour extends MapActivity implements LocationListener 
{

	//private static final String TAG = "LocationActivity";
	
	

	  LocationManager locationManager; 
	  private LocationListener locationListener;
	  Geocoder geocoder; 
	  
	  MapView map;  
	  MapController mapController;
	  UsingItemizedOverlay itemizedOverlay;
	  UsingItemizedOverlay itemizedOverlayPlace;

	  List<Overlay> mapOverlays;
	  Drawable drawable;
	  
	  @Override
	  public void onCreate(Bundle savedInstanceState) 
	  {
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
	    	
		  
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.vmap);
	    
	    
	     map = (MapView)this.findViewById(R.id.mvMain);
	     map.setBuiltInZoomControls(true);
	     map.setSatellite(true);
	   
	     Drawable drawable = this.getResources().getDrawable(R.drawable.point);
	     itemizedOverlay = new UsingItemizedOverlay(drawable,this);
	     
	     Drawable drawplace = this.getResources().getDrawable(R.drawable.in);
	     itemizedOverlayPlace = new UsingItemizedOverlay(drawplace,this);
	     
	     mapController = map.getController(); 
	     mapController.setZoom(18);
	     
	     
	     mapOverlays = map.getOverlays();
	    
	     locationManager = (LocationManager)this.getSystemService(LOCATION_SERVICE); 
	     locationListener = new GPSLocationListener();
	        
	     locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000,  5, locationListener);
	     geocoder = new Geocoder(this); 
	     mapOverlays.add(itemizedOverlay);
	     mapOverlays.add(itemizedOverlayPlace);

	    
	   //Hayes Hall Geopoints	  
	     GeoPoint hayesHallpt=new GeoPoint(41377904,-83639622);
	     OverlayItem overlayHayesHall = new OverlayItem(hayesHallpt, "Hayes Hall ", "Computer Science,Information Technology Services");
	     itemizedOverlayPlace.addOverlay(overlayHayesHall);
         mapController.animateTo(hayesHallpt);

	     //Student Union 
         GeoPoint stdUnionpt=new GeoPoint(41377433,-83640673);
	     OverlayItem overlayStdUnion = new OverlayItem(stdUnionpt, "Bowen-Thompson Student Union ", "University Bookstore, Falcon's Nest, Starbucks");
	     itemizedOverlayPlace.addOverlay(overlayStdUnion);
         
	     
         //Geology Building i.e. Overman Hall 
         GeoPoint overmanHallpt=new GeoPoint(41379229,-83639772);
	     OverlayItem overlayOvermanHall = new OverlayItem(overmanHallpt, "Overman Hall", "Geology Building, Chemistry Department");
	     itemizedOverlayPlace.addOverlay(overlayOvermanHall);
         
	     
	     //Maths Building 
         GeoPoint mathspt=new GeoPoint(41379216,-83640496);
	     OverlayItem overlayMaths = new OverlayItem(mathspt, "Maths Building", "Mathematics Department,BGSU Career Center");
	     itemizedOverlayPlace.addOverlay(overlayMaths);
	     
	     //Eppler Center Building 
         GeoPoint epplerCpt=new GeoPoint(41377502,-83638747);
	     OverlayItem overlayEpplerC = new OverlayItem(epplerCpt, "Eppler Center", "School of Human Movement, Sport, and Leisure Studies, Facility Graduate Assistant Office");
	     itemizedOverlayPlace.addOverlay(overlayEpplerC);
         /*
	     //Eppler North Building 
         GeoPoint epplerNpt=new GeoPoint(41377884,-83638737);
	     OverlayItem overlayEpplerN = new OverlayItem(epplerNpt, "Eppler North", "");
	     itemizedOverlayPlace.addOverlay(overlayEpplerN);
	     
	     //Eppler South Building 
         GeoPoint epplerSpt=new GeoPoint(41376918,-83638629);
	     OverlayItem overlayEpplerS = new OverlayItem(epplerSpt, "Eppler South", "Fencing Club");
	     itemizedOverlayPlace.addOverlay(overlayEpplerS);*/
	     
	     
	     //Business Administration Building 
         GeoPoint BApt=new GeoPoint(41376982,-83637825);
	     OverlayItem overlayBA = new OverlayItem(BApt, "Business Administration Building", "Business Administration Department");
	     itemizedOverlayPlace.addOverlay(overlayBA);
	     
	     //Business Administration Building 
         GeoPoint EBpt=new GeoPoint(41376532,-83638431);
	     OverlayItem overlayEB = new OverlayItem(EBpt, "Education Building", "College of Education and Human Developement");
	     itemizedOverlayPlace.addOverlay(overlayEB);
	     
	     //Moseley Hall 
         GeoPoint moseleyHpt=new GeoPoint(41376761,-83639622);
	     OverlayItem overlaymoseleyH = new OverlayItem(moseleyHpt, "Moseley Hall", "Study Skills Center, Writing Center, Maths & Stats Tutoring Center");
	     itemizedOverlayPlace.addOverlay(overlaymoseleyH);
	     
         //Administrative Building 
         GeoPoint adminBpt=new GeoPoint(41375835,-83642528);
	     OverlayItem overlayAdminB = new OverlayItem(adminBpt, "Adminstrative Building", "Bursar Office, Marketing Office of BGSU");
	     itemizedOverlayPlace.addOverlay(overlayAdminB);
	     mapOverlays.add(itemizedOverlay);
	     mapOverlays.add(itemizedOverlayPlace);
	     mapOverlays = map.getOverlays();
	  

	     
	     /*
	     GeoPoint point1=new GeoPoint(41377863,-83639688);
	     OverlayItem overlayitem2 = new OverlayItem(point1, "Hayes Hall ", "Computer Science,Information Technology Services");
	     itemizedOverlayPlace.addOverlay(overlayitem2);
         mapController.animateTo(point1);
*/
	     //map.postInvalidate();
	    
	    
	  }



	 private class GPSLocationListener implements LocationListener 
	    {
	        @Override
	        public void onLocationChanged(Location location) {
	            if (location != null)
	            {
	                GeoPoint point = new GeoPoint(
	                        (int) (location.getLatitude() * 1E6), 
	                        (int) (location.getLongitude() * 1E6));
	                
	               
	                                
	                mapController.animateTo(point);
	                mapController.setZoom(18);
	                
	                // add marker
	                String address1="";
	        	    try 
	        	    {
	        	      List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 10); //<10>
	        	      if (addresses.size() > 0) 
	        	        {
	        	            for (int index = 0; index < addresses.get(0).getMaxAddressLineIndex(); index++)
	        	            	address1 += addresses.get(0).getAddressLine(index) + " ";
	        	        }
	        	    
	        	      
	        
	          
	        	      
	        	    } 
	        	    catch (IOException e) 
	        	    {
	        	    
	        	    	Log.e("LocateMe", "Could not get Geocoder data", e);
	        	    }

	    			itemizedOverlay.clear();
	                String address = ConvertPointToLocation(point);
	                Toast.makeText(getBaseContext(), address, Toast.LENGTH_SHORT).show();
	                
	                
	                OverlayItem overlayitem2 = new OverlayItem(point,"Presnt Location" , address1);
	       	        itemizedOverlay.addOverlay(overlayitem2);
	                map.invalidate();
	            }
	        }
	        
	        
	        public String ConvertPointToLocation(GeoPoint point) 
	        {   
	        /* to get the address*/
	        	String address = "";
	            Geocoder geoCoder = new Geocoder(
	                    getBaseContext(), Locale.getDefault());
	            try {
	                List<Address> addresses = geoCoder.getFromLocation(
	                	point.getLatitudeE6()  / 1E6, 
	                    point.getLongitudeE6() / 1E6, 1);
		 
			        if (addresses.size() > 0) 
			        {
			            for (int index = 0; index < addresses.get(0).getMaxAddressLineIndex(); index++)
			            	address += addresses.get(0).getAddressLine(index) + " ";
			        }
	            }
	            catch (IOException e) {                
	                e.printStackTrace();
	            }   
	            
	            return address;
	        } 
	 

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

	

	  
	}
	 /*
	 @Override
	  protected void onResume() 
	  {
	    super.onResume();
	    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10, this); 
	    Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
	      
	      int latitude = (int)(location.getLatitude() * 1000000);
	      int longitude = (int)(location.getLongitude() * 1000000);

	      GeoPoint point = new GeoPoint(latitude,longitude);
	     OverlayItem overlayitem = new OverlayItem(point, "Hi resume", "I'm in Mexico City!");
	      itemizedOverlay.addOverlay(overlayitem);
	    
	      mapController.animateTo(point);
	    
	  }*/


	@Override
		protected boolean isRouteDisplayed() {
			// TODO Auto-generated method stub
			return false;
		}


	@Override
	public void onLocationChanged(Location arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}
}
	