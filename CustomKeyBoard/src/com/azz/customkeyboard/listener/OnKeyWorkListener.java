/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.azz.customkeyboard.listener
 *
 *    Filename:    OnKeyWorkListener.java
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
 *    Create at:   2015年6月12日 下午5:55:58
 *
 *    Revision:
 *
 *    2015年6月12日 下午5:55:58
 *        - first revision
 *
 *****************************************************************/
package com.azz.customkeyboard.listener;

import android.view.View;

/**
 * @ClassName OnKeyWorkListener
 * @Description 按键起作用时的监听器
 * @author sxszhangz
 * @Date 2015年6月12日 下午5:55:58
 * @version 1.0.0
 */
public interface OnKeyWorkListener {
    /**
     * @Description 按中心键的时候
     * @param view 监听事件的view
     */
    void onDpadCenter(View view);
    /**
     * @Description 按返回的时候
     * @param view 监听事件的view
     * @return 返回true，停止返回事件，false，继续传返回事件到下一层
     */
    boolean onBack(View view);
}
