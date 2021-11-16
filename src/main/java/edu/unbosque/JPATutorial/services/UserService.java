package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Username;
import edu.unbosque.JPATutorial.jpa.repositories.UsernameRepository;
import edu.unbosque.JPATutorial.jpa.repositories.UsernameRepositoryImpl;
import edu.unbosque.JPATutorial.servlets.pojos.AuthorPOJO;
import edu.unbosque.JPATutorial.servlets.pojos.UserPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserService {

    UsernameRepository usernameRepository;

    public List<UserPOJO> listUsers() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PetsDB");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        usernameRepository = new UsernameRepositoryImpl(entityManager);
        List<Username> usernames = usernameRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<UserPOJO> authorsPOJO = new ArrayList<>();
        for (Username username : usernames) {
            authorsPOJO.add(new UserPOJO(
                    username.getName(),
                    username.getPassword(),
                    username.getEmail(),
                    username.getRole()
            ));
        }

        return authorsPOJO;

    }

    public Username saveUser(String name) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PetsDB");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        usernameRepository = new UsernameRepositoryImpl(entityManager);

        Username username = new Username(name);
        Username persistedUsername = UsernameRepository.save(username).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedUsername;

    }

    public void deleteAuthor(Integer authorId) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        usernameRepository = new UsernameRepositoryImpl(entityManager);
        usernameRepository.deleteByUsername(username);

        entityManager.close();
        entityManagerFactory.close();

    }

}
