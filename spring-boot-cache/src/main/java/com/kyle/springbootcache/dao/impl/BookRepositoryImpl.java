package com.kyle.springbootcache.dao.impl;

import com.kyle.springbootcache.dao.BookRepository;
import com.kyle.springbootcache.entity.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository {
    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    /*@Cacheable支持如下几个参数：
    key：缓存的key，默认为空，既表示使用方法的参数类型及参数值作为key，支持SpEL。例如： memCachedService.storeUserAddress("user", "BeiJing");
    所以对应的key为：service.MemcachedService-storeUserAddress_user_BeiJing
    name：存储位置。在本来中remote表示使用memcached服务器。
    condition：触发条件，只有满足条件的情况才会加入缓存，默认为空，既表示全部都加入缓存，支持SpEL。
    expire：过期时间，单位为秒。*/

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 2000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
