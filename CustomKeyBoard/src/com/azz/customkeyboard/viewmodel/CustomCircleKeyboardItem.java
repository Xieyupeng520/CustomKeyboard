package com.azz.customkeyboard.viewmodel;


import com.azz.customkeyboard.entity.CustomKeyboardItemEntity;
import com.azz.customkeyboard.listener.OnDpadCenterListener;
import com.azz.customkeyboard.listener.OnKeyWorkListener;
import com.azz.customkeyboard.R;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @ClassName CustomKeyBoardItem
 * @Description CustomKeyBoardItem模型
 * @author sxszhangz
 * @Date 2015年6月12日 上午8:54:58
 * @version 1.0.0
 */
public final class CustomCircleKeyboardItem extends LinearLayout implements OnKeyListener {
    /**
     * @Field @TAG : tag
     */
    private static final String TAG = "CustomKeyBoardItem";
    /**
     * @Field topTextView : 上
     */
    private TextView topTextView;
    /**
     * @Field bottomTextView : 下
     */
    private TextView bottomTextView;
    /**
     * @Field leftTextView : 左
     */
    private TextView leftTextView;
    /**
     * @Field rightTextView : 右
     */
    private TextView rightTextView;
    /**
     * @Field @centerButton : 中
     */
    private Button centerButton;
    /**
     * @Field @mData : 数据源
     */
    private CustomKeyboardItemEntity mData;
    /**
     * @Field @mDataBackup : 数据备份（可能被改变值的）
     */
    private CustomKeyboardItemEntity mDataBackup;
    /**
     * @Field @mOnKeyWorkListener : onKey监听器
     */
    private OnKeyWorkListener mOnKeyWorkListener;

    /**
     * @Description 构造函数
     * @param context context
     * @param attrs attrs
     * @param defStyle defStyle
     */
    public CustomCircleKeyboardItem(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
        load();
    }

    /**
     * @Description 构造函数
     * @param context context
     * @param attrs attrs
     */
    public CustomCircleKeyboardItem(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    	load();
    }
    /**
     * @Description 构造函数
     * @param context context
     */
    public CustomCircleKeyboardItem(final Context context) {
    	super(context);
    	load();
    }
    /**
     * @Description load
     */
    private void load() {
        if (isInEditMode()) {
            return;
        }
        inflateLayout();
        initUI();
        initData();
    }
    /**
     * @Description inflate the main layout
     */
    private void inflateLayout() {
        try {
            LayoutInflater.from(getContext()).inflate(R.layout.custom_keyboard_item_circle, this, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * @Description initialize the ui
     */
    private void initUI() {
    	topTextView = (TextView) findViewById(R.id.topTextView);
    	bottomTextView = (TextView) findViewById(R.id.bottomTextView);
    	leftTextView = (TextView) findViewById(R.id.leftTextView);
    	rightTextView = (TextView) findViewById(R.id.rightTextView);
    	centerButton = (Button) findViewById(R.id.centerButton);
    }
    /**
     * @Description initialize the data
     */
    private void initData() {
        centerButton.setOnKeyListener(this);
        //初始化数据
        mData = new CustomKeyboardItemEntity("A", "B", "C", "D", "E");
        setData(mData);
    }
    /**
     * @Description 设置数据
     * @param data 自定义键盘item实体类
     */
    public void setData(final CustomKeyboardItemEntity data) {
    	mData = data;
    	mDataBackup = mData.backup();
    	leftTextView.setText(data.getLeftText());
    	topTextView.setText(data.getTopText());
    	rightTextView.setText(data.getRightText());
    	bottomTextView.setText(data.getBottomText());
    	centerButton.setText(data.getCenterText());
    }
    /**
     * @Description 更新数据
     */
    private void updateDataBackup() {
	leftTextView.setText(mDataBackup.getLeftText());
	topTextView.setText(mDataBackup.getTopText());
	rightTextView.setText(mDataBackup.getRightText());
	bottomTextView.setText(mDataBackup.getBottomText());
	centerButton.setText(mDataBackup.getCenterText());
    }
    /* (非 Javadoc)
     * Description:
     * @see android.view.View.OnKeyListener#onKey(android.view.View, int, android.view.KeyEvent)
     */
    @Override
    public boolean onKey(final View v, final int keyCode, final KeyEvent event) {
        boolean returnValue = false; //返回值，false表示继续往下传，true代表事件结束
    	if (event.getAction() == KeyEvent.ACTION_DOWN) {
    	    switch (keyCode) {
    	    case KeyEvent.KEYCODE_DPAD_LEFT:
    	        mDataBackup.left();
    	        returnValue = true;
    	        break;
    	    case KeyEvent.KEYCODE_DPAD_UP:
    	        mDataBackup.up();
    	        returnValue = true;
    	        break;
    	    case KeyEvent.KEYCODE_DPAD_RIGHT:
    	        mDataBackup.right();
    	        returnValue = true;
    	        break;
    	    case KeyEvent.KEYCODE_DPAD_DOWN:
    	        mDataBackup.down();
    	        returnValue = true;
    	        break;
    	    case KeyEvent.KEYCODE_DPAD_CENTER:
    	        if (null != mDataBackup) {
    	            Log.v(TAG, "-----------------center:" + mDataBackup.getCenterText());
                }
    	        if (mOnKeyWorkListener != null) {
    	            mOnKeyWorkListener.onDpadCenter(this);
    	        }
    	        break;
    	    case KeyEvent.KEYCODE_BACK:
    	        mDataBackup = mData.backup();
    	        if (mOnKeyWorkListener != null) {
    	            returnValue = mOnKeyWorkListener.onBack(this);
                }
    	        break;
    	    default:
    	        break;
    	    }
    	    updateDataBackup();
    	}
	    return returnValue;
    }
    /**
     * @Description 得到选中的字符
     * @return 选中的字符
     */
    public String getSelectedString() {
        return mDataBackup.getCenterText();
    }
    /**
     * @param onKeyWorkListener the mOnKeyWorkListener to set
     */
    public void setOnKeyWorkListener(final OnKeyWorkListener onKeyWorkListener) {
        this.mOnKeyWorkListener = onKeyWorkListener;
    }
    /**
     * @Description 显示
     * @param anim 是否加特效
     */
    public void appearWithAnimation(final boolean anim) {
        this.setVisibility(View.VISIBLE);
        this.requestFocus();
        if (anim) {
            this.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.appear_alpha_anim));
        }
    }
    /**
     * @Description 显示
     * @param anim 是否加特效
     */
    public void disappearWithAnimation(final boolean anim) {
        if (anim) {
            this.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.disappear_alpha_anim));
        }
        this.setVisibility(View.GONE);
    }

}
