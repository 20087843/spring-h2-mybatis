package cn.pri.smilly.springh2mybatis.domain.vo;

import cn.pri.smilly.common.domain.BaseBean;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleVo extends BaseBean {
    private String name;
    private String value;
    private String tips;
}
