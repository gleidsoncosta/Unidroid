package dev.firstapp.Primitives;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import android.opengl.GLES20;

public class Triangle {
	
	private FloatBuffer vertexBuffer;
    
    //set number of coord per vertex and the position of each vertice in clockwise direction
	static final int COORDS_PER_VERTEX = 3;
	static float triangleCoords[] = {0.0f, 0.6f, 0.0f, -0.5f, 0.3f, 0.0f, 0.5f, 0.3f, 0.0f};
	
	//set color r g b a
	float color[] = {0.6f, 0.7f, 0.2f, 1.0f};
	
	public Triangle(){
		//initialize vertex byte buffer for shape coordinates
		//and allocate the space for each vertex * 4.
		ByteBuffer bb = ByteBuffer.allocateDirect(triangleCoords.length * 4);
		
		//use the device hardware`s native byte order
		bb.order(ByteOrder.nativeOrder());
		
		//create a floating point buffer from ByteBuffer
		vertexBuffer = bb.asFloatBuffer();
		//add the coordinates to the FloatBuffer
		vertexBuffer.put(triangleCoords);
		//set the buffer to read the first coordinate
		vertexBuffer.position(0);
	}
	
	
}
