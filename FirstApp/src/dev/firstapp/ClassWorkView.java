package dev.firstapp;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class ClassWorkView extends View{
	
	private SpinLine spin_line;
	private int line_combo;  
	private Circle circle;
	
	
	
	public ClassWorkView(Context context){
		super(context);
		
		spin_line = new SpinLine();
		int line_combo = 0;
		circle = new Circle();
	}
	
	public void onDraw(Canvas canvas){
		
		Paint background = new Paint();
		background.setColor(getResources().getColor(R.color.white));
		canvas.drawRect(0, 0, getWidth(), getHeight(),	background);
		
		spin_line.toDraw(canvas);
		circle.toDraw(canvas);

	}
	
	public boolean onTouchEvent(MotionEvent event){
		
		switch(event.getAction()){
			case MotionEvent.ACTION_DOWN:
				if(circle.onCollider(event.getX(), event.getY())){
					circle.setSelection();
				}
				break;
		}
		
		circle.toControl(event);
			
		invalidate();
		return true;
	}
	
	

}
