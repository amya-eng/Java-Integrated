package com.zzs.controller;

import com.zzs.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zzs.domain.Book;

import java.util.List;

@RestController                        // @Controller + @ResponseBody（所有方法返回的对象会自动转成 JSON）
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping
    public boolean save(@RequestBody Book book) {
        return bookService.save(book);
    }
    @PutMapping
    public boolean update(@RequestBody Book book) {
        return bookService.update(book);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return bookService.delete(id);
    }
    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id) {
        return bookService.getById(id);
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }
}

