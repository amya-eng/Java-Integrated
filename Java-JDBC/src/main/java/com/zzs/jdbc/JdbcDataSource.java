package com.zzs.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class JdbcDataSource {
    public static void main(String[] args) throws Exception{

        // 1. 定义配置文件

        // 2. 加载配置文件
        Properties prop = new Properties();
        System.out.println(System.getProperty("user.dir"));
        prop.load(new FileInputStream("src/druid.properties"));

        // 3. 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        // 4. 获取数据库连接
        Connection conn = dataSource.getConnection();
        System.out.println(conn);

    }
}
