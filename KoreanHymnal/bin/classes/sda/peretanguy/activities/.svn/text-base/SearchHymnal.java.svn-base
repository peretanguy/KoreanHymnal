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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchHymnal extends Activity{
	private EditText txtSearch;
	private Button btnOpen, btnDel, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
	private Button btnSetting;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_hymnal);
        
        txtSearch = (EditText)findViewById(R.id.txtSearch);
        btnOpen = (Button)findViewById(R.id.btnOpen);
        btnOpen.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				try {
					Intent intent;
					
					if(HymnalPreference.getInstance().getLandscape()){
						intent = new Intent(SearchHymnal.this,HymnalLandscape.class);						
					} else {
						intent = new Intent(SearchHymnal.this,HymnalAuto.class);
					}
					
					if(txtSearch.getText().length() < 1){
						Toast.makeText(SearchHymnal.this, "찬미가 장수를 입력해주세요.", Toast.LENGTH_SHORT).show();
					} else if(Integer.parseInt(txtSearch.getText().toString()) > 772){
						Toast.makeText(SearchHymnal.this, "찬미가는 772장 까지 입니다.", Toast.LENGTH_SHORT).show();
						txtSearch.setText("");
					} else {
						intent.putExtra("page", txtSearch.getText().toString());
						startActivity(intent);
					}
				} catch (NumberFormatException e) {
					Toast.makeText(SearchHymnal.this, "잘못된 입력입니다.", Toast.LENGTH_SHORT).show();
					txtSearch.setText("");
				}
			}
		});
        
        btnDel = (Button)findViewById(R.id.btnDelete);
        btnDel.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(txtSearch.getText().toString().length() > 0) txtSearch.setText(txtSearch.getText().toString().substring(0, txtSearch.getText().toString().length()-1));
			}
		});
        
        btn0 = (Button)findViewById(R.id.btn0);
        btn0.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(txtSearch.getText().toString().length() > 0){
					if(Integer.parseInt(txtSearch.getText().toString()) > 0)
						txtSearch.setText(txtSearch.getText().toString()+"0");
				}
					
			}
		});
        
        btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				txtSearch.setText(txtSearch.getText().toString()+"1");
			}
		});
        
        btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				txtSearch.setText(txtSearch.getText().toString()+"2");
			}
		});
        
        btn3 = (Button)findViewById(R.id.btn3);
        btn3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				txtSearch.setText(txtSearch.getText().toString()+"3");
			}
		});
        
        btn4 = (Button)findViewById(R.id.btn4);
        btn4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				txtSearch.setText(txtSearch.getText().toString()+"4");
			}
		});
        
        btn5 = (Button)findViewById(R.id.btn5);
        btn5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				txtSearch.setText(txtSearch.getText().toString()+"5");
			}
		});
        
        btn6 = (Button)findViewById(R.id.btn6);
        btn6.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				txtSearch.setText(txtSearch.getText().toString()+"6");
			}
		});
        
        btn7 = (Button)findViewById(R.id.btn7);
        btn7.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				txtSearch.setText(txtSearch.getText().toString()+"7");
			}
		});
        
        btn8 = (Button)findViewById(R.id.btn8);
        btn8.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				txtSearch.setText(txtSearch.getText().toString()+"8");
			}
		});
        
        btn9 = (Button)findViewById(R.id.btn9);
        btn9.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				txtSearch.setText(txtSearch.getText().toString()+"9");
			}
		});
        
        btnSetting = (Button)findViewById(R.id.btnSetting);
        btnSetting.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(SearchHymnal.this,Setting.class));
			}
		});
    }

	@Override
	protected void onResume() {
		super.onResume();
		txtSearch.setText("");
	}

    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(0,1,0,"찬미가 다운로드").setIcon(android.R.drawable.ic_menu_save);
		menu.add(0,2,0,"버그/개선").setIcon(android.R.drawable.ic_menu_help);
		menu.add(0,3,0,"종료").setIcon(android.R.drawable.ic_menu_close_clear_cancel);
    	return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			new AlertDialog.Builder(this)
			.setIcon(android.R.drawable.ic_dialog_alert)
			.setTitle("알림")
			.setMessage("무제한 요금제가 아닌 경우 Wifi 상태에서 다운로드 하시길 권장합니다.")
			.setPositiveButton("다운로드", new DialogInterface.OnClickListener() {
			    public void onClick( DialogInterface dialog, int which) {
			    	startActivity(new Intent(SearchHymnal.this,DlgDownload.class));
					overridePendingTransition(android.R.anim.slide_in_left,0);
			    }
			})
			.setNegativeButton("취소", null)
			.show();      
			break;
		case 2:
			Intent i = new Intent(Intent.ACTION_VIEW); 
			Uri u = Uri.parse("http://www.twitter.com/PereTanguy"); 
			i.setData(u); 
			startActivity(i);
			break;
		case 3:
			finish();
			break;
		}
		
		return false;
	}
	
	private boolean canTerminate = false;
	
	@Override
	public void onBackPressed() {
		if(canTerminate) super.onBackPressed();
		else Toast.makeText(this, "'뒤로' 버튼을 한번더 누르시면 종료됩니다.", 3000).show();
		
		canTerminate = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
					canTerminate = false;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
