package cn.pri.smilly.springh2mybatis.domain.po;

import cn.pri.smilly.common.domain.BaseBean;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserPo extends BaseBean {
    private Integer id;
    private String avatar;
    private String username;
    private String password;
    private String salt;
    private String name;
    private Date birthday;
    private Integer sex;
    private String email;
    private String phone;
    private Integer status;
    private Date createTime;
    private Date updateTime;
}
