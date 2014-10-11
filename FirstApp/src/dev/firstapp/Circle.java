package dev.firstapp;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.util.Log;
import android.view.MotionEvent;

public class Circle implements ElementObject{
	
	public float center_x;
	public float center_y;
	public float ray;
	
	private float initial_x;
	private float initial_y;
	private float move_delay = 5; //to don't take wrong movements
	private boolean isOnClick;
	
	private boolean isControlled;
	
	private boolean isSelected;
	private int combo_selected; //0-not selected 1-action over selection
	
	public Circle(){
		this.center_x = 100;
		this.center_y = 100;
		this.ray = 100;
		this.isControlled = true;
		this.isSelected = false;
		this.combo_selected = 0;
	}
	
	public Circle(float x, float y){
		this.center_x = x;
		this.center_y = y;
		this.ray = 100;
		this.isControlled = true;
		this.isSelected = false;
		this.combo_selected = 0;
	}
	
	public void toDraw(Canvas canvas){
		Path circle = new Path();
		circle.addCircle(center_x, center_y, ray, Direction.CW);
		
		Paint fillCircle = new Paint();
		fillCircle.setColor(Color.BLUE);
		fillCircle.setStyle(Paint.Style.FILL);
		canvas.drawPath(circle, fillCircle);
	
		if(isSelected){
			fillCircle.setColor(Color.YELLOW);
			fillCircle.setStrokeWidth(5);
			fillCircle.setStyle(Paint.Style.STROKE);
			canvas.drawPath(circle, fillCircle);
		}
	}
	
	public void toControl(MotionEvent event){
		if(!isControlled) return;
		if(!isSelected) return;
		
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			initial_x = event.getX();
			initial_y = event.getY();
			isOnClick = true;
			break;
		case MotionEvent.ACTION_CANCEL:
			Log.d("move", "cancel");
		case MotionEvent.ACTION_MOVE:
			float direction_x = Math.abs(initial_x - event.getX());
			float direction_y = Math.abs(initial_y - event.getY());
			if(isOnClick && (direction_x > move_delay)||(direction_y) > move_delay){
				updatePosition(event.getX(), event.getY());
				isOnClick = false;
				break;
			}
		default:
		}
	}
	
	public void updatePosition(float x, float y){
		center_x =x;
		center_y =y;
	}
	
	public void setControlPermission(boolean activate){
		isControlled = activate;
	}
	
	public void setSelection(){
		isSelected = !isSelected;
	}
	
	public boolean getSelection(){
		return isSelected;
	}
	
	public boolean onCollider(float x, float y){
		if(Math.pow((x - center_x), 2) + Math.pow((y - center_y), 2) < Math.pow(ray, 2)){
			return true;
		}
		return false;
	}
	
}
