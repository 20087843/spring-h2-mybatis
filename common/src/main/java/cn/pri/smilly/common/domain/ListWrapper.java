package cn.pri.smilly.common.domain;

import cn.pri.smilly.common.core.Convertable;

import java.util.*;
import java.util.stream.Collectors;

public class ListWrapper<D extends BaseBean> implements Convertable<ListWrapper<? extends BaseBean>>, List<D>, PageVo {

    private List<D> data;

    public ListWrapper() {
        this.data = new ArrayList<>();
    }

    public ListWrapper(List<D> data) {
        this.data = data;
    }

    public static <T extends BaseBean> ListWrapper<T> wrap(List<T> list) {
        return new ListWrapper(list);
    }

    @Override
    public <T extends BaseBean> ListWrapper<T> convert(Class<T> clazz) {
        return new ListWrapper<>(this.data.stream().map(item -> item.convert(clazz)).collect(Collectors.toList()));
    }

    @Override
    public int size() {
        return this.data.size();
    }

    @Override
    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.data.contains(o);
    }

    @Override
    public Iterator<D> iterator() {
        return this.data.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.data.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return this.data.toArray(a);
    }

    @Override
    public boolean add(D d) {
        return this.data.add(d);
    }

    @Override
    public boolean remove(Object o) {
        return this.data.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.data.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends D> c) {
        return this.data.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends D> c) {
        return this.data.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.data.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.data.retainAll(c);
    }

    @Override
    public void clear() {
        this.data.clear();
    }

    @Override
    public D get(int index) {
        return this.data.get(index);
    }

    @Override
    public D set(int index, D element) {
        return this.data.set(index, element);
    }

    @Override
    public void add(int index, D element) {
        this.data.add(index, element);
    }

    @Override
    public D remove(int index) {
        return this.data.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return this.data.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return this.data.lastIndexOf(o);
    }

    @Override
    public ListIterator<D> listIterator() {
        return this.data.listIterator();
    }

    @Override
    public ListIterator<D> listIterator(int index) {
        return this.data.listIterator(index);
    }

    @Override
    public List<D> subList(int fromIndex, int toIndex) {
        return this.data.subList(fromIndex, toIndex);
    }
}
