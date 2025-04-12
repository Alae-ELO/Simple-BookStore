package com.First.Project1.Service;

import com.First.Project1.Model.Book;
import com.First.Project1.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository Repo;

    public List<Book> allbooks() {
        return Repo.findAll();
    }

    public Optional<Book> bookbinder(Long id) {
        return Repo.findById(id);
    }

    public void addbook(Book book) {
        Repo.save(book);
    }

    public void updatingbook(Long id, Book book) {
        Optional<Book> existing = Repo.findById(id);
        if (existing.isPresent()) {
            book.setId(id);
            Repo.save(book);
        }
    }


    public void deletingbook(Long id) {
        Repo.deleteById(id);
    }
}
