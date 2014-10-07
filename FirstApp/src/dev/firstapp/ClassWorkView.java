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
	int line_combo;
	private ArrayList<Circle> circle;  
	
	public ClassWorkView(Context context){
		super(context);
		
		spin_line = new SpinLine();
		circle= new ArrayList<Circle>();
		int line_combo = 0;
		
	}
	
	public void onDraw(Canvas canvas){
		
		Paint background = new Paint();
		background.setColor(getResources().getColor(R.color.white));
		canvas.drawRect(0, 0, getWidth(), getHeight(),	background);
		
		spin_line.toDraw(canvas);
		for(int i=0; i<circle.size(); i++){
			circle.get(i).toDraw(canvas);
		}
		
	}
	
	public boolean onTouchEvent(MotionEvent event){
		
		if(event.getAction() == MotionEvent.ACTION_DOWN){
			//if((line_combo++)%2==0){
				//spin_line.updateInitialPosition((int)event.getX(), (int)event.getY());
			//}else{
				//spin_line.updateFinalPosition((int)event.getX(), (int)event.getY());
			Circle new_circle = new Circle(event.getX(), event.getY());
			circle.add(new_circle);
			
		}else{
			return super.onTouchEvent(event);
		}
			
		
		invalidate();
		
		return true;
	}

}
