package dev.firstapp.Primitives;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import dev.firstapp.Interface.ElementObject;

public class Arc implements ElementObject{
	
	RectF rectf;
	float x, y, w, h;
	float initial_angle;
	float final_angle;
	
	public Arc(float x, float y, float w, float h, float i_angle, float f_angle){
		
		rectf = new RectF(x, y, w+x, h+y);
		
		initial_angle = i_angle;
		final_angle = f_angle;
	}
	
	@Override
	public void toUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void toControl(MotionEvent event) {
		// TODO Auto-generated method stub
		/*switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			x++;
			y++;
			w++;
			h++;
			break;
		default:
		}*/
	}

	@Override
	public void toDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		
		Paint color = new Paint();
		color.setColor(Color.RED);
		color.setStyle(Paint.Style.STROKE); 
		color.setStrokeWidth(5);
		
		canvas.drawArc (rectf, initial_angle, final_angle, false, color);
	}

}
