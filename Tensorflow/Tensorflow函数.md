# Tensorflow函数用法（持续扩充）
## 1. tf.clip\_by\_value  
`tf.clip\_by\_value(v,min,max)`:  
给定一个张量v，将张量v中地每一个元素压缩到[min,max]的值域内。（小于min的置为min，大于max的置为max）。
## 2. tf.reduce\_mean  
沿着张量的指定的轴（某一维度），计算张量中元素的平均值。 

	#Computes the mean of elements across dimensions of a tensor
	def reduce_mean(input_tensor,
		                axis=None,
		                keepdims=None,
		                name=None,
		                reduction_indices=None,
		                keep_dims=None):  

**Args**:  
> &ensp;&ensp;_ **input\_tensor** : The tensor to reduce. Should have numeric type.  
> &ensp;&ensp;_**axis** : The dimensions to reduce. If `None` (the default), reduces all dimensions.  Must be in the range `[-rank(input_tensor), rank(input_tensor)]`.  
> &ensp;&ensp;_ **keepdims** : If true, retains reduced dimensions with length 1.  
> &ensp;&ensp;_ **name** : A name for the operation (optional).  
> &ensp;&ensp;_ **reduction\_indices** : The old (deprecated) name for axis.   
> &ensp;&ensp;_ **keep_dims** : Deprecated alias for `keepdims`.

**Returns:**  
&ensp;&ensp;The reduced tensor.

	  x = tf.constant([1, 0, 1, 0])  
	  tf.reduce_mean(x)  # 0  
	  y = tf.constant([1., 0., 1., 0.])  
	  tf.reduce_mean(y)  # 0.5

	  x = tf.constant([[1., 1.], [2., 2.]])
	  tf.reduce_mean(x)  # 1.5
	  tf.reduce_mean(x, 0)  # [1.5, 1.5],以横轴为基准，对横轴每一维所包含的列元素求平均。简单来说，对行(第0维）做压缩。
	  tf.reduce_mean(x, 1)  # [1.,  2.]，压缩列（第1维）。

## 3. cross\_entropy(交叉熵)  

[Tensorflow四种交叉熵函数](https://www.jianshu.com/p/cf235861311b)  

* tf\.nn\.sigmoid\_cross\_entropy\_with\_logits  
* tf\.nn\.softmax\_cross\_entropy\_with\_logits  
* tf\.nn\.sparse\_softmax\_cross\_entropy\_with\_logits  
* tf\.nn\.weighted\_cross\_entropy\_with\_logits  

## 4. tf\.matmul(v1,v2):  
矩阵相乘，与\*不同。
\*的结果为每个元素对应位置上的乘积  
`matmul`为矩阵相乘  
## 5. tf\.where/tf.greater  
	import tensorflow as tf 
	v1=tf.constant([1.,2.,3.]) 
	v2=tf.constant([3.,1.,4.]) 
	with tf.Session() as sess:
	    Great=tf.greater(v1,v2)
	    print (sess.run(Great))
	    #[False  True False]
	    Where=tf.where(Great,v1,v2)
	    print(Where)
	    #Tensor("Select:0", shape=(3,), dtype=float32)
	    print(sess.run(Where))
	    #[ 3.  2.  4.]

## 6. tf\.train\.exponential\_decay:  
	#Applies exponential decay to the learning rate.
	def exponential_decay(learning_rate,
	                      global_step,
	                      decay_steps,
	                      decay_rate,
	                      staircase=False,
	                      name=None):  
Returns:  
&ensp;&ensp;The function returns the decayed learning rate.  It is computed as:

	  decayed_learning_rate = learning_rate *
	                          decay_rate ^ (global_step / decay_steps)  
Args:  

* learning_rate: A scalar `float32` or `float64` `Tensor` or a Python number.  The initial learning rate.  
* global_step: A scalar `int32` or `int64` `Tensor` or a Python number. Global step to use for the decay computation.  Must not be negative.  
* decay_steps: A scalar `int32` or `int64` `Tensor` or a Python number. Must be positive.  See the decay computation above.  
* decay_rate: A scalar `float32` or `float64` `Tensor` or a Python number.  The decay rate. staircase: Boolean.  If `True` decay the learning rate at discrete intervals  
* name: String.  Optional name of the operation.  Defaults to 'ExponentialDecay'.  
## 7. tf\.argmax:  
	#Returns the index with the largest value across dimensions of a tensor
	def argmax(input,
	           axis=None,
	           name=None,
	           dimension=None,
	           output_type=dtypes.int64):
说明：`tf\.argmax(V,1)`:  
&ensp;V代表一个张量1表示选取最大值的操作仅在第1个维度上进行，即只在每一行选取最大值对应的**下标**。  
实例：  

	import tensorflow as tf 
	V=tf.constant([[1,2,3],[2,3,4]])
	Max=tf.argmax(V,1)
	print(Max.eval(session=tf.Session()))
	#[2 2] 结果存储的是每一行的最大值对应的下标值
	Max2=tf.argmax(V,0)
	print(Max2.eval(session=tf.Session()))
	#[1 1 1] 结果存储的是每一列的最大值对应的下标值
