package web_mvc.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web_mvc.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> userList() {
        TypedQuery<User> query = em.createQuery("select u from User u", User.class);

        return query.getResultList();
    }

    @Override
    public User findById(int id) {
        TypedQuery<User> query = em.createQuery("select u from User u where u.id=:id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
    @Override
    public void deleteById (int id) {
        em.remove(findById(id));
    }

    @Override
    public void delete(User user) {
        em.remove(user);
    }

    @Override
    public void update (int id, User userUpdated) {
        User userForUpdate = findById(id);
        userForUpdate.setName(userUpdated.getName());
        userForUpdate.setLastName(userUpdated.getLastName());
        userForUpdate.setAge(userUpdated.getAge());
        em.merge(userForUpdate);
    }
}
