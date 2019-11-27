package cn.pri.smilly.common.domain;


import cn.pri.smilly.common.core.ConvertUtil;
import cn.pri.smilly.common.core.Convertable;

import java.io.Serializable;

public abstract class BaseBean implements Convertable<BaseBean>, Serializable {

    @Override
    public <T extends BaseBean> T convert(Class<T> clazz) {
        return ConvertUtil.bean2bean(this, clazz);
    }

    public String toJson() {
        return ConvertUtil.bean2json(this);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " : " + toJson();
    }

}
