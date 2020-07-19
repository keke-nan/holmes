package com.holmes.hoo.server;

import java.util.Map;

/**
 * @Description
 * @Author keke
 * @Date 2020/6/21  15:47
 */
public interface UserService {

    /**
     * @Description 用户注册
     * @Date 2020/6/21  19:03
     * @Param
     */
    boolean userRegist(String userName, String password, String phone, String email, String code);
    /**
     * @Description 用户登录
     * @Date 2020/6/21  21:18
     * @Param
     */
    boolean userLogin(String account, String password);
    /**
     * @Description 修改用户密码
     * @Date 2020/6/21  22:27
     * @Param
     */
    boolean updatePwd(String account, String password, String newPwd);
    /**
     * @Description 查询用户信息
     * @Date 2020/6/21  22:48
     * @Param
     */
    Map<String,Object> queryUser(String account);
    /**
     * @Description 删除用户
     * @Date 2020/6/21  22:48
     * @Param
     */
    boolean deleteUser(String account);
}
