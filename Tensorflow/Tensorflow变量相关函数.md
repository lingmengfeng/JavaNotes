## Tensorflow随机数生成函数  
* tf\.random\_normal  
  `tf.random_normal([2,3],stddev=2,seed=1)`
* tf\.truncated\_normal  
* tf\.random\_uniform  
* tf\.random\_gamma Gamma分布  
## Tensorflow常数生成函数  
* tf\.zeros  
  `tf.zeros([2,3],int32)`
* tf\.ones  
  `tf.ones([2,3],9)`
* tf\.fill  
  `tf.fill([2,3],int32)`
* tf\.constant  
  `tf.constant([1,2,3])`
## Tensorflow变量初始化函数  
* tf\.constant\_initializer  
* tf\.random\_normal\_initializer 正态分布  
* tf\.truncated\_normal\_initializer 正态分布  
* tf\.random\_uniform\_initializer 平均分布  
* tf\.uniform\_unit\_scaling\_initializer 平均分布  
* tf\.zeros\_initializer  
* tf\.ones\_initializer  
注：`Tensorflow`中提供的`initializer`函数和随机数/常量生成函数大部分是一一对应的。  
## tf\.get\_variable/tf\.Variable:  
* tf\.get\_variable:创建、获取变量,其中，变量名称是必填参数  
  `tf.get_variable("v",shape=[1],initializer=tf.constant_initializer(1.0))`
* tf\.Variable: 变量名称是可选项  
  `tf.Variable(tf.constant(1.0,shape=[1]),name="v")`