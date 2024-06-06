# SSH_Employee_Management_System

## 背景
慕课网《基于SSH实现员工管理系统之案例实现篇》的完整实现代码，主要包括部门管理和员工管理两部分。项目改为使用Maven进行配置，并增加了用于权限控制的过滤器和EasyUI时间插件。  
更新了jdbc.properties文件：MySQL 8.0 以下版本使用com.mysql.jdbc.Driver；MySQL 8.0 以上使用com.mysql.cj.jdbc.Driver。

## 配置
1. 创建数据库，与jdbc.properties中保持一致。
2. 项目部署到Tomcat完成后，启动服务，数据库中自动建表成功。
3. 访问 http://localhost:8080 ；主页正常显示。（需配置项目Context root或修改tomcat Web Modules中的path值为“/” ，可不带项目名直接访问）
4. 在数据库中添加一条员工的用户名和密码信息，在主页正常登陆即可。

## 版权
原版为慕课网课程 https://www.imooc.com/learn/679    
在原版项目的基础上进行改进。
