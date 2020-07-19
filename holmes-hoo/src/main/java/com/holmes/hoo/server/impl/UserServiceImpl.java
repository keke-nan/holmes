package com.holmes.hoo.server.impl;

import com.holmes.hoo.constant.Constant;
import com.holmes.hoo.constant.ErrorCode;
import com.holmes.hoo.constant.UnprocessableException;
import com.holmes.hoo.mapper.UserMapper;
import com.holmes.hoo.model.BaseEntityUtil;
import com.holmes.hoo.model.User;
import com.holmes.hoo.server.UserService;
import com.holmes.hoo.utils.SaltUtil;
import com.holmes.hoo.utils.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author keke
 * @Date 2020/6/21  15:47
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    /**
     * @Description 注册用户信息
     * @Date 2020/6/21  19:03
     * @Param
     */
    @Override
    public boolean userRegist(String userName, String password, String phone, String email, String code) {
        LOGGER.info("{},userName:{}, password:{}, phone:{}, email:{}, code:{}",
                Thread.currentThread().getStackTrace()[1].getMethodName(), userName, password, phone, email, code);
        if (userMapper.queryUserByName(userName) != null) {
            throw new UnprocessableException(ErrorCode.USER_NAME_EXISTS);
        }
        if (!UserUtil.isPhoneLegal(phone)) {
            throw new UnprocessableException(ErrorCode.PHONE_ILLEGAL);
        }
        if (!UserUtil.checkEamil(email)) {
            throw new UnprocessableException(ErrorCode.EMAIL_ILLEGAL);
        }
        String salt = SaltUtil.newSalt();
        User user = BaseEntityUtil.getInstance(User.class);
        user.setUserName(userName);
        user.setSalt(salt);
        user.setPassword(SaltUtil.getHashedKey(password, salt));
        user.setStatus(Constant.OFF_LINE);
        user.setEmail(email);
        user.setPhone(phone);

        userMapper.save(user);
        return true;
    }

    /**
     * @Description 用户登录
     * @Date 2020/6/21  22:05
     * @Param
     */
    @Override
    public boolean userLogin(String account, String password) {
        LOGGER.info("{},account is {}, password :{}", Thread.currentThread().getStackTrace()[1].getMethodName(), account, password);
        User user = checkUser(account);
        String pwd = SaltUtil.getHashedKey(password, user.getSalt());
        if (!user.getPassword().equals(pwd)) {
            throw new UnprocessableException(ErrorCode.PASSWORD_ERROR);
        }
        return true;
    }

    /**
     * @Description 修改用户密码
     * @Date 2020/6/21  22:28
     * @Param
     */
    @Override
    public boolean updatePwd(String account, String password, String newPwd) {
        LOGGER.info("{},account is {}, password :{}, newPwd:{}", Thread.currentThread().getStackTrace()[1].getMethodName(), account, password, newPwd);
        User user = checkUser(account);
        String pwd = SaltUtil.getHashedKey(password, user.getSalt());
        if (!user.getPassword().equals(pwd)) {
            throw new UnprocessableException(ErrorCode.PASSWORD_ERROR);
        }
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userName", account);
        paramMap.put("password", newPwd);
        userMapper.updatePwd(paramMap);
        return true;
    }

    /**
     * @Description 查询用户信息
     * @Date 2020/6/21  22:51
     * @Param
     */
    @Override
    public Map<String, Object> queryUser(String account) {
        LOGGER.info("{},account is {}", Thread.currentThread().getStackTrace()[1].getMethodName(), account);
        checkUser(account);
        return userMapper.queryUser(account);
    }

    /**
     * @Description 删除用户
     * @Date 2020/6/21  22:56
     * @Param
     */
    @Override
    public boolean deleteUser(String account) {
        LOGGER.info("{},account is {}", Thread.currentThread().getStackTrace()[1].getMethodName(), account);
        checkUser(account);
        userMapper.deleteUser(account);
        return true;
    }

    /**
     * @Description 校验用户是否存在
     * @Date 2020/6/21  23:03
     * @Param
     */
    private User checkUser(String account) {
        User user = userMapper.queryUserByName(account);
        if (user == null) {
            throw new UnprocessableException(ErrorCode.USER_NOT_EXISTS);
        }
        return user;
    }
}
