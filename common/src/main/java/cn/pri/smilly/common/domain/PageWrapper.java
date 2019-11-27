package cn.pri.smilly.common.domain;

import cn.pri.smilly.common.core.Convertable;
import com.github.pagehelper.Page;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public final class PageWrapper<T extends BaseBean> implements Convertable<PageWrapper<? extends BaseBean>>, PageVo {
    private List<T> list;
    @Setter
    private int pageNum;
    @Setter
    private int pageSize;
    @Setter
    private long total;
    @Setter
    private int pages;

    private PageWrapper(List<T> list) {
        this.list = list;
    }

    public static <T extends BaseBean> PageWrapper<T> wrap(List<T> list, Object page) {
        Assert.notNull(page, "page info is empty");
        PageWrapper pageList = new PageWrapper<>(list);
        BeanUtils.copyProperties(page, pageList);
        return pageList;
    }

    public static <T extends BaseBean> PageWrapper<T> wrap(List<T> list) {
        if (list instanceof Page) {
            return PageWrapper.wrap(list, list);
        }
        return new PageWrapper<>(list);
    }

    @Override
    public <D extends BaseBean> PageWrapper<D> convert(Class<D> clazz) {
        List<BaseBean> list = this.list.stream().map(item -> item.convert(clazz)).collect(Collectors.toList());
        PageWrapper pageList = new PageWrapper<>(list);
        pageList.setPageNum(this.pageNum);
        pageList.setPageSize(this.pageSize);
        pageList.setPages(this.pages);
        pageList.setTotal(this.total);
        return pageList;
    }
}
