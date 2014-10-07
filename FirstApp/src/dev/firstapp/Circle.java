package dev.firstapp;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;

public class Circle {
	
	public float center_x;
	public float center_y;
	public float ray;
	
	public Circle(){
		
		this.center_x = 100;
		this.center_y = 100;
		this.ray = 100;
		
	}
	
	public Circle(float x, float y){
		
		this.center_x = x;
		this.center_y = y;
		this.ray = 100;
		
	}
	
	public void toDraw(Canvas canvas){
		Path circle = new Path();
		circle.addCircle(center_x, center_y, ray, Direction.CW);
		
		Paint fillCircle = new Paint();
		fillCircle.setColor(Color.BLUE);
		fillCircle.setStyle(Paint.Style.FILL);
		canvas.drawPath(circle, fillCircle);
	}
	
	public void updatePosition(float x, float y){
			
		if(center_x >= x){
			center_x--;
		}else{
			center_x++;
		}
		if(center_y >= y){
			center_y--;
		}else{
			center_y++;
		}
		//center_x =x;
		//center_y =y;
	}
}
