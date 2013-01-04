package sda.peretanguy.activities;

import java.io.BufferedInputStream;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import sda.peretanguy.C;
import sda.peretanguy.R;
import sda.peretanguy.preference.HymnalPreference;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HymnalLandscape extends Activity {
	private static final int MENU_PREV = 0;
	private static final int MENU_NEXT = 1;
	private ImageView imgHymnal;
	private TextView txtTitle;
	private Button btnPrev, btnNext;
	private int page;
	private ProgressDialog progDialog;

	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hymnal);
        
        if(HymnalPreference.getInstance().getLandscape()) setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // 가로고정
        
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                
        Bundle bundle = getIntent().getExtras();
        page = Integer.parseInt(bundle.getString("page"));
        
        imgHymnal = (ImageView)findViewById(R.id.imgHymnal);
        
        txtTitle = (TextView)findViewById(R.id.txtTitle);
        txtTitle.setText(String.valueOf(page));
        
        btnPrev = (Button)findViewById(R.id.btnPrev);
        btnPrev.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				goToPrev();
			}
		});
        
        btnNext = (Button)findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				goToNext();
			}
		});
        
        if(page > 1) {
        	btnPrev.setVisibility(View.VISIBLE);
        	btnPrev.setText("< " + (page-1));
        	
        }
        
		if(page < 772) {
			btnNext.setVisibility(View.VISIBLE);
			btnNext.setText((page+1) + " >");
		}
        
        showHymnal();
    }
	
	private Handler handler = new Handler(){
		public void handleMessage(Message msg){
			switch(msg.what){
			case C.SHOW_PROGRESS:
				showProgressDialog("로딩중입니다...", true);
				break;
			case C.SHOW_BITMAP :
				imgHymnal.setImageBitmap(bitmap);
				break;
			case C.CLOSE_PROGRESS :
				dismissProgressDialog();
				break;
			case C.NETWORK_ERROR :
				Toast.makeText(HymnalLandscape.this, "네트워크 오류입니다.\n잠시후 다시 시도해주세요.", 3000).show();
				break;
			}
		}
	};
	
	Bitmap bitmap = null;
	private void showHymnal() {
		File checkFile = new File(C.DOWNLOAD_PATH + page + C.URL_TAIL);

		if(!checkFile.isFile()){    		

    		new Thread(new Runnable() {
				@Override
				public void run() {
					URLConnection conn;
		    		try {
		    			handler.sendEmptyMessage(C.SHOW_PROGRESS);
		    			conn = getPageUrl(page).openConnection();
		    			conn.connect();
		    			BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
		    			bitmap = BitmapFactory.decodeStream(bis);
		    			handler.sendEmptyMessage(C.SHOW_BITMAP);
		    			handler.sendEmptyMessage(C.CLOSE_PROGRESS);
		    			bis.close();
		    		} catch (Exception e){
		    			handler.sendEmptyMessage(C.NETWORK_ERROR);
		    		}
				}
			}).start();
			
    	} else {
    		bitmap = BitmapFactory.decodeFile(C.DOWNLOAD_PATH + page + C.URL_TAIL);
    		imgHymnal.setImageBitmap(bitmap);
    	}    	
	}
    	
	public URL getPageUrl(int page) {
		String url = "";

		if (page < 10) {
			url = C.URL_HEAD + "00" + page + C.URL_TAIL;
		} else if (page < 100) {
			url = C.URL_HEAD + "0" + page + C.URL_TAIL;
		} else {
			url = C.URL_HEAD + page + C.URL_TAIL;
		}

		try {
			URL pageUrl = new URL(url);
			return pageUrl;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if(page > 1) menu.add(0, MENU_PREV, 0, (page-1)+"장");
		if(page < 772) menu.add(0, MENU_NEXT, 0, (page+1)+"장");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case MENU_PREV:
			goToPrev();
			break;
		case MENU_NEXT:
			goToNext();
			break;
		}
		return true;
	}
	
	private void goToPrev(){
		Intent intent = new Intent(this,HymnalLandscape.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.putExtra("page", (page-1)+"");
		startActivity(intent);
		finish();
		overridePendingTransition(0, R.anim.go_to_right);
	}
	
	private void goToNext(){
		Intent intent = new Intent(this,HymnalLandscape.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.putExtra("page", (page+1)+"");
		startActivity(intent);
		finish();
		overridePendingTransition(0, R.anim.go_to_left);
	}
	
	public void showProgressDialog(String message, boolean cancelable){
		if (progDialog != null) {
			progDialog.dismiss();
			progDialog = null;
		}
		progDialog = new ProgressDialog(this);
		progDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progDialog.setMessage(message);
		progDialog.setCancelable(cancelable);
		progDialog.show();
	}

	public void dismissProgressDialog() {
		if (progDialog != null)	progDialog.dismiss();
		progDialog = null;
	}
}
