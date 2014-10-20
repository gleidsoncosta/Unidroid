package dev.firstapp.Primitives;

import dev.firstapp.Interface.ElementObject;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.view.MotionEvent;

public class Rect implements ElementObject{

	private RectF rect;
	
	public Rect(){
		rect = new RectF(300, 200, 40+300, 50+200);
	}
	
	public Rect(int x, int y, int w, int h){
		rect = new RectF(x, y, w+x, h+y);
	}
	
	public void toUpdate(){
		
	}
	
	public void toControl(MotionEvent event) {
		
	}
	
	public void toDraw(Canvas canvas) {
		Paint color = new Paint();
		color.setColor(Color.RED);
		
		canvas.drawRect(rect, color);
		
	}

}
