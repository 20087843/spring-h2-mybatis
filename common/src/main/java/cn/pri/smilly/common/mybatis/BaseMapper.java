package cn.pri.smilly.common.mybatis;

import cn.pri.smilly.common.domain.BaseBean;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper<D extends BaseBean, PK extends Serializable> {

    D findByPk(PK pk);

    List<D> findByCondition(BaseBean d);

    void save(D d);

    void batchSave(List<D> list);

    void update(D d);

    void batchUpdate(List<D> list);

    void deleteByPk(PK pk);

}
