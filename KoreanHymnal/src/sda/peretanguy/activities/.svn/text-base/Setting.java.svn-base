package sda.peretanguy.activities;

import sda.peretanguy.R;
import sda.peretanguy.dialog.DlgDownload;
import sda.peretanguy.preference.HymnalPreference;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.ToggleButton;

public class Setting extends Activity {
	
	private TableLayout btnLandscape;
	private LinearLayout btnDownload, btnTwitter;
	private ToggleButton chkLandscape;
	private HymnalPreference preference;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        
        preference = HymnalPreference.getInstance();
        
        chkLandscape = (ToggleButton)findViewById(R.id.chkLandscape);
        btnLandscape = (TableLayout)findViewById(R.id.btnLandscape);
        btnLandscape.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(chkLandscape.isChecked()) {
					chkLandscape.setChecked(false);
					preference.setLandscape(false);
				}
				else {
					chkLandscape.setChecked(true);
					preference.setLandscape(true);
				}
			}
		});
        
        btnDownload = (LinearLayout)findViewById(R.id.btnDownload);
        btnDownload.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				new AlertDialog.Builder(Setting.this)
				.setIcon(android.R.drawable.ic_dialog_alert)
				.setTitle("알림")
				.setMessage("무제한 요금제가 아닌 경우 Wifi 상태에서 다운로드 하시길 권장합니다.")
				.setPositiveButton("다운로드", new DialogInterface.OnClickListener() {
				    public void onClick( DialogInterface dialog, int which) {
				    	startActivity(new Intent(Setting.this,DlgDownload.class));
						overridePendingTransition(android.R.anim.slide_in_left,0);
				    }
				})
				.setNegativeButton("취소", null)
				.show();
			}
		});
        
        btnTwitter = (LinearLayout)findViewById(R.id.btnTwitter);
        btnTwitter.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(Intent.ACTION_VIEW); 
				Uri u = Uri.parse("https://mobile.twitter.com/#!/PereTanguy"); 
				i.setData(u); 
				startActivity(i);
		
			}
		});
        
        setCheckBoxValues();
    }

	private void setCheckBoxValues() {
		chkLandscape.setChecked(preference.getLandscape());
	}    
}