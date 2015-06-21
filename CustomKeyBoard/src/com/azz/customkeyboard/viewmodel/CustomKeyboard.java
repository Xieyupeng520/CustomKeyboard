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
 *    Create at:   2015年6月15日 下午2:32:03
 *
 *    Revision:
 *
 *    2015年6月15日 下午2:32:03
 *        - first revision
 *
 *****************************************************************/
package com.azz.customkeyboard.viewmodel;

import com.azz.customkeyboard.R;
import com.azz.customkeyboard.entity.CustomKeyboardItemEntity;
import com.azz.customkeyboard.listener.OnDpadCenterListener;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;


/**
 * @ClassName CustomKeyboard
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author sxszhangz
 * @Date 2015年6月15日 下午2:32:03
 * @version 1.0.0
 */
public final class CustomKeyboard extends RelativeLayout {
    /**
     * @Field @item1 : item1
     */
    private CustomNumKeyboardItem mItem1;
    /**
     * @Field @items : item2
     */
    private CustomKeyboardItem mItem2;
    /**
     * @Field @items : item3
     */
    private CustomKeyboardItem mItem3;
    /**
     * @Field @items : item4
     */
    private CustomKeyboardItem mItem4;
    /**
     * @Field @items : item5
     */
    private CustomKeyboardItem mItem5;
    /**
     * @Field @items : item6
     */
    private CustomKeyboardItem mItem6;
    /**
     * @Field @items : item7
     */
    private CustomKeyboardItem mItem7;
    /**
     * @Field @items : item8
     */
    private CustomKeyboardItem mItem8;
    /**
     * @Field @items : item9
     */
    private CustomKeyboardItem mItem9;
    /**
     * @Field @onDpadCenterListener : 监听中键
     */
    private OnDpadCenterListener mOnDpadCenterListener;
    /**
     * @Field @mItem0 : item0
     */
    private Button mItem0;
    /**
     * @Field @mItemClear : 清除按钮
     */
    private ImageButton mItemClear;
    /**
     * @Field @mItemDelete : 删除按钮
     */
    private ImageButton mItemDelete;
    /**
     * @Description 构造函数
     * @param context context
     * @param attrs attrs
     * @param defStyle defStyle
     */
    public CustomKeyboard(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
        load();
    }

    /**
     * @Description 构造函数
     * @param context context
     * @param attrs attrs
     */
    public CustomKeyboard(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        load();
    }

    /**
     * @Description 构造函数
     * @param context context
     */
    public CustomKeyboard(final Context context) {
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
            LayoutInflater.from(getContext()).inflate(R.layout.custom_keyboard, this, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * @Description initialize the ui
     */
    private void initUI() {
        mItem1 = (CustomNumKeyboardItem) findViewById(R.id.item1);
        mItem2 = (CustomKeyboardItem) findViewById(R.id.item2);
        mItem3 = (CustomKeyboardItem) findViewById(R.id.item3);
        mItem4 = (CustomKeyboardItem) findViewById(R.id.item4);
        mItem5 = (CustomKeyboardItem) findViewById(R.id.item5);
        mItem6 = (CustomKeyboardItem) findViewById(R.id.item6);
        mItem7 = (CustomKeyboardItem) findViewById(R.id.item7);
        mItem8 = (CustomKeyboardItem) findViewById(R.id.item8);
        mItem9 = (CustomKeyboardItem) findViewById(R.id.item9);
        mItem0 = (Button) findViewById(R.id.item0);
        mItemClear = (ImageButton) findViewById(R.id.itemClear);
        mItemDelete = (ImageButton) findViewById(R.id.itemDelete);
    }
    /**
     * @Description initialize the data
     */
    private void initData() {
        String[] dataItem1 = getResources().getStringArray(R.array.item1);
        String[] dataItem2 = getResources().getStringArray(R.array.item2);
        String[] dataItem3 = getResources().getStringArray(R.array.item3);
        String[] dataItem4 = getResources().getStringArray(R.array.item4);
        String[] dataItem5 = getResources().getStringArray(R.array.item5);
        String[] dataItem6 = getResources().getStringArray(R.array.item6);
        String[] dataItem7 = getResources().getStringArray(R.array.item7);
        String[] dataItem8 = getResources().getStringArray(R.array.item8);
        String[] dataItem9 = getResources().getStringArray(R.array.item9);

        CustomKeyboardItemEntity cEntity = new CustomKeyboardItemEntity(
                dataItem1[0], "", "", "");
        mItem1.setData(cEntity);
        cEntity = new CustomKeyboardItemEntity(
                dataItem2[0], dataItem2[1], dataItem2[2], dataItem2[3]);
        mItem2.setData(cEntity);
        cEntity = new CustomKeyboardItemEntity(
                dataItem3[0], dataItem3[1], dataItem3[2], dataItem3[3]);
        mItem3.setData(cEntity);
        cEntity = new CustomKeyboardItemEntity(
                dataItem4[0], dataItem4[1], dataItem4[2], dataItem4[3]);
        mItem4.setData(cEntity);
        cEntity = new CustomKeyboardItemEntity(
                dataItem5[0], dataItem5[1], dataItem5[2], dataItem5[3]);
        mItem5.setData(cEntity);
        cEntity = new CustomKeyboardItemEntity(
                dataItem6[0], dataItem6[1], dataItem6[2], dataItem6[3]);
        mItem6.setData(cEntity);
        cEntity = new CustomKeyboardItemEntity(
                dataItem7[0], dataItem7[1], dataItem7[2], dataItem7[3], dataItem7[4]);
        mItem7.setData(cEntity);
        cEntity = new CustomKeyboardItemEntity(
                dataItem8[0], dataItem8[1], dataItem8[2], dataItem8[3]);
        mItem8.setData(cEntity);
        cEntity = new CustomKeyboardItemEntity(
                dataItem9[0], dataItem9[1], dataItem9[2], dataItem9[3], dataItem9[4]);
        mItem9.setData(cEntity);
    }

    /**
     * @return the onDpadCenterListener
     */
    public OnDpadCenterListener getOnDpadCenterListener() {
        return mOnDpadCenterListener;
    }

    /**
     * @param onDpadCenterListener the onDpadCenterListener to set
     */
    public void setOnDpadCenterListener(final OnDpadCenterListener onDpadCenterListener) {
        this.mOnDpadCenterListener = onDpadCenterListener;
        mItem1.setOnDpadCenterListener(mOnDpadCenterListener);
        mItem2.setOnDpadCenterListener(mOnDpadCenterListener);
        mItem3.setOnDpadCenterListener(mOnDpadCenterListener);
        mItem4.setOnDpadCenterListener(mOnDpadCenterListener);
        mItem5.setOnDpadCenterListener(mOnDpadCenterListener);
        mItem6.setOnDpadCenterListener(mOnDpadCenterListener);
        mItem7.setOnDpadCenterListener(mOnDpadCenterListener);
        mItem8.setOnDpadCenterListener(mOnDpadCenterListener);
        mItem9.setOnDpadCenterListener(mOnDpadCenterListener);
        mItem0.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (null != mOnDpadCenterListener) {
                    mOnDpadCenterListener.onDpadCenter(mItem0.getText().toString());
                }
            }
        });
        mItemClear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (null != mOnDpadCenterListener) {
                    mOnDpadCenterListener.onClearPressed();
                }
            }
        });
        mItemDelete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mOnDpadCenterListener) {
                    mOnDpadCenterListener.onDeletePressed();
                }
            }
        });
    }

}
