package com.First.Project1.Controller;

import com.First.Project1.Model.Book;
import com.First.Project1.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    // return the books list
    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.allbooks();
    }

    // return the specific book by id
    @RequestMapping("/books/{id}")
    public Optional<Book> getBook(@PathVariable Long id) {
        return bookService.bookbinder(id);
    }

    @PostMapping("/books")
    public void addbook(@RequestBody Book book) {
        bookService.addbook(book);
    }

    @PutMapping("/books/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody Book book) {
        bookService.updatingbook(id, book);
    }

    @DeleteMapping("/books/{id}")
    public void bookdel(@PathVariable Long id) {
        bookService.deletingbook(id);
    }
}
