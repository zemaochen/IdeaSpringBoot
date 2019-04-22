package com.cdu.springboot.controllrer;

import com.cdu.springboot.domain.Book;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("/findBooks")
    public List<Book> findBooks(String author){
        System.out.println(author);
        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"疯狂java讲义","李刚","java.jpg",109.0));
        books.add(new Book(2,"疯狂java讲义","李刚","java.jpg",109.0));
        books.add(new Book(3,"疯狂java讲义","李刚","java.jpg",109.0));
        books.add(new Book(4,"疯狂java讲义","李刚","java.jpg",109.0));
        books.add(new Book(5,"疯狂java讲义","李刚","java.jpg",109.0));
        return books;
    }
}
