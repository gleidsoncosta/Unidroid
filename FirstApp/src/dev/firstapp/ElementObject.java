package dev.firstapp;

import android.graphics.Canvas;
import android.view.MotionEvent;

public interface ElementObject {
	
	public void toDraw(Canvas canvas);
	
	public void toControl(MotionEvent event);
	
}
