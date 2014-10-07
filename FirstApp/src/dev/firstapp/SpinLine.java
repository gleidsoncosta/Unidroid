package dev.firstapp;

import android.R.color;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

public class SpinLine{
	
	public Point initial_point;
	public Point final_point;
	
	public SpinLine(){
		
		initial_point = new Point(500, 500);
		final_point = new Point(200, 200);
	}
	
	public SpinLine(int x0, int y0, int x1, int y1){
		initial_point = new Point(x0, y0);
		final_point = new Point(x1, y1);
	}
	
	public void toDraw(Canvas canvas){
		Paint paint = new Paint();
		paint.setColor(Color.BLUE);
		canvas.drawLine(initial_point.x, initial_point.y, final_point.x, final_point.y, paint);
	}
	
	public void updateInitialPosition(int x, int y){
		initial_point = new Point(x, y);
	}
	
	public void updateFinalPosition(int x, int y){
		final_point = new Point(x, y);
	}
}
