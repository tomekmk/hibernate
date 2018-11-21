package pl.coderslab.springhibernate.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.springhibernate.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional
public class PublisherDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Publisher entity) {
        entityManager.persist(entity);      //void
    }

    public Publisher findById(Long Id) {
        return entityManager.find(Publisher.class, Id);
    }

    public void update(Publisher entity) {
        entityManager.merge(entity);        //Object
    }

    public void delete(Publisher entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public List<Publisher> findAll() {
        TypedQuery<Publisher> q = entityManager.createQuery("SELECT p FROM Publisher p", Publisher.class);
        return q.getResultList();
    }
}
