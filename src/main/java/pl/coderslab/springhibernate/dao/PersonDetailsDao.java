package pl.coderslab.springhibernate.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.springhibernate.model.PersonDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class PersonDetailsDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(PersonDetails entity) {
        entityManager.persist(entity);      //void
    }

    public PersonDetails findById(Long Id) {
        return entityManager.find(PersonDetails.class, Id);
    }

    public void update(PersonDetails entity) {
        entityManager.merge(entity);        //Object
    }

    public void delete(PersonDetails entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
}
