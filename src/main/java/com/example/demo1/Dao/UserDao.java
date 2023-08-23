package com.example.demo1.Dao;

import com.example.demo1.Model.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserDao implements IUserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUserNoDB() {
        List<User> users = new ArrayList();
        users.add(new User(Long.parseLong("1"),"Juan","Arango","email@correo.com","3025895"));
        return users;
    }

    @Override
    @Transactional
    public List<User> getAllUser() {
        String query = "From User";
        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class,id);
        entityManager.remove(user);
    }

    @Override
    public void createUser(User user) {
        Argon2 encryptor = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hashPass = encryptor.hash(1, 1024, 1, user.getPassword());
        user.setPassword(hashPass);
        entityManager.merge(user);
    }

    @Override
    public boolean verifyEmail(User user) {
        String query = "FROM User WHERE email = :email";
        try{
            List<User> users =entityManager.createQuery(query)
                    .setParameter("email",user.getEmail()).getResultList();
            //.setParameter("password", user.getPassword()).getResultList();
            String storedPassworrd = users.get(0).getPassword();
            Argon2 encryptor = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            return encryptor.verify(storedPassworrd, user.getPassword());
        }catch(Exception e){
            return false;
        }
        //return !users.isEmpty();
    }


}
