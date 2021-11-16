package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Username;

import java.util.List;
import java.util.Optional;

public interface UsernameRepository {

    Optional<Username> findByUsername(String username);

    List<Username> findAll();

    Optional<Username> save(Username username);

    void deleteByUsername(String username);

}
