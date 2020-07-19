package com.holmes.mapper;

import com.holmes.model.User;
import org.springframework.stereotype.Repository;
import java.util.Map;

/**
 * @Description
 * @Author keke
 * @Date 2020/6/21  18:06
 */
@Repository
public interface UserMapper {

    /**
     * @Description 保存用户信息
     * @Date 2020/6/21  18:15
     * @Param
     */
    Integer save(User user);
    /**
     * @Description 根据账户名查询用户
     * @Date 2020/6/21  18:07
     * @Param
     */
    User queryUserByName(String userName);
    /**
     * @Description 用户登录
     * @Date 2020/6/21  21:55
     * @Param
     */
    User userLogin(String account);
    /**
     * @Description 修改用户密码
     * @Date 2020/6/21  22:32
     * @Param
     */
    Integer updatePwd(Map<String, Object> paramMap);
    /**
     * @Description 查询用户信息
     * @Date 2020/6/21  22:57
     * @Param
     */
    Map<String,Object> queryUser(String account);
    /**
     * @Description 删除用户
     * @Date 2020/6/21  22:57
     * @Param
     */
    Integer deleteUser(String account);

}
