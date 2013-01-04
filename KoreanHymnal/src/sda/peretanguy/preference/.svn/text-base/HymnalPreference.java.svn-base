package sda.peretanguy.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class HymnalPreference {
	private Context mContext;
	
	public static final String NOT_FIRST_RUN = "not_first_run";
	
	public static final String LANDSCAPE = "landscape";
	
	
	
	private static HymnalPreference instance = null;
	static {
		instance = new HymnalPreference();
	}
	
	public HymnalPreference(){}
	
	public static HymnalPreference getInstance() {
		return instance;
	}
	
	// Application 시작시, Application Context 를 set 해준다.
	public HymnalPreference setContext(Context context) {
		mContext = context;
		return instance;
	}
	
	// 통화연결 알림
	public void setLandscape(boolean value){
		putSharedPreference(LANDSCAPE, value);
	}
		
	public boolean getLandscape(){
		return getBooleanDefaultTrue(LANDSCAPE);
	}
		
	// 통화연결 알림
	public void setNotFirstRun(boolean value){
		putSharedPreference(NOT_FIRST_RUN, value);
	}
		
	public boolean getNotFirstRun(){
		return getBooleanDefaultTrue(NOT_FIRST_RUN);
	}
	
	/////////////////////////////////////////////////////////////////
	
	// String 저장
	public void putSharedPreference(String key, String value){
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString(key, value);
		editor.commit();
	}

	// boolean 저장
	public void putSharedPreference(String key, boolean value){
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	// int 저장
	public void putSharedPreference(String key, Integer value){
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putInt(key, value);
		editor.commit();
	}
	
	// long 저장
	public void putSharedPreference(String key, long value){
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putLong(key, value);
		editor.commit();
	}

	// String 값을 받아옴
	public String getStringSharedPreference(String key){
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
		return prefs.getString(key, null);
	}

	// boolean 값을 받아옴
	public boolean getBooleanSharedPreference(String key){
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
		return prefs.getBoolean(key, false);
	}
	
	// boolean 값을 받아옴 default true
	public boolean getBooleanDefaultTrue(String key){
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
		return prefs.getBoolean(key, true);
	}

	// int 값을 받아옴
	public int getIntSharedPreference(String key){
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
		return prefs.getInt(key, -1);
	}
	
	// long 값을 받아옴
	public long getLongSharedPreference(String key){
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
		return prefs.getLong(key, 0);
	}

	// 키를 활용하여 특정 데이터 삭제
	public void removeSharedPreference(String key) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
		SharedPreferences.Editor editor = prefs.edit();
		editor.remove(key);
		editor.commit();
	}
	
	// 모든 데이터 삭제
	public void removeSharedPreference() {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
		SharedPreferences.Editor editor = prefs.edit();
		editor.clear();
		editor.commit();
	}
}