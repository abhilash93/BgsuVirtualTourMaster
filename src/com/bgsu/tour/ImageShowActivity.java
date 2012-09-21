package com.bgsu.tour;



import java.io.InputStream;
import java.net.URL;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.GestureDetector.OnGestureListener;
import android.widget.ImageView;
import android.widget.TextView;


public class ImageShowActivity extends Activity implements OnGestureListener {
    private GestureDetector gestureDetector;
    private static final int MAJOR_MOVE = 60;
	   
    int i=0; 
    int position;
    String deptName;
     
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
        
        Bundle extras=getIntent().getExtras();
		position=extras.getInt("index_of_department");
		if(position==0)
		{
			deptName="Arts";
		}
		else if(position==1)
		{
			deptName="Biology";
		}
		else if(position==2)
		{
			deptName="ComputerScience";
		}
		else if(position==3)
		{
			deptName="Geology";
		}
		else if(position==4)
		{
			deptName="Maths";
		}
		else if(position==5)
		{
			deptName="Music";
		}
		else if(position==6)
		{
			deptName="Union";
		}
		
        
        /*Bundle extras=getIntent().getExtras();
        if(extras!=null)
        {
        	deptName=extras.getString("new_variable_name");
        }*/
        setContentView(R.layout.pictureshow);
       gestureDetector = new GestureDetector(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
 
    @Override
    public boolean onDown(MotionEvent e) {
        // Do something
        return false;
    }
 
    @Override
   public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
            float velocityY) {
       // Do something
   	

   	 
   	 
   	 int dx = (int) (e2.getX() - e1.getX());         // don't accept the fling if it's too short         // as it may conflict with a button push       
   	 if (Math.abs(dx) > MAJOR_MOVE && Math.abs(velocityX) > Math.abs(velocityY))
   	 {           
   		 if (velocityX > 0) 
   	    {	
   			 i=i-1;
   			 if(i==0 || i<0)
   				 i=4;
   			 
   			 ImageView deptImage=new ImageView(this);
   			 Drawable drawable = LoadImageFromWebOperations("http://" + "voyager.cs.bgsu.edu/cpotdar/images/"+deptName+"/image"+i+".jpg");
		     deptImage.setImageDrawable(drawable);
		     setContentView(deptImage);
   	    }
   	  else 
   	   {   
   		  i=i+1;
   		  if(i>4)
   		  {
		         i=1;
   		  }
   		  ImageView img=new ImageView(this);
		  Drawable drawable = LoadImageFromWebOperations("http://" + "voyager.cs.bgsu.edu/cpotdar/images/"+deptName+"/image"+i+".jpg");
          img.setImageDrawable(drawable);
		  setContentView(img);               
   		}            
   		return true;
   		   
   	}
   	else
   	{  
   		 return false;     
   	 } 
   	
 }
 
    @Override
    public void onLongPress(MotionEvent e) { 
        // Do something
   	  TextView  HelloWorldTextView= new TextView(this);
         //HelloWorldTextView.setText("Computer Science");
         
         setContentView(HelloWorldTextView);
    }
 
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
            float distanceY) {
        // Do something
        return false;
    }

  @Override
    public void onShowPress(MotionEvent e) { 
//Do something
}
   @Override
   public boolean onSingleTapUp(MotionEvent e) { 
       // Do something 
       return false;
  }
   private Drawable LoadImageFromWebOperations(String url){
		try{
			InputStream is = (InputStream) new URL(url).getContent();
			Drawable d = Drawable.createFromStream(is, "src name");
			return d;
		}catch (Exception e) {
			System.out.println("Exc="+e);
			return null;
		}
	}
}

