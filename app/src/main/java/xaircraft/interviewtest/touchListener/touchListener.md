touch事件的传递机制
================

>事件传递机制一般涉及到三个方法dispatchTouchEvent(），onInterceptTouchEvent() 和onTouchEvent()三个方法，  
其中onInterceptTouchEvent()是viewgroup组件特有的方法，不管是view还是viewgroup事件都是首先传入dispatchTouchEvent()
方法中的。在事件方法中，如果返回true代表消耗了事件，事件不再进行传递。如果返回false代表没有消耗事件


view 中：
----------
- touchListener会优先于touchEvent执行，根据源码显示只有当touchListener返回false时，才会调用touchEvent  

- touchEvent 事件一般包括 down move up ,一般都是连贯执行的如果只要其中一个事件返回FALSE(消耗了其中的一个事件)，  
那么后面的事件就不会再执行。

viewGroup 中：
------
- 事件会从viewgroup一直传递下去直到碰到最底端view，其实不管是view还是viewgroup都能都消耗事件
- 如果任何view（viewgroup 也是属于view）都没有消费掉事件的话，事件会由顶层view一直传递到底层view,  
再从底层view的onTouchEvent()方法一直网上传递上层view的onTouchEvent(),以此类推。如下图：  
![touch-one](https://github.com/ityulong/InterviewTest/blob/6f4dd22deacd983af5abcf6b193ce6f8df486f74/app/src/main/res/img/touch-one.png)  

- 即是因为viewgroup能够包含子view，所以有onInterceptTouchEven() 方法，所以能够对事件进行拦截，
当该方法返回true，代表事件在此viewgroup处进行了拦截，不能再下发事件。如下图：  
![touch-two](https://github.com/ityulong/InterviewTest/blob/6f4dd22deacd983af5abcf6b193ce6f8df486f74/app/src/main/res/img/touch-two.png)  

- 当消耗掉事件的时候，返回true(控件的点击事件是自动返回true的，自己监听的onTouchListener()返回的值是自己控制的)，这时候事件将不再往下传递，如图：  
![touch-three](https://github.com/ityulong/InterviewTest/blob/6f4dd22deacd983af5abcf6b193ce6f8df486f74/app/src/main/res/img/touch-three.png) 

