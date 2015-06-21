/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.azz.customkeyboard.viewmodel
 *
 *    Filename:    CustomNumKeyboardItem.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    Copyright:   Copyright (c) 2001-2014
 *
 *    Company:     Digital Telemedia Co.,Ltd
 *
 *    @author:     sxszhangz
 *
 *    @version:    1.0.0
 *
 *    Create at:   2015年6月12日 上午11:36:02
 *
 *    Revision:
 *
 *    2015年6月12日 上午11:36:02
 *        - first revision
 *
 *****************************************************************/
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
 * @ClassName CustomNumKeyboardItem
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author sxszhangz
 * @Date 2015年6月12日 上午11:36:02
 * @version 1.0.0
 */
public final class CustomNumKeyboardItem extends LinearLayout implements OnKeyListener {
    /**
     * @Field @numButton : 数字键
     */
    private Button mNumButton;
    /**
     * @Field @letterTextView : 字母显示区域
     */
    private TextView mLetterTextView;
    /**
     * @Field @mData : 数据源
     */
    private CustomKeyboardItemEntity mData;
    /**
     * @Field @mOnKeyWorkListener : onKey监听器
     */
    private OnKeyWorkListener mOnKeyWorkListener;
    /**
     * @Field @onDpadCenterListener : 监听中键
     */
    private OnDpadCenterListener mOnDpadCenterListener;
    /**
     * @Description 构造函数
     * @param context 上下文
     */
    public CustomNumKeyboardItem(final Context context) {
        super(context);
        load();
    }
    /**
     * @Description 构造函数
     * @param context context
     * @param attrs attrs
     * @param defStyle defStyle
     */
    public CustomNumKeyboardItem(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
        load();
    }
    /**
     * @Description 构造函数
     * @param context context
     * @param attrs attrs
     */
    public CustomNumKeyboardItem(final Context context, final AttributeSet attrs) {
        super(context, attrs);
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
            LayoutInflater.from(getContext()).inflate(R.layout.custom_keyboard_item_num, this, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * @Description initialize the ui
     */
    private void initUI() {
        mNumButton = (Button) findViewById(R.id.numButton);
        mLetterTextView = (TextView) findViewById(R.id.letterTextView);
    }
    /**
     * @Description initialize the data
     */
    private void initData() {
        mNumButton.setOnKeyListener(this);
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
        mNumButton.setText(data.getNumText());
        mLetterTextView.setText(data.getLettersText());
    }
    /* (非 Javadoc)
     * Description:
     * @see android.view.View.OnKeyListener#onKey(android.view.View, int, android.view.KeyEvent)
     */
    @Override
    public boolean onKey(final View v, final int keyCode, final KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_UP) {
            switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_CENTER:
                if (mOnKeyWorkListener != null) {
                    mOnKeyWorkListener.onDpadCenter(this);
                }
                if (mOnDpadCenterListener != null) { //比如1和0的时候，直接获得值
                    mOnDpadCenterListener.onDpadCenter(getSelectedString());
                }
                break;
            case KeyEvent.KEYCODE_BACK:
                if (mOnKeyWorkListener != null) {
                    return mOnKeyWorkListener.onBack(this);
                }
                break;
            default:
                break;
            }
        }
        return false;
    }
    /**
     * @Description 得到选中的字符
     * @return 选中的字符
     */
    public String getSelectedString() {
        return mData.getNumText();
    }
    /**
     * @param onKeyWorkListener the mOnKeyWorkListener to set
     */
    public void setOnKeyWorkListener(final OnKeyWorkListener onKeyWorkListener) {
        this.mOnKeyWorkListener = onKeyWorkListener;
    }
    /**
     * @param onDpadCenterListener the onDpadCenterListener to set
     */
    public void setOnDpadCenterListener(final OnDpadCenterListener onDpadCenterListener) {
        this.mOnDpadCenterListener = onDpadCenterListener;
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
