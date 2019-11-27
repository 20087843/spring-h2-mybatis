package cn.pri.smilly.springh2mybatis.domain.dto;

import cn.pri.smilly.common.domain.BaseBean;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuDto extends BaseBean {
    private String code;
    private String pCode;
    private String pId;
    private String name;
    private Integer isMenu;
    private Integer level;
    private Integer status;
}
