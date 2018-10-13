package com.kyle.springbootcache.dao;

import com.kyle.springbootcache.entity.Book;

public interface BookRepository {
    Book getByIsbn(String isbn);
}
