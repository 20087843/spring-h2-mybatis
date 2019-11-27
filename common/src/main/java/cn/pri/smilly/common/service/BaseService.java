package cn.pri.smilly.common.service;

import cn.pri.smilly.common.domain.BaseBean;
import cn.pri.smilly.common.mybatis.BaseMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.List;

public abstract class BaseService<D extends BaseBean, PK extends Serializable> {

    protected abstract BaseMapper<D, PK> getMapper();

    protected void save(D d) {
        getMapper().save(d);
    }

    protected void save(List<D> list) {
        getMapper().batchSave(list);
    }

    protected D find(PK id) {
        return getMapper().findByPk(id);
    }

    protected List<D> list(BaseBean d) {
        return getMapper().findByCondition(d);
    }

    protected List<D> list(BaseBean d, Object page) {
        Assert.notNull(page, "page info can not be null");
        PageHelper.startPage(page);
        return getMapper().findByCondition(d);
    }

    protected void update(D d) {
        getMapper().update(d);
    }

    protected void update(List<D> list) {
        getMapper().batchUpdate(list);
    }

    protected void delete(PK id) {
        getMapper().deleteByPk(id);
    }
}
