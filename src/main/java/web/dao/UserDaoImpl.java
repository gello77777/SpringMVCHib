package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
   // @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        return entityManager.createQuery("select c from User c", User.class).getResultList();
    }

    @Override
    public void add(User user) {

        entityManager.persist(user);
    }

    @Override
    public void delete(User user) {

        entityManager.remove(getById(user.getId()));
    }

    @Override
    public void edit(User user) {

        entityManager.merge(user);
    }

    @Override
    public User getById(int id) {

        return entityManager.find(User.class, id);
    }
}
