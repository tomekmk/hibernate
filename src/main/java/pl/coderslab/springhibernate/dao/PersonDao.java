package pl.coderslab.springhibernate.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.springhibernate.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Person entity) {
        entityManager.persist(entity);      //void
    }

    public Person findById(Long Id) {
        return entityManager.find(Person.class, Id);
    }

    public void update(Person entity) {
        entityManager.merge(entity);        //Object
    }

    public void delete(Person entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
}
