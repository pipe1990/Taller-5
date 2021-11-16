package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Username;
import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.repositories.UsernameRepository;
import edu.unbosque.JPATutorial.jpa.repositories.UsernameRepositoryImpl;
import edu.unbosque.JPATutorial.jpa.repositories.BookRepository;
import edu.unbosque.JPATutorial.jpa.repositories.BookRepositoryImpl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

@Stateless
public class BookService {

    UsernameRepository usernameRepository;
    BookRepository bookRepository;

    public void saveBook(String title, String isbn, Integer authorId) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        usernameRepository = new UsernameRepositoryImpl(entityManager);
        bookRepository = new BookRepositoryImpl(entityManager);

        Optional<Username> username = usernameRepository.findByUsername(authorId);
        username.ifPresent(a -> {
            a.addBook(new Book(title, isbn));
            usernameRepository.save(a);
        });

        entityManager.close();
        entityManagerFactory.close();

        return;

    }

}
