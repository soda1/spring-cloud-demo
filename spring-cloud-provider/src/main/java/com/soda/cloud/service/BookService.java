package com.soda.cloud.service;


import com.soda.cloud.mapper.BookMapper;
import com.soda.cloud.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookMapper bookMapper;


    public Book getbook(String bookName) {

        Book book = new Book();
        book.setName(bookName);
        return bookMapper.selectOne(book);
    }
}
