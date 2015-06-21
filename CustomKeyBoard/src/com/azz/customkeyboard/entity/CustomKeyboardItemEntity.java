/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.example.customkeyboard.entity
 *
 *    Filename:    CustomKeyBoardItemEntity.java
 *
 *    Description: 自定义键盘数据实体
 *
 *    Copyright:   Copyright (c) 2001-2014
 *
 *    Company:     Digital Telemedia Co.,Ltd
 *
 *    @author:     sxszhangz
 *
 *    @version:    1.0.0
 *
 *    Create at:   2015年6月11日 下午3:42:32
 *
 *    Revision:
 *
 *    2015年6月11日 下午3:42:32
 *        - first revision
 *
 *****************************************************************/
package com.azz.customkeyboard.entity;


/**
 * @ClassName CustomKeyBoardItemEntity
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author sxszhangz
 * @Date 2015年6月11日 下午3:42:32
 * @version 1.0.0
 */
public final class CustomKeyboardItemEntity {
    /**
     * @Field topText : 上
     */
    private String mTopText;
    /**
     * @Field bottomText : 下
     */
    private String mBottomText;
    /**
     * @Field leftText : 左
     */
    private String mLeftText;
    /**
     * @Field rightText : 右
     */
    private String mRightText;
    /**
     * @Field @centerText : 中
     */
    private String mCenterText;
    /**
     * @Description initialize the entity
     * @param center 中间
     * @param left 左
     * @param top 上
     * @param right 右
     * @param bottom 下
     */
    public CustomKeyboardItemEntity(
            final String center, final String left,
            final String top, final String right, final String bottom) {
        mCenterText = center;
        mLeftText = left;
        mTopText = top;
        mRightText = right;
        mBottomText = bottom;
    }
    /**
     * @Description initialize the entity
     * @param center 中间
     * @param left 左
     * @param top 上
     * @param right 右
     */
    public CustomKeyboardItemEntity(
            final String center, final String left,
            final String top, final String right) {
        this(center, left, top, right, null);
    }
    /**
     * @Description 备份
     * @return 相同的数据备份
     */
    public CustomKeyboardItemEntity backup() {
        return new CustomKeyboardItemEntity(mCenterText, mLeftText, mTopText, mRightText, mBottomText);
    }
    /**
     * @Description 和左边交换
     */
    public void left() {
        if (mLeftText == null) {
            return;
        }
        String temp = mLeftText;
        mLeftText = mCenterText;
        mCenterText = temp;
    }
    /**
     * @Description 和上面交换
     */
    public void up() {
        if (mTopText == null) {
            return;
        }
        String temp = mTopText;
        mTopText = mCenterText;
        mCenterText = temp;
    }
    /**
     * @Description 和右边交换
     */
    public void right() {
        if (mRightText == null) {
            return;
        }
        String temp = mRightText;
        mRightText = mCenterText;
        mCenterText = temp;
    }
    /**
     * @Description 和下面交换
     */
    public void down() {
        if (mBottomText == null) {
            return;
        }
        String temp = mBottomText;
        mBottomText = mCenterText;
        mCenterText = temp;
    }
    /**
     * @Description 得到数字键的数字
     * @return 数字
     */
    public String getNumText() {
        return mCenterText;
    }
    /**
     * @Description 得到数字键下面的字母
     * @return 字母集
     */
    public String getLettersText() {
        String str;
        str = mLeftText + mTopText + mRightText;
        if (mBottomText != null) {
            str += mBottomText;
        }
        return str;
    }
    /**
     * @return the topText
     */
    public String getTopText() {
        return mTopText;
    }
    /**
     * @param topText the topText to set
     */
    public void setTopText(final String topText) {
        this.mTopText = topText;
    }
    /**
     * @return the bottomText
     */
    public String getBottomText() {
        return mBottomText;
    }
    /**
     * @param bottomText the bottomText to set
     */
    public void setBottomText(final String bottomText) {
        this.mBottomText = bottomText;
    }
    /**
     * @return the leftText
     */
    public String getLeftText() {
        return mLeftText;
    }
    /**
     * @param leftText the leftText to set
     */
    public void setLeftText(final String leftText) {
        this.mLeftText = leftText;
    }
    /**
     * @return the rightText
     */
    public String getRightText() {
        return mRightText;
    }
    /**
     * @param rightText the rightText to set
     */
    public void setRightText(final String rightText) {
        this.mRightText = rightText;
    }
    /**
     * @return the centerText
     */
    public String getCenterText() {
        return mCenterText;
    }
    /**
     * @param centerText the centerText to set
     */
    public void setCenterText(final String centerText) {
        this.mCenterText = centerText;
    }
}
