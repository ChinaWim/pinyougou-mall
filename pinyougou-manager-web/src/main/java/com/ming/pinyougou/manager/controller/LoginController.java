package com.ming.pinyougou.manager.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author m969130721@163.com
 * @date 18-10-31 上午9:23
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    /**
     * 获取登录的用户名
     * @return
     */
    @RequestMapping("/name")
    public Map name(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Map map = new HashMap();
        map.put("loginName",name);
        return map;
    }

}
