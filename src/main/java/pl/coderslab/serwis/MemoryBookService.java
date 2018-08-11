package pl.coderslab.serwis;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class MemoryBookService implements BookService
{
    private List<Book> list;
    public MemoryBookService()
    {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }
    public List<Book> getList()
    {
        return list;
    }
    public void setList(List<Book> list)
    {
        this.list = list;
    }
    public Book getBookById (long id)
    {
        Iterator<Book> iterator = this.list.listIterator();
        while(iterator.hasNext())
        {
            Book result = iterator.next();
            if(result.getId() == id)
            {
                return result;
            }
        }
        return null;
    }
    public void edit (long id, String isbn, String title, String author, String publisher, String type)
    {
        Iterator<Book> iterator = this.list.listIterator();
        while(iterator.hasNext())
        {
            Book toModify = iterator.next();
            if(toModify.getId() == id)
            {
                toModify.setIsbn(isbn);
                toModify.setTitle(title);
                toModify.setAuthor(author);
                toModify.setPublisher(publisher);
                toModify.setType(type);
            }
        }
    }
    public void delete (long id)
    {
        Iterator<Book> iterator = this.list.listIterator();
        while (iterator.hasNext())
        {
            if (iterator.next().getId() == id)
            {
                iterator.remove();
            }
        }
    }

    public void addToList (String isbn, String title, String author, String publisher, String type)
    {
        Book book = new Book(this.list.size() + 1, isbn, title, author, publisher, type);
        this.list.add(book);
    }



}
