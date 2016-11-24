package com.example.test_dynamicload;

import java.io.File;

import Interface.IShowToast;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import dalvik.system.DexClassLoader;
/**
 * ≤‚ ‘android∂ØÃ¨º”‘ÿ
 * @author Administrator
 *
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		File dir = getDir("dex1",Context.MODE_PRIVATE);
		String dexPath=Environment.getExternalStorageDirectory()+File.separator+"output.jar";
		DexClassLoader loader=new DexClassLoader(dexPath, dir.getAbsolutePath(), null, getClassLoader());
		
		try {
			Class<?> clz = loader.loadClass("com.example.dynamicloadmeterial.ShowToast");
			IShowToast obj=(IShowToast) clz.newInstance();
			obj.showToast(this);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
