package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.serwis.BookService;
import pl.coderslab.serwis.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController
{
    @Autowired
    BookService memoryBookService;

    @GetMapping("")
    public List<Book> allBooks ()
    {
        return memoryBookService.getList();
    }

    @GetMapping("/{id}")
    public Book getBook (@PathVariable long id)
    {
        return memoryBookService.getBookById(id);
    }
    @PostMapping("")
    public void addBook (@RequestParam String isbn, @RequestParam String title, @RequestParam String author, @RequestParam String publisher, @RequestParam String type)
    {
        memoryBookService.addToList(isbn, title, author, publisher, type);
    }
    @PutMapping("/{id}")
    public void modifyBook (@PathVariable long id, @RequestParam String isbn, @RequestParam String title, @RequestParam String author, @RequestParam String publisher, @RequestParam String type)
    {
        memoryBookService.edit(id, isbn, title, author, publisher, type);
    }
    @DeleteMapping("/{id}")
    public void deleteBook (@PathVariable long id)
    {
        memoryBookService.delete(id);
    }


}
