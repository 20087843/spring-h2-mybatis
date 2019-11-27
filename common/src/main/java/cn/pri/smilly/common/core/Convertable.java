package cn.pri.smilly.common.core;

import cn.pri.smilly.common.domain.BaseBean;

public interface Convertable<T> {

    <D extends BaseBean> T convert(Class<D> clazz);

}
