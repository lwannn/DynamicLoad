package com.example.dynamicloadmeterial;

import Interface.IShowToast;
import android.content.Context;
import android.widget.Toast;

public class ShowToast implements IShowToast {

	@Override
	public void showToast(Context context) {
		Toast.makeText(context, "������ңԶ�Ķ�������Ҫ̫��Ľ�ң��ߺߣ�����", Toast.LENGTH_LONG).show();
	}

}
