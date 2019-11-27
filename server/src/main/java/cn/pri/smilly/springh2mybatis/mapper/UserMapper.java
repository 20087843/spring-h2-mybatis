package cn.pri.smilly.springh2mybatis.mapper;

import cn.pri.smilly.common.mybatis.BaseMapper;
import cn.pri.smilly.springh2mybatis.domain.po.UserPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<UserPo, Integer> {

}
