package com.zzs.mapper;

import com.zzs.pojo.User;
import org.apache.ibatis.annotations.Insert;

import java.util.List;


public interface UserMapper {
    List<User> selectAll();
    User selectById(int id);

    // 注解开发
    @Insert("insert into tb_user(id,username, password, gender, addr) values(#{id},#{username},#{password},#{gender},#{addr})")
    int insertOne(User zzs);               // 返回受影响的行数，为1说明插入成功。
}
