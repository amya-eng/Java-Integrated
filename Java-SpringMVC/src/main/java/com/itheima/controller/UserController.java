package com.itheima.controller;

import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLOutput;

//2. 定义bean
@Controller
public class UserController {

    // 3. 设置访问路径
    @RequestMapping("/save")
    // 4. 设置当前操作的返回值类型
    @ResponseBody
    public String save(){
        System.out.println("user save...");
        return "{'module':'springmvc'}";
    }
}
