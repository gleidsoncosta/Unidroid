package dev.firstapp.Interface;

import android.graphics.Canvas;
import android.view.MotionEvent;

public interface ElementObject {
	
	public void toUpdate();
	
	public void toControl(MotionEvent event);
	
	public void toDraw(Canvas canvas);
	
}
