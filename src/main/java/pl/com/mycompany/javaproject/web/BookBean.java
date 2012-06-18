package pl.com.mycompany.javaproject.web;


import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import pl.com.mycompany.javaproject.domain.Book;
import pl.com.mycompany.javaproject.service.BookManager;


@SessionScoped
@Named("bookBean")
public class BookBean implements Serializable {
    
    
    private static final long serialVersionUID = 16564L;
    
    private ListDataModel<Book> books = new ListDataModel<Book>();
    private Book book;
    
    @Inject
    private BookManager bookManager;

    public ListDataModel<Book> getAllBooks() {
        books.setWrappedData(bookManager.getAllBooks());
        return books;
    }
      
    public Book getSelectedBook() {
        return books.getRowData();
    }

    public String deleteBook() {
        Book selectedBook = books.getRowData();
        bookManager.delete(selectedBook);
        return "list";
    }

    public String editBook() {
        book = books.getRowData();
        return "editBook";
    }

    public String updateBook() {
        bookManager.persist(book);
        return "list";
    }
    
    public String showBook() {
        book = books.getRowData();
        return "showBook";
    }

    public Book getBook() {
        if(book == null) { 
            book = new Book(); 
        }
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    
}
