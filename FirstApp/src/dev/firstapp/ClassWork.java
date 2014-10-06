package dev.firstapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class ClassWork extends Activity{
	
	private ClassWorkView class_work_view; 
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		class_work_view = new ClassWorkView(this);
		setContentView(class_work_view);
	}
	
	public boolean onTouchEvent(MotionEvent event){
		
		if(event.getAction() != MotionEvent.ACTION_DOWN)
			return super.onTouchEvent(event);
		class_work_view.updatePosition(event.getX(), event.getY());
		
		return true;
	}
	
}
