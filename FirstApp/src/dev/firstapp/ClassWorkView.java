package dev.firstapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class ClassWorkView extends View{
	
	private SpinLine spin_line;
	int line_combo;
	private Circle circle;
	
	public ClassWorkView(Context context){
		super(context);
		
		spin_line = new SpinLine();
		circle = new Circle();
		int line_combo = 0;
		
	}
	
	public void onDraw(Canvas canvas){
		
		Paint background = new Paint();
		background.setColor(getResources().getColor(R.color.white));
		canvas.drawRect(0, 0, getWidth(), getHeight(),	background);
		
		spin_line.toDraw(canvas);
		circle.toDraw(canvas);
	}
	
	public boolean onTouchEvent(MotionEvent event){
		
		if(event.getAction() == MotionEvent.ACTION_DOWN){
			//if((line_combo++)%2==0){
				//spin_line.updateInitialPosition((int)event.getX(), (int)event.getY());
			//}else{
				//spin_line.updateFinalPosition((int)event.getX(), (int)event.getY());
			circle.updatePosition(event.getX(), event.getY());
			
		}else{
			return super.onTouchEvent(event);
		}
			
		
		invalidate();
		
		return true;
	}

}
