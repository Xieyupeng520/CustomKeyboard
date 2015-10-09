**自定义键盘说明书**
===
一、效果图
---
自定义键盘最后达成效果图如下（背景为透明）：
<br>![](https://raw.githubusercontent.com/Xieyupeng520/CustomKeyboard/master/CustomKeyBoard/assets/snapshot/无标题1.png)
![](https://github.com/Xieyupeng520/CustomKeyboard/blob/master/CustomKeyBoard/assets/snapshot/无标题2.png)

二、准备工作
---
1.将项目CustomKeyboard解压导入workspace，检查一下项目是否是lib类型
<br>![](https://github.com/Xieyupeng520/CustomKeyboard/blob/master/CustomKeyBoard/assets/snapshot/无标题3.png)
<br><br>
2.打开自己的项目Properties，添加新的Library
<br>![](https://github.com/Xieyupeng520/CustomKeyboard/blob/master/CustomKeyBoard/assets/snapshot/无标题4.png)

三、使用方法
---
接下来就可以正常使用自定义键盘了。
###1.布局
在想要显示键盘的位置直接导入自定义布局，比如下图：
<br>![](https://github.com/Xieyupeng520/CustomKeyboard/blob/master/CustomKeyBoard/assets/snapshot/无标题5.png)

###2.代码
可以看出自定义键盘类型是CustomKeyboard，用findViewById取得该控件，然后设置监听器OnDpadCenterListener在监听器里完成自己的逻辑。
OnDpadCenterListener里面有三个监听事件，分别是onDpadCenter(String)获得点击的字符；onClearPressed()监听清除按钮被点击；onDeletePressed()监听删除按钮被点击。
<br>![](https://github.com/Xieyupeng520/CustomKeyboard/blob/master/CustomKeyBoard/assets/snapshot/无标题6.png)

<br>以下为SmartMedia使用示例及效果图：
<br>![](https://github.com/Xieyupeng520/CustomKeyboard/blob/master/CustomKeyBoard/assets/snapshot/无标题7.png)
<br>![](https://github.com/Xieyupeng520/CustomKeyboard/blob/master/CustomKeyBoard/assets/snapshot/无标题8.png)

四、可能出现的错误及解决办法
---
1.如果报错ViewPager找不到或者android-support-v4找不到的话。
可能是两个项目都包含了android-support-v4.jar，去CustomKeyboard下把lib里的android-support-v4.jar删除即可。
注：在CustomKeyboard项目未被设置为lib项目且未被删除android-support-v4.jar时是可以直接运行看效果的。
<br><br>
2.如果报错资源文件找不到，比如说string-array找不到。
可能是要把资源文件也加入到项目中，找到CustomKeyboard项目，把values下的红框内文件拷贝到你项目的values包内即可
<br>![](https://github.com/Xieyupeng520/CustomKeyboard/blob/master/CustomKeyBoard/assets/snapshot/无标题9.png)

<p><p><p>有任何问题，请反馈给我，谢谢！
<br>另外，在[我的博客](http://blog.csdn.net/xieyupeng520?viewmode=contents)中有详细描述该控件的构造过程:
<br>[《Android快速自定义控件+实战演示（一）新手进阶必看！》](http://blog.csdn.net/xieyupeng520/article/details/46481183)
<br>[《Android快速自定义控件+实战演示（二）组合自定义view+回调》](http://blog.csdn.net/XieYupeng520/article/details/46585295)
<br>[《Android快速自定义控件+实战演示（三）完整键盘和组合回调！》](http://blog.csdn.net/XieYupeng520/article/details/46659817)
