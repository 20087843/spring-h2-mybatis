package cn.pri.smilly.springh2mybatis.domain.dto;

import cn.pri.smilly.common.domain.BaseBean;
import cn.pri.smilly.common.domain.PageDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDto extends BaseBean {
    private String username;
    private String salt;
    private String name;
    private Date birthday;
    private Integer sex;
    private String email;
    private String phone;
    private Integer status;
    private PageDto page;
}
