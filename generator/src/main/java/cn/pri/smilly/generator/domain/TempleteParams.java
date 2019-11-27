package cn.pri.smilly.generator.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TempleteParams<K, V> implements Map<K, V> {
    private Map<K, V> params;

    public TempleteParams() {
        this.params = new HashMap<>();
    }

    public TempleteParams(Map params) {
        this.params = params;
    }

    @Override
    public int size() {
        return this.params.size();
    }

    @Override
    public boolean isEmpty() {
        return params.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return params.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return params.containsValue(value);
    }

    @Override
    public V get(Object key) {
        return params.get(key);
    }

    @Override
    public V put(K key, V value) {
        return params.put(key, value);
    }

    @Override
    public V remove(Object key) {
        return params.remove(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> params) {
        this.params.putAll(params);
    }

    @Override
    public void clear() {
        params.clear();
    }

    @Override
    public Set<K> keySet() {
        return params.keySet();
    }

    @Override
    public Collection<V> values() {
        return params.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return params.entrySet();
    }
}
