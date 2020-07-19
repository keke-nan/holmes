package com.holmes.hoo.controller;

import com.holmes.hoo.constant.RestResult;
import com.holmes.hoo.server.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Description
 * @Author keke
 * @Date 2020/6/21  14:59
 */
@Controller
@RequestMapping(value = "/user")
@Api(value = "用户管理",tags = "UserApi")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户注册", notes = "by hoo")
    @PostMapping("/regist")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "账号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "phone", value = "手机号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "email", value = "邮箱", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "code", value = "验证码", required = true, dataType = "String", paramType = "query")
    })
    @ApiResponses(value={
          /*  @ApiResponse(code=100001,message="账号已存在"),
            @ApiResponse(code=100002,message="手机号不合法"),
            @ApiResponse(code=100003,message="邮箱不合法")*/
    })
    @ResponseBody
    public RestResult<Boolean> userRegist(
            @RequestParam(value = "userName") String userName,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "phone") String phone,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "code") String code){
        return new RestResult<>(userService.userRegist(userName, password, phone, email, code));
    }

    @ApiOperation(value = "用户登录", notes = "by hoo")
    @PostMapping("/login")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "邮箱/用户名/手机号", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "string", paramType = "query")
    })
    @ResponseBody
    public RestResult<Boolean> userLogin(
            @RequestParam(value = "account") String account,
            @RequestParam(value = "password") String password){
        return new RestResult<>(userService.userLogin(account, password));
    }

    @ApiOperation(value = "修改用户密码", notes = "by hoo")
    @PutMapping("/update_password")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "用户名", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "旧密码", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "newPwd", value = "新密码", required = true, dataType = "string", paramType = "query")
    })
    @ResponseBody
    public RestResult<Boolean> updatePwd(
            @RequestParam(value = "account") String account,
            @RequestParam(value = "newPwd") String newPwd,
            @RequestParam(value = "password") String password){
        return new RestResult<>(userService.updatePwd(account, password, newPwd));
    }

    @ApiOperation(value = "查询用户信息", notes = "by hoo")
    @GetMapping("/user")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "用户名", required = true, dataType = "string", paramType = "query")
    })
    @ResponseBody
    public RestResult<Map<String,Object>> queryUser(
            @RequestParam(value = "account") String account){
        return new RestResult<>(userService.queryUser(account));
    }

    @ApiOperation(value = "删除用户", notes = "by hoo")
    @DeleteMapping("/user")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "用户名", required = true, dataType = "string", paramType = "query")
    })
    @ResponseBody
    public RestResult<Boolean> deleteUser(
            @RequestParam(value = "account") String account){
        return new RestResult<>(userService.deleteUser(account));
    }



}
