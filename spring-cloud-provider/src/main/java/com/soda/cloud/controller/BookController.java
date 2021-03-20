package com.soda.cloud.controller;

import com.soda.cloud.pojo.Book;
import com.soda.cloud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/book/{bookname}")
    public Book getbook(@PathVariable(name = "bookname") String bookname, HttpServletResponse response) throws InterruptedException {
        System.out.println("接收请求");
        //休眠模拟访问超时
//        TimeUnit.SECONDS.sleep(7);
        return bookService.getbook(bookname);
    }






}
