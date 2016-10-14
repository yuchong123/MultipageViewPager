package org.yuc.multipageviewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class ImagePagerAdapter extends PagerAdapter{

	private List<Integer> ids;
	private Context context;
	private LayoutInflater inflater;
	
	public ImagePagerAdapter(Context context,List<Integer> url){
		this.ids=url;
		this.context=context;
		inflater = LayoutInflater.from(context);
		
	}
	
	@Override
	public int getCount() {
		return ids.size();
	}
	
    @Override  
    public boolean isViewFromObject(View arg0, Object arg1) {  
        return arg0 == arg1;  
    }  
  
    @Override  
    public void destroyItem(ViewGroup container, int position, Object object) {  
        container.removeView((View) object);  
    }

    @Override  
    public Object instantiateItem(ViewGroup container, int position) {
    	
		ImageView imgview = new ImageView(context);
		imgview.setImageResource(ids.get(position));
		imgview.setScaleType(ImageView.ScaleType.CENTER_CROP);
    	container.addView(imgview);
    	return imgview;
    }  
	
}
