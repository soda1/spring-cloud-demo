package com.soda.cloud.feign.api;

import com.soda.cloud.pojo.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "bookServer")
public interface ProviderFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/book/{bookName}")
    Book getBook(@PathVariable("bookName") String bookName);


}
