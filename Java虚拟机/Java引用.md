# Java引用

四种：
强引用、软件用、弱引用和虚引用。

## 强引用
定义： 创建一个对象，并把一个对象赋值给一个引用变量。
 ` String str="Hello"; `</p>
其中，str即为强引用。

* 强引用有引用变量指向时，永远不会被GC回收。（JVM即使抛出OOM错误，也不会回收这种对象）。 
- 想中断强引用和某个对象之间的联系，可以显示地将引用赋值为null，这样，GC就会适时回收该对象。

## 软引用(SoftReference, java.lang.ref.SoftReference)
* 如果一个对象具有软引用，内存空间足够，GC就不会回收它。
* 如果内存空间不足，这些对象就会被GC回收。只要GC没有回收它，该对象就可以被程序使用
* `SoftReference`的一个实例保存一个Java对象的软引用。在GC回收Java对象前，`SoftReference`类的`get()`方法返回Java对象的强引用。GC回收对象后，则返回`null`。 </p>

	
		MyObject ref=new MyObject();  
		SoftReference reference=new SoftReference(ref);

上述例子中，MyObject对象有两个引用路径，ref为强引用，reference为软引用。  
此时，此对象是强可及对象，经过`ref=null`，此对象成为软引用对形象。
## 弱引用(WeakReference, java.lang.ref.WeakReference)
* 用来描述非必需对象。JVM无论内存是否足够，都会回收被弱引用关联的对象。  
`WeakReference &lt;Person&gt; ref=new WeakReference&lt;Person&gt;(new Person("YI",20));`  
注：只要JVM进行GC，被弱引用关联的对象，都会被回收，但如果同时存在强引用与之关联，则GC不会回首该对象（软引用也是如此）。  
## 虚引用(PhantomReference,java.lang.ref.PhantomReference)  
* 虚引用与软、弱引用不同，它不影响对象的生命周期。其在任何时候都能被GC回收。  
* 虚引用必须和引用队列关联使用。当GC回收一个对象时，如果发现它有虚引用，则将虚引用加入到与之关联的引用队列中。程序可以通过判断引用队列中是否已经加入了虚引用来了解被引用对象是否需要垃圾回收。  

		ReferenceQueue&lt;String&gt; queue=new ...;  
		PhantomReference&lt;String&gt; pr=new ...（new String ("hello"),queue);

