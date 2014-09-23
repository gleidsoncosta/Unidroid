package dev.firstapp;

import dev.firstapp.About;
import android.app.Activity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import android.view.MenuInflater;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;


public class MainActivity extends Activity implements OnClickListener{
	
	private static final String TAG = "Sudoku" ;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
     // Set up click listeners for all the buttons
        View continueButton = findViewById(R.id.continue_button);
        continueButton.setOnClickListener(this);
        
        View newButton = findViewById(R.id.new_button);
        newButton.setOnClickListener(this);
        
        View aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(this);
        
        View cWorkButton = findViewById(R.id.class_work);
        cWorkButton.setOnClickListener(this);
        
        View exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);
    }
    
    //starts a new action when the buttons configured were clicked
    public void onClick(View v) {
    	switch (v.getId()) {
    	case R.id.new_button:
    		openNewGameDialog();
    		break;
    	case R.id.about_button:
	    	Intent i = new Intent(this, About.class);
	    	startActivity(i);
    		break;
    	case R.id.class_work:
    		Intent a = new Intent(this, OpenGLES20Activity.class);
    		startActivity(a);
    		break;
    	case R.id.exit_button:
        	finish();
        	break;
    	}
    }
    
    //open the list of difficulty of the game
    private void openNewGameDialog() {
    	new AlertDialog.Builder(this)
    	.setTitle(R.string.new_game_title)
    	.setItems(R.array.difficulty, new DialogInterface.OnClickListener() {
    		public void onClick(DialogInterface dialoginterface, int i) {
    			startGame(i);
    		}
    	})
    	.show();
    }
    
    //start the game after clicked
    private void startGame(int i) {
    	Log.d(TAG, "clicked on " + i);
    	Intent intent = new Intent(MainActivity.this, Game.class);
    	intent.putExtra(Game.KEY_DIFFICULTY, i);
    	startActivity(intent);
    	// Start game here...
    }
    
    //shows options on activity bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
    }
    
    //start an action when any option was clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    	case R.id.settings:
    	startActivity(new Intent(this, Prefs.class));
    	return true;
    	// More items go here (if any) ...
    }
    return false;
    }
}
