package dev.firstapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.View;

public class ClassWorkView extends View{
	
	private float center_x;
	private float center_y;
	private float ray;
	
	public ClassWorkView(Context context){
		super(context);
		
		this.center_x = 100;
		this.center_y = 100;
		this.ray = 100;
		Log.d("circle", this.center_x + "  " + this.center_y + "  " + this.ray);
	}
	
	public ClassWorkView(Context context, float x, float y, float r){
		super(context);
		
		center_x = x;
		center_y = y;
		ray = r;
		
	}
	
	public void onDraw(Canvas canvas){
		Paint background = new Paint();
		background.setColor(getResources().getColor(R.color.white));
		canvas.drawRect(0, 0, getWidth(), getHeight(),	background);
		
		Path circle = new Path();
		circle.addCircle(center_x, center_y, ray, Direction.CW);
		
		Paint fillCircle = new Paint();
		fillCircle.setColor(getResources().getColor(R.color.magenta));
		fillCircle.setStyle(Paint.Style.FILL);
		canvas.drawPath(circle, fillCircle);
	}
	
	public void updatePosition(float x, float y){
		
		/*if(center_x >= x){
			center_x--;
		}else{
			center_x++;
		}
		if(center_y >= y){
			center_y--;
		}else{
			center_y++;
		}*/
		center_x =x;
		center_y =y;
		invalidate();
	}
}
