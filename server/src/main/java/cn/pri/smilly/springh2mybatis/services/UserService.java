package cn.pri.smilly.springh2mybatis.services;

import cn.pri.smilly.common.domain.PageVo;
import cn.pri.smilly.common.rest.RestResult;
import cn.pri.smilly.springh2mybatis.domain.dto.UserDto;
import cn.pri.smilly.springh2mybatis.domain.vo.UserVo;

public interface UserService {

    RestResult<UserVo> getUser(Integer id);

    RestResult<PageVo> getUsers(UserDto user);

    RestResult<PageVo> getUsers();
}
