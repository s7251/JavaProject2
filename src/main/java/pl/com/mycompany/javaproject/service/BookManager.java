package pl.com.mycompany.javaproject.service;

import java.util.List;
import javax.ejb.Stateful;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.com.mycompany.javaproject.domain.Book;

@Stateful
@Named
public class BookManager {
    
    @PersistenceContext(unitName = "krystian_PU")
    private EntityManager entityManager;
    
        public List<Book> getAllBooks() {
        return entityManager.createQuery("select b from Book b").getResultList();
    }
    
    public void delete(Book book) {
        book = entityManager.merge(book);
        entityManager.remove(book);
    }
 
    public void persist(Book book) {
        entityManager.merge(book);
    }
    
}
