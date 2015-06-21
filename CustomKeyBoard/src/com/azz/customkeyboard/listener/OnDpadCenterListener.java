/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.azz.customkeyboard.listener
 *
 *    Filename:    OnDpadCenterListener.java
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
 *    Create at:   2015年6月15日 下午6:23:55
 *
 *    Revision:
 *
 *    2015年6月15日 下午6:23:55
 *        - first revision
 *
 *****************************************************************/
package com.azz.customkeyboard.listener;


/**
 * @ClassName OnDpadCenterListener
 * @Description 按中键的监听器
 * @author sxszhangz
 * @Date 2015年6月15日 下午6:23:55
 * @version 1.0.0
 */
public interface OnDpadCenterListener {
    /**
     * @Description 按中心键的时候
     * @param selectString 选中的字符
     */
    void onDpadCenter(String selectString);
    /**
     * @Description 清除按钮被点击
     */
    void onClearPressed();
    /**
     * @Description 当删除按钮被点击
     */
    void onDeletePressed();
}
