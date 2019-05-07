# Java虚拟机运行时数据区


---
### 程序计数器（Program Counter Register）：

 - 线程私有
 - 唯一一块不规定OutOfMemoryError的内存区域
 - 当前线程所执行的字节码的行号指示器
 - 执行Java方法时，记录虚拟机字节码指令的地址
 - 执行Native方法时，值为空（Undefined)

### 虚拟机栈（Virtual Machine Stacks):

- 线程私有
- 描述**Java方法执行**的内存模型（Java Memory Model, JMM），即当Java方法执行时，Java虚拟机会同时创建一个栈帧（Stack Frame），用于存储局部变量表、操作数栈、[动态链接](https://blog.csdn.net/championhengyi/article/details/78760590)、方法出口等   
- 每个Java方法从调用到执行完成的过程，可以看作栈帧在虚拟机中入栈到出栈的过程
- 栈的最大请求深度大于虚拟机允许深度时，抛出StackOverflowError异常
- 允许动态扩展时，无法申请道足够内存，抛出OutOfMemoryError异常

### 本地方法栈（Native Method Stacks）：

- 线程私有
- 与虚拟机栈很像，虚拟机栈为Java方法服务，而本地方法栈为虚拟机执行的[Native方法](https://blog.csdn.net/abcyyjjkk/article/details/70240366)服务


### Java堆（Java Heap）：
- 线程共享
- 虚拟机中内存最大的区域
- 虚拟机启动时创建
- 存储对象实例，几乎所有的对象实例都由Java堆进行内存分配
- 既然管理内存分配，那也就跟内存回收相关：垃圾收集器的主要管理区域，又名GC堆（Garbage Collected Heap）
- 若堆中没有内存完成实例分配，且不能进行扩展时，抛出OutOfMemoryError异常

### 方法区（Method Area）：
既然有对象实例存放的区域，则有对应相关信息存放的区域

- 线程共享
- 存放虚拟机加载的类信息、常量、静态变量、即时编译器（JIT）编译后的代码等
- 被描述为Java堆的一个逻辑部分，又名Non-Heap
- 虚拟机方法区无法满足内存需求时，抛出OutOfMemoryError异常

### 运行时常量池（Runtime Constant Pool）：
- 方法区的一部分
- class（字节码）文件中有一部分为常量池（Constant Pool Table），其存储了编译期生成的各种[字面量](https://blog.csdn.net/u010850285/article/details/44152157)和[符号引用](https://blog.csdn.net/maerdym/article/details/8087620)，在类加载后，这些信息会进入方法区的运行时常量池存放。


##### 字面量（literal）和符号引用（Symbolic References）：
- 字面量接近于Java语言层面的常量概念，如文本字符串，声明为final的常量值等
- 符号引用属于编译原理方面的概念，包括三类常量：
 -- 类和接口的全限定名（Fully Qualified Name）
 -- 字段的名称和描述符（Descriptor）
 -- 方法的名称和描述符
