## Tensorflow模型持久化  
### 1. 保存两个变量和的模型  
	import tensorflow as tf
	v1 = tf.Variable(tf.random_normal([1], stddev=1, seed=1))
	v2 = tf.Variable(tf.random_normal([1], stddev=1, seed=1))
	result = v1 + v2
	
	init_op = tf.global_variables_initializer()
	#声明tf.train.Saver类用于保存模型
	saver = tf.train.Saver()
	
	with tf.Session() as sess:
	    sess.run(init_op)
	    saver.save(sess, "Saved_model/model.ckpt")  
模型保存（Tensorflow会将计算图的结构和图上参数取值分别保存）：  

* model\.ckpt\.meta: 保存Tensorflow计算图的结构。  
* model\.ckpt: 保存Tensorflow程序中每一个变量的取值。  
* checkpoint： 保存目录下所有的模型文件列表。  
## 2. 加载保存的模型  
	v1 = tf.Variable(tf.random_normal([1], stddev=1, seed=1))
	v2 = tf.Variable(tf.random_normal([1], stddev=1, seed=1))
	result = v1 + v2
	
	init_op = tf.global_variables_initializer()
	#声明tf.train.Saver类用于保存模型
	saver = tf.train.Saver()
	with tf.Session() as sess:
	    saver.restore(sess, "Saved_model/model.ckpt")
	    print sess.run(result)  
注：加载模型的代码和保存模型的代码基本一样。  
&ensp;&ensp;&ensp;&ensp;两端代码中，唯一不同的是，在加载模型的代码中没有运行变量的初始话过程，而是将变量的值通过已经保存的模型加载进来。  
## 3. 直接加载持久化的图  
	saver = tf.train.import_meta_graph("Saved_model/model.ckpt.meta")
	v3 = tf.Variable(tf.random_normal([1], stddev=1, seed=1))
	
	with tf.Session() as sess:
	    saver.restore(sess, "Saved_model/model.ckpt")
	    print sess.run(v1) 
	    print sess.run(v2) 
	    print sess.run(v3) 