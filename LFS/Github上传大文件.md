#Windows下Github上传超过200MB文件（LFS)#


1. 在Repository目录上右击，选择**GIT Bash**
2. `git clone https://...`将库克隆到本地（可以克隆空库）
3. cd 库目录，进入本地库
4. 将要上传的文件全部拷贝到本地库中
5. 
![](https://i.imgur.com/oP6cvOs.png)
**PS:下载 *git-lfs.exe*文件，一起放到本地库中（如上图所示）**
5. `git init`初始化本地库
6. `git lfs install` 安装**Large File Storage(LFS)**工具
7. `git lfs track “*.jar” `定义***lfs***要追踪的文件类型
8. `git add .gitattributes` 生成对应文件
 ![](https://i.imgur.com/ldROYNG.png)
9. git add .  装载本地库(注意有个. )
![](https://i.imgur.com/fvV1iEh.png)
10. `git commit –m “commitInfo”`
![](https://i.imgur.com/ePKZ39L.png)
11. `git push –u origin master `
![](https://i.imgur.com/BxN49RL.png)

注： 如遇此错误：
![](https://i.imgur.com/YzH44SV.png)
可以尝试使用

`git config --global http.postBuffer 524288000	`
		
或者


> `env GIT_SSL_NO_VERIFY=true git clone https://...  ` 
> `git config http.sslVerify "false" `

![](https://i.imgur.com/uAoE65c.png)
![](https://i.imgur.com/sibwXJj.png)
![](https://i.imgur.com/5hDiqud.png)