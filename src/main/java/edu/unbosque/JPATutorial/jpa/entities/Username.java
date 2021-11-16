package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "UserApp") // Optional
@NamedQueries({
        @NamedQuery(name = "username.findByUsername",
                query = "SELECT a FROM UserApp a WHERE a.name = :name")
})
public class Username {

    @Id
    @GeneratedValue
    @Column(name = "Username_id")
    private String name;
    private String password;
    private String email;
    private String role;


    @Column(nullable = false)

    @OneToMany(mappedBy = "username", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    public  Username (){}

    public Username(String name, String password, String email, String role ) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
        book.setAuthor(this);
    }

}
