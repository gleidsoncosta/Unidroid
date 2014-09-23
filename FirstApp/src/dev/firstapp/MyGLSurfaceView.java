package dev.firstapp;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class MyGLSurfaceView extends GLSurfaceView{
	
	public MyGLSurfaceView(Context context){
		super(context);
		
		setRenderer(new MyRenderer());
		setEGLContextClientVersion(2);
		setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
	}

}
