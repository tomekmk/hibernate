package pl.coderslab.springhibernate.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.springhibernate.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book entity) {
        entityManager.persist(entity);      //void
    }

    public Book findById(Long Id) {
        return entityManager.find(Book.class, Id);
    }

    public void update(Book entity) {
        entityManager.merge(entity);        //Object
    }

    public void remove(Book entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public List<Book> findAll() {
        return entityManager.createQuery("SELECT b FROM Book b WHERE proposition = false ", Book.class).getResultList();
    }

    public List<Book> findAllPropositions() {
        return entityManager.createQuery("SELECT b FROM Book b WHERE proposition = true", Book.class).getResultList();
    }
}
