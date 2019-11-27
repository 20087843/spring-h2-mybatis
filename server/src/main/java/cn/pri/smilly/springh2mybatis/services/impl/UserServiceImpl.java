package cn.pri.smilly.springh2mybatis.services.impl;

import cn.pri.smilly.common.domain.ListWrapper;
import cn.pri.smilly.common.domain.PageVo;
import cn.pri.smilly.common.domain.PageWrapper;
import cn.pri.smilly.common.mybatis.BaseMapper;
import cn.pri.smilly.common.rest.RestResult;
import cn.pri.smilly.common.service.BaseService;
import cn.pri.smilly.springh2mybatis.domain.dto.UserDto;
import cn.pri.smilly.springh2mybatis.domain.po.UserPo;
import cn.pri.smilly.springh2mybatis.domain.vo.UserVo;
import cn.pri.smilly.springh2mybatis.mapper.UserMapper;
import cn.pri.smilly.springh2mybatis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseService<UserPo, Integer> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    protected BaseMapper<UserPo, Integer> getMapper() {
        return userMapper;
    }

    @Override
    public RestResult<UserVo> getUser(Integer id) {
        UserPo user = find(id);
        return RestResult.success(user.convert(UserVo.class));
    }

    @Override
    public RestResult<PageVo> getUsers(UserDto user) {
        List<UserPo> list = list(user, user.getPage());
        return RestResult.success(PageWrapper.wrap(list).convert(UserVo.class));
    }

    @Override
    public RestResult<PageVo> getUsers() {
        List<UserPo> list = list(null);
        return RestResult.success(ListWrapper.wrap(list).convert(UserVo.class));
    }
}
