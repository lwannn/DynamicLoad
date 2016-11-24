package com.example.dynamicloadmeterial;

import Interface.IShowToast;
import android.content.Context;
import android.widget.Toast;

public class ShowToast implements IShowToast {

	@Override
	public void showToast(Context context) {
		Toast.makeText(context, "我来自遥远的东方，不要太羡慕我，哼哼！！！", Toast.LENGTH_LONG).show();
	}

}
