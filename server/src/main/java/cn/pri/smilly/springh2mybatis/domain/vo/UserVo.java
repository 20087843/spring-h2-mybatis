package cn.pri.smilly.springh2mybatis.domain.vo;

import cn.pri.smilly.common.domain.BaseBean;
import cn.pri.smilly.common.domain.PageDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserVo extends BaseBean {
    private String username;
    private String salt;
    private String name;
    private Date birthday;
    private Integer sex;
    private String email;
    private String phone;
    private PageDto page;
}
