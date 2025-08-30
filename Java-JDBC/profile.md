前置知识：
数据库驱动，其实就是JDBC接口的实现类。 JDBC使得Java代码开发不管底层的数据库实现。DataSource是数据库连接池标准接口。常见的数据库连接池实现有DBCP, C3P0, BoneCP, Druid等。

JDBC使用步骤：
1. maven创建项目
2. 导入mysql-connector-java坐标
3. 使用即可

Druid连接池使用步骤：
1. maven创建项目
2. 导入druid坐标
3. 创建druid.properties文件
4. 使用即可

文件总览：
JdbcDemo.java： JDBC基础语法
JdbcDataSource.java: 使用JDBC连接池
