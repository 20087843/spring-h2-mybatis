package cn.pri.smilly.springh2mybatis.controller;

import cn.pri.smilly.common.domain.PageVo;
import cn.pri.smilly.common.rest.RestResult;
import cn.pri.smilly.springh2mybatis.domain.dto.UserDto;
import cn.pri.smilly.springh2mybatis.domain.vo.UserVo;
import cn.pri.smilly.springh2mybatis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public RestResult<UserVo> getUser(@PathVariable @NotNull Integer id) {
        return userService.getUser(id);
    }

    @GetMapping("/all")
    public RestResult<PageVo> getAll(){
        return userService.getUsers();
    }

    @GetMapping
    public RestResult<PageVo> getUsers(UserDto user) {
        return userService.getUsers(user);
    }
}
