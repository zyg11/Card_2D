package com.example.card2d;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	private ImageView imageA,imageB;
	private ScaleAnimation sato0=new ScaleAnimation(1, 0, 1, 1, 
			Animation.RELATIVE_TO_PARENT, 0.5f,
			Animation.RELATIVE_TO_PARENT,0.5f);
	private ScaleAnimation sato1=new ScaleAnimation(0, 1, 1, 1, 
			Animation.RELATIVE_TO_PARENT, 0.5f,
			Animation.RELATIVE_TO_PARENT,0.5f);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initview();
		findViewById(R.id.root).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if (imageA.getVisibility()==View.VISIBLE) {
					imageA.startAnimation(sato0);
				}else {
					imageB.startAnimation(sato0);
				}
				
				
			}
		});;
	}
	private void showImageA(){
		imageA.setVisibility(View.VISIBLE);
		imageB.setVisibility(View.INVISIBLE);
	}
	private void showImageB(){
		imageB.setVisibility(View.VISIBLE);
		imageA.setVisibility(View.INVISIBLE);
	}
	private void initview(){
		imageA=(ImageView) findViewById(R.id.ivA);
		imageB=(ImageView) findViewById(R.id.ivB);
		showImageA();
		sato0.setDuration(500);
		sato1.setDuration(500);
		sato0.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				if (imageA.getVisibility()==View.VISIBLE) {
					imageA.setAnimation(null);
					showImageB();
					imageB.startAnimation(sato1);
				}else {
					imageB.setAnimation(null);
					showImageA();
					imageA.startAnimation(sato1);
				}
				
			}
		});
	}
	

}
