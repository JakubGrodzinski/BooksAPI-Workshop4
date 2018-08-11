package pl.coderslab.serwis;

import pl.coderslab.model.Book;

import java.util.List;

public interface BookService
{
    public List<Book> getList();
    public void setList(List<Book> list);
    public Book getBookById (long id);
    public void edit (long id, String isbn, String title, String author, String publisher, String type);
    public void delete (long id);
    public void addToList (String isbn, String title, String author, String publisher, String type);
}
