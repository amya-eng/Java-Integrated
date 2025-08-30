package com.zzs;

import com.zzs.mapper.UserMapper;
import com.zzs.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisDemo {

    public static void main(String[] args) throws IOException {
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取Mapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 4. 执行sql
        List<User> users = userMapper.selectAll();             // 这个方法在UserMapper.xml中已经写好
        System.out.println("-------------------------查询结果-----------------------------");
        System.out.println(users);

        System.out.println("-------------------------查询结果-----------------------------");
        User one = userMapper.selectById(1);
        System.out.println(one);

        System.out.println("-------------------------插入操作-----------------------------");
        try{
            // 默认关闭了事务的自动提交
            int row = userMapper.insertOne(new User(5,"zzs","root", "男","杭州"));
            if(row == 1) {
                System.out.println("插入成功");
            } else {
                System.out.println("插入失败");
            }
            // 提交事务
            sqlSession.commit();
        } catch(Exception e) {
            // 回滚事务
            sqlSession.rollback();
            System.out.println(e.getStackTrace());
        } finally {
            sqlSession.close();
        }
        //4. 释放资源
        sqlSession.close();
    }
}
