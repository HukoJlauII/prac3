import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyMap<K,V> implements Map<K,V> {
    private Map<K,V> map=new HashMap();
    private static final Lock lock=new ReentrantLock();
    @Override
    public int size() {
        int size;
        lock.lock();
        size=map.size();
        lock.unlock();
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean isEmpty;
        lock.lock();
        isEmpty=map.isEmpty();
        lock.unlock();
        return isEmpty;
    }

    @Override
    public boolean containsKey(Object key) {
        boolean containKey;
        lock.lock();
        containKey= map.containsKey(key);
        lock.unlock();
        return containKey;
    }

    @Override
    public boolean containsValue(Object value) {
        boolean containsValue;
        lock.lock();
        containsValue= map.containsValue(value);
        lock.unlock();
        return containsValue;
    }

    @Override
    public V get(Object key) {
        V get;
        lock.lock();
        get= map.get(key);
        lock.unlock();
        return get;
    }

    @Override
    public V put(K key, V value) {
        V put;
        lock.lock();
        put = map.put(key,value);
        lock.unlock();
        return put;
    }

    @Override
    public V remove(Object key) {
        V remove;
        lock.lock();
        remove = map.remove(key);
        lock.unlock();
        return remove;
    }

    @Override
    public void putAll(Map m) {
        lock.lock();
        map.putAll(m);
        lock.unlock();
    }

    @Override
    public void clear() {
        lock.lock();
        map.clear();
        lock.unlock();
    }

    @Override
    public Set keySet() {
        Set<K> set =new HashSet<>();
        lock.lock();
        set=map.keySet();
        lock.unlock();
        return set;
    }

    @Override
    public Collection values() {
        Collection<V> collection;
        lock.lock();
        collection=map.values();
        lock.unlock();
        return collection;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set =new HashSet<>();
        lock.lock();
        set=map.entrySet();
        lock.unlock();
        return null;
    }
}
