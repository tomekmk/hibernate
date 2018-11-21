package pl.coderslab.springhibernate.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.springhibernate.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional
public class AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Author entity) {
        entityManager.persist(entity);      //void
    }

    public Author findById(Long Id) {
        return entityManager.find(Author.class, Id);
    }

    public void update(Author entity) {
        entityManager.merge(entity);        //Object
    }

    public void delete(Author entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public List<Author> findAll() {
        TypedQuery<Author> q = entityManager.createQuery("SELECT p FROM Author p", Author.class);
        return q.getResultList();
    }
}
