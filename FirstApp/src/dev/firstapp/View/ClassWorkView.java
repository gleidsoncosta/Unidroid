package dev.firstapp.View;

import java.util.ArrayList;
import java.util.List;

import dev.firstapp.R;
import dev.firstapp.Primitives.Arc;
import dev.firstapp.Primitives.Circle;
import dev.firstapp.Primitives.Rect;
import dev.firstapp.Primitives.Line;

import android.R.color;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class ClassWorkView extends View{
	
	private Handler handler;
	
	private Line line;
	private Circle circle;
	private Rect rect;
	private Arc arc;
	
	private Circle menu_circle = new Circle(100, 950);
	private Line menu_line = new Line(200, 950, 220, 1000);
	private Rect menu_rect = new Rect(300, 950, 30, 30);
	private Arc menu_arc = new Arc(400, 950, 60, 60, 0, 180);
	private int select_menu=0;
	
	public ClassWorkView(Context context){
		super(context);
		circle = new Circle();
		arc = new Arc(200, 200, 60, 100, 0, 180);
		rect = new Rect();
		line = new Line();
		handler = new Handler();
		handler.postDelayed(runnable, 33);
	}
	
	private Runnable runnable = new Runnable() {
		   
		public void run() {
		      circle.toUpdate();
		      handler.postDelayed(this, 33);
		      invalidate();
		}
		
	};
	
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
	
	public void onDraw(Canvas canvas){
		
		Paint background = new Paint();
		background.setColor(getResources().getColor(R.color.white));
		canvas.drawRect(0, 0, getWidth(), getHeight(),	background);
		
		circle.toDraw(canvas);
		arc.toDraw(canvas);
		rect.toDraw(canvas);
		line.toDraw(canvas);
		
		menu(canvas);
	
	}
	
	public void menu(Canvas canvas){
		Paint background = new Paint();
		background.setColor(getResources().getColor(R.color.black));
		canvas.drawRect(0, 900, getWidth(), getHeight(), background);
		
		menu_circle.toDraw(canvas);
		menu_line.toDraw(canvas);
		menu_rect.toDraw(canvas);
		menu_arc.toDraw(canvas);
	}
	
}