package pl.coderslab.springhibernate.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.pl.PESEL;
import pl.coderslab.springhibernate.config.validation.Mature;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @Size(min = 3)
    private String firstName;
    @NotNull @Size(min = 3)
    private String lastName;
    @PESEL
    private String pesel;
    @Email
    private String email;
    @Column(name = "year_of_birth")
    @Mature
    private Integer yearOfBirth;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    public Author() {
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getFullName() {
        String fullname = firstName + " " + lastName;
        if (fullname.length() > 10) {
            fullname = fullname.substring(0, 9);
            fullname += "...";
    }
        return fullname;
    }
}
