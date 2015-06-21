/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.azz.customkeyboard.viewmodel
 *
 *    Filename:    CustomKeyboard.java
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
 *    Create at:   2015年6月12日 下午2:56:12
 *
 *    Revision:
 *
 *    2015年6月12日 下午2:56:12
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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @ClassName CustomKeyboard
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author sxszhangz
 * @Date 2015年6月12日 下午2:56:12
 * @version 1.0.0
 */
public final class CustomKeyboardItem extends FrameLayout implements OnKeyWorkListener {
    /**
     * @Field @TAG : TAG
     */
    private static final String TAG = "CustomKeyboardItem";
    /**
     * @Field @circleKeyboardItem : 圆盘键盘
     */
    private CustomCircleKeyboardItem circleKeyboardItem;
    /**
     * @Field @numKeyboardItem : 数字键盘
     */
    private CustomNumKeyboardItem numKeyboardItem;
    /**
     * @Field @mData : 数据源
     */
    private CustomKeyboardItemEntity mData;
    /**
     * @Field @onDpadCenterListener : 监听中键
     */
    private OnDpadCenterListener mOnDpadCenterListener;
    /**
     * @Description 构造函数
     * @param context context
     * @param attrs attrs
     * @param defStyle defStyle
     */
    public CustomKeyboardItem(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
        load();
    }
    /**
     * @Description 构造函数
     * @param context context
     * @param attrs attrs
     */
    public CustomKeyboardItem(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        load();
    }
    /**
     * @Description 构造函数
     * @param context context
     */
    public CustomKeyboardItem(final Context context) {
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
            LayoutInflater.from(getContext()).inflate(R.layout.custom_keyboard_item, this, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * @Description initialize the ui
     */
    private void initUI() {
        circleKeyboardItem = (CustomCircleKeyboardItem) findViewById(R.id.custom_circle_keyboard_item);
        if (circleKeyboardItem == null) {
            circleKeyboardItem = new CustomCircleKeyboardItem(getContext());
            this.addView(circleKeyboardItem);
        }
        numKeyboardItem = (CustomNumKeyboardItem) findViewById(R.id.custom_number_keyboard_item);
        if (numKeyboardItem == null) {
            numKeyboardItem = new CustomNumKeyboardItem(getContext());
            this.addView(numKeyboardItem);
        }
    }
    /**
     * @Description initialize the data
     */
    private void initData() {
        circleKeyboardItem.setOnKeyWorkListener(this);
        numKeyboardItem.setOnKeyWorkListener(this);
    }
    /**
     * @Description 设置数据
     * @param data 自定义键盘item实体类
     */
    public void setData(final CustomKeyboardItemEntity data) {
        mData = data;
        circleKeyboardItem.setData(data);
        numKeyboardItem.setData(data);
    }

    /**
     * @Field @showAnim : 是否需要动画
     */
    private boolean showAnim = false;
    /* (非 Javadoc)
     * Description:
     * @see com.azz.customkeyboard.listener.OnKeyWorkListener#onDpadCenter()
     */
    @Override
    public void onDpadCenter(final View view) {
        Log.d(TAG, "onDpadCenter");
        if (view == numKeyboardItem
                && numKeyboardItem.isShown()
                && !circleKeyboardItem.isShown()) {
            circleKeyboardItem.appearWithAnimation(showAnim);
            numKeyboardItem.disappearWithAnimation(showAnim);
        } else if (view == circleKeyboardItem) {
            if (null != mOnDpadCenterListener) {
                mOnDpadCenterListener.onDpadCenter(circleKeyboardItem.getSelectedString());
            }
        }
    }
    /**
     * @param onDpadCenterListener the onDpadCenterListener to set
     */
    public void setOnDpadCenterListener(final OnDpadCenterListener onDpadCenterListener) {
        this.mOnDpadCenterListener = onDpadCenterListener;
    }
    /* (非 Javadoc)
     * Description:
     * @see com.azz.customkeyboard.listener.OnKeyWorkListener#onBack()
     */
    @Override
    public boolean onBack(final View view) {
        if (view == circleKeyboardItem
                && circleKeyboardItem.isShown()
                && !numKeyboardItem.isShown()) {
            numKeyboardItem.appearWithAnimation(showAnim);
            circleKeyboardItem.disappearWithAnimation(showAnim);
            return true;
        }
        return false;
    }
}
