package sda.peretanguy.dialog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import sda.peretanguy.C;
import sda.peretanguy.R;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class DlgDownload extends Activity{
	private TextView txtMessage;
	private Button btnStop;
	private Thread downloadThread;
	
	private boolean threadFlag = true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dlg_download);
		
		getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		
		txtMessage = (TextView)findViewById(R.id.txtMsg);
		
		btnStop = (Button)findViewById(R.id.btnStop);
		btnStop.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
		
		downloadThread = new Thread(new Runnable() {
			public void run() {
				getHymnalImage();
			}
		});
        downloadThread.start();
	}
	
	private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
        	if(msg.what == 0) {
        		killThread();
        	}
        	else {
        		int progress= (int)((float)msg.what / (float)772 * 100);
        		
        		txtMessage.setText(progress + "%");
        	}
        }
    };
    
    public void killThread(){
    	threadFlag = false;
    	if(downloadThread != null && downloadThread.isAlive()){
    		downloadThread.interrupt();
    	}
    	finish();
    	overridePendingTransition(0,android.R.anim.slide_out_right);
    }
    
    public void getHymnalImage(){
    	File dir = new File(C.DOWNLOAD_PATH);
    	if(!dir.isDirectory()){    		
    		dir.mkdir();
    	}

		try {
			for(int page=1;page<773;page++){				
				if(threadFlag){
					String strUrl = "";
					if(page<10){
						strUrl = C.URL_HEAD + "00" + page + C.URL_TAIL;
					} else if(page<100){
						strUrl = C.URL_HEAD + "0" + page + C.URL_TAIL;
					} else {
						strUrl = C.URL_HEAD + page + C.URL_TAIL;
					}
					
					File checkFile = new File(C.DOWNLOAD_PATH + page + C.URL_TAIL);
			    	if(!checkFile.isFile()){    		
				        InputStream inputStream = new URL(strUrl).openStream();
				        File saveFile = new File(C.DOWNLOAD_PATH + page + C.URL_TAIL);    
				        OutputStream out = new FileOutputStream(saveFile);
				        saveRemoteFile(inputStream, out);
				        out.close();
			    	} else {
			    		checkFile = new File(C.DOWNLOAD_PATH + (page+1) + C.URL_TAIL);
				    	if(!checkFile.isFile()){    		
					        InputStream inputStream = new URL(strUrl).openStream();
					        File saveFile = new File(C.DOWNLOAD_PATH + page + C.URL_TAIL);    
					        OutputStream out = new FileOutputStream(saveFile);
					        saveRemoteFile(inputStream, out);
					        out.close();
				    	}	
			    	}				        
			        
			        handler.sendEmptyMessage(page);
				} else {
					Log.d("Hymnal","Stop Downloding");
					break;
				}
			}

			handler.sendEmptyMessage(0);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    public void saveRemoteFile(InputStream is, OutputStream os) {
    	try {
	        int c = 0;
			while((c = is.read()) != -1)
			    os.write(c);
			os.flush();    
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    @Override
	public void onBackPressed() {
		killThread();	
		super.onBackPressed();
	}
}
