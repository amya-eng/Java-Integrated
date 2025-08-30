package com.zzs.jdbc;

import java.sql.*;

// JDBC基础语法
public class JdbcDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        Connection conn = null;
        try{
            // 1. 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // test数据库-users表
            // (id int, name varchar(10))
            // 2. 获取连接
            String url = "jdbc:mysql://localhost:3306/test?useSSL=false";         // 后缀数据库
            String user = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, user, password);

            //3、获取数据库操作对象（statement专门执行sql语句）
            stmt = conn.createStatement();

            String sql = "select * from users;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                System.out.println(id + " " + name);
            }

            // 4. 防止SQL注入
            int id = 1;
            String name = "zzs";
            String sql1 = "select * from users where id=? and name =?";
            PreparedStatement pstmt = conn.prepareStatement(sql1);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            ResultSet rs1 = pstmt.executeQuery();
            if(rs1.next()) {
                System.out.println("it exist!");
            }else {
                System.out.println("it not exist!");
            }



            // 5. 执行事务
            try{
                // 开启事务
                conn.setAutoCommit(false);
                String sql2 = "insert into users values(4, 'www');";
                String sql3 = "update users set name = 'ddd' where id = 4;";
                int count = stmt.executeUpdate(sql2);
                int count2 = stmt.executeUpdate(sql3);
                System.out.println(count +  "、" + count2);
                System.out.println("affected");
                // 提交事务
                conn.commit();
            }catch (Exception e) {
                // 回滚事务
                conn.rollback();
                e.printStackTrace();
            }

        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if(stmt != null) {
                stmt.close();
            }
            if(conn != null) {
                conn.close();
            }
        }

    }
}
