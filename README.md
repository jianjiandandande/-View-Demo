##自定义View
* 系统中内置的一些视图控件，不能够满足我们开发的需要，所以在这种情况下，我们必须去使用自定义View。
###自定义View的分类
* 1.继承View重写onDraw()方法：这种方法主要用于实现一些不规则的效果，一般需要重写onDraw()方法，采用这种方式需要自己支持wrap_content,并且padding也需要自己处理(直接继承View的自定义控件需要重写onMeasue()方法并设置wrap_content时的自身大小，否则在布局中使用wrap_content就相当于使用match_parent)
* 2.继承ViewGroup派生特殊的Layout:这种方法主要用于实现自定义的布局，采用这种方式稍微复杂一些，需要合理地处理ViewGroup的测量、布局这两个过程，并同时处理子元素的测量和布局过程。 
* 继承特定的View(如TextView):
* 继承特定的ViewGroup(如LinearLayout):

**View的三大流程：**测量流程、布局流程、绘制流程。
>其中：
* measure用来测量View的宽和高；
* layout用来确定View在父容器中的放置位置；
* draw负责将View绘制在屏幕上。
###自定义View须知
* 1.让View支持wrap_content
* 2.如果有必要，让你的View支持padding 
* 3.尽量不要再View中使用Handler，没必要
* 4.View中如果有线程或者动画，需要及时停止，参考View#onDetachedFromWindow
* 5.View带有嵌套情形时，需要处理好滑动冲突。

####自定义View(一般的View)的一般步骤
* 创建一个类(View类)继承于View;
* 实现它的钱三个构造方法；
* 重写onDraw()方法；
* 在布局中引入自定义View；
* 在自定义View的类中重写onMeasure()方法，适配wrap_content；
* 在onDraw()中去修改padding相关的设置，使自定义View支持padding；
* 写attr.xml文件，此文件中去设置自定义View的一些属性
* 在自定义属性的类中的有三个参数的构造方法中去解析自定义属性的值并做相应的处理。
* 运行程序，有没有很激动！！！
