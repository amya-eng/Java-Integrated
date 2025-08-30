JDBC缺点：
通过set 方法手动设置参数，非常繁琐。
从数据库取得数据之后，需要手动封装数据成为对象。
存在较多的硬编码：注册驱动获取连接时url,name,passwd等的填写；SQL语句都是硬编码。

提出MyBatis持久层框架，为了简化JDBC开发。

MyBatis配置流程：
1. 导入mysql-connector-java和mybatis坐标
2. 在java同级目录resources/下编写mybatis-config.xml文件，配置数据库连接的environment,dataSource,mappers。mappers中用包扫描方式，将所有的Mapper接口和xml映射文件都注册进来。
3. 在resources.com.zzs.mapper目录下编写UserMapper.xml文件，配置namespace和id名（函数名）。
4. 在java.com.zzs.mapper目录下编写UserMapper接口，抽象方法与UserMapper.xml里面的id名对应。 
5. 编写相应的包装类。

注意：UserMapper.xml的文件层次结构必须与UserMapper接口的一致。

添加sql查询功能的时候，可以自顶向下添加，用到什么函数，就添加什么函数。IDE里有自动补全的功能擅用。
