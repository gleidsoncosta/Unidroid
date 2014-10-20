package dev.firstapp.Activities;

import dev.firstapp.View.ClassWorkView;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class ClassWork extends Activity{
	
	private ClassWorkView class_work_view;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		class_work_view = new ClassWorkView(this);
		setContentView(class_work_view);	
	}

}
