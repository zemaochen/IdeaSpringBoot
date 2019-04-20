package com.cdu.springboot.controllrer;

import com.cdu.springboot.domain.Book;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @RequestMapping("/findBook")
    public Book findBook(@RequestBody Book book){
        System.out.println(book);
        book.setAuthor("蔡徐坤");
        book.setImage("SpringMyBatis.jpg");
        book.setPrice(58.0);
        book.setRemark("媲美于SSH组合的轻量级java'EE应用开发方式");
        return book;
    }
}
