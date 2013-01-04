package sda.peretanguy.activities;

import sda.peretanguy.R;
import sda.peretanguy.preference.HymnalPreference;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Intro extends Activity {
	    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        HymnalPreference preference = HymnalPreference.getInstance();
        preference.setContext(getApplicationContext());
        
        if(!preference.getNotFirstRun()){
        	preference.setLandscape(true);
        	preference.setNotFirstRun(true);
        }
        
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable(){
			public void run() {
				gotoNextActivity();
			}
        }, 3000);
    }
    
    public void gotoNextActivity(){
    	startActivity(new Intent(Intro.this,SearchHymnal.class));
    	finish();
    }
}