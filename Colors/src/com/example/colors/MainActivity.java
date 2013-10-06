package com.example.colors;

import java.util.Random;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

@SuppressLint("ResourceAsColor") public class MainActivity extends Activity  implements OnTouchListener{

	int[] mRainbowColors;
	int mPreviousColor = 0;
	int i = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mRainbowColors = getResources().getIntArray(R.array.rainbow);
		chageColor();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClickChangeColor(View v){
		chageColor();
	}
	

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		chageColor();
		return true;
	}
	
	private void chageColor(){
		Random r = new Random();
		i = r.nextInt(6)+1;
		
		Vibrator vb = (Vibrator)   getSystemService(Context.VIBRATOR_SERVICE);
        vb.vibrate(100);
        while(i == mPreviousColor){
        	i = r.nextInt(6)+1;
        }
		
		findViewById(R.id.background).setBackgroundColor(mRainbowColors[i]);
		
		mPreviousColor = i;
	}
	
}
