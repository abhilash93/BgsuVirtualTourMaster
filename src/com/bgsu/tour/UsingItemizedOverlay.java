package com.bgsu.tour;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;


import com.google.android.maps.ItemizedOverlay;

import com.google.android.maps.OverlayItem;

public class UsingItemizedOverlay extends ItemizedOverlay<OverlayItem>
{
	
	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	Context mContext;
	
	public UsingItemizedOverlay(Drawable marker, Context context) 
	{
		super(boundCenterBottom(marker));
		mContext=context;
		// TODO Auto-generated constructor stub
		 
		populate();
	}

	public void addOverlay(OverlayItem overlay) 
	{
	    mOverlays.add(overlay);
	    populate();
	}
	@Override
	protected boolean onTap(int index) {
	  OverlayItem item = mOverlays.get(index);
	  AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
	  dialog.setTitle(item.getTitle());
	  dialog.setMessage(item.getSnippet());
	  dialog.show();
	  return true;
	}
 public void removeOverlay(OverlayItem overlay) 
 {
	        mOverlays.remove(overlay);
	        populate();
  }


	    public void clear() {
	        mOverlays.clear();
	        populate();
	    }
	@Override
	protected OverlayItem createItem(int i) {
		// TODO Auto-generated method stub
		return mOverlays.get(i);
	}
	

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return mOverlays.size();
	}

}
