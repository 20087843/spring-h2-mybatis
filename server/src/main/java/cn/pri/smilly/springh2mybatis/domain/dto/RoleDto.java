package cn.pri.smilly.springh2mybatis.domain.dto;

import cn.pri.smilly.common.domain.BaseBean;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RoleDto extends BaseBean {
    private String name;
    private Integer status;
}
