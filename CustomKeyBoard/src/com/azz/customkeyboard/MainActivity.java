package com.azz.customkeyboard;

import com.azz.customkeyboard.entity.CustomKeyboardItemEntity;
import com.azz.customkeyboard.viewmodel.CustomCircleKeyboardItem;
import com.azz.customkeyboard.viewmodel.CustomKeyboardItem;
import com.azz.customkeyboard.R;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;

/**
 * @ClassName MainActivity
 * @Description 主函数
 * @author sxszhangz
 * @Date 2015年6月12日 上午10:04:49
 * @version 1.0.0
 */
public final class MainActivity extends Activity {
/**
 * @Field @customKeyBoardItemView : item
 */
private CustomKeyboardItem customKeyBoardItemView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		initUI();
//		initData();
	}
	/**
	 * @Description 初始化UI
	 */
	private void initUI() {
//	    customKeyBoardItemView = (CustomKeyboardItem) findViewById(R.id.custom_keyboard_item);
	    customKeyBoardItemView = new CustomKeyboardItem(getApplicationContext());
	    RelativeLayout contentlLayout = (RelativeLayout) findViewById(R.id.contentView);
	    contentlLayout.addView(customKeyBoardItemView);
	}
	/**
	 * @Description 初始化数据
	 */
	private void initData() {
//	    CustomKeyboardItemEntity data = new CustomKeyboardItemEntity("W", "X", "Y", "Z", "9");
	    CustomKeyboardItemEntity data = new CustomKeyboardItemEntity("L", "J", "K", "5");
	    customKeyBoardItemView.setData(data);
	}
}
