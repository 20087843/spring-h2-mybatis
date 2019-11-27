package cn.pri.smilly.springh2mybatis.domain.po;

import cn.pri.smilly.common.domain.BaseBean;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RolePo extends BaseBean {
    private Integer id;
    private String name;
    private String value;
    private String tips;
    private Date createTime;
    private Date updateTime;
    private Integer status;
}
