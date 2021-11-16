package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Username;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class UsernameRepositoryImpl implements UsernameRepository {

    private EntityManager entityManager;

    public UsernameRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Username> findByUsername(String username) {
        Username author = entityManager.find(Username.class, username);
        return author != null ? Optional.of(author) : Optional.empty();
    }

    public List<Username> findAll() {
        return entityManager.createQuery("from Username").getResultList();
    }

    public Optional<Username> findByName(String name) {
        Username username = entityManager.createNamedQuery("Author.findByName", Username.class)
                .setParameter("name", name)
                .getSingleResult();
        return username != null ? Optional.of(username) : Optional.empty();
    }

    public Optional<Username> save(Username username) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(username);
            entityManager.getTransaction().commit();
            return Optional.of(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deleteByUsername(String username) {
        Username author = entityManager.find(Username.class, username);
        if (author != null) {
            try {

                entityManager.getTransaction().begin();

                author.getBooks().forEach(book -> {
                    entityManager.remove(book);
                });

                entityManager.remove(author);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
