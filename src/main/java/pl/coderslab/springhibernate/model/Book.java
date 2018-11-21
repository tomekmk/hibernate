package pl.coderslab.springhibernate.model;

import org.hibernate.validator.constraints.NotBlank;
import pl.coderslab.springhibernate.config.validation.ExValid;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @NotNull(groups = ExValid.class)
    private Publisher publisher;

    @ManyToMany(fetch = FetchType.EAGER) @NotNull(message = "Książka musi posiadać listę autorów", groups = ExValid.class)
    @Size(min = 1, message = "Ksiązka musi posiadać przynajmniej jednego autora", groups = ExValid.class)
    private List<Author> authors;

    @Column(nullable = false, unique = true) @Size(min = 5) @NotBlank @NotNull
    private String title;
    @Column(columnDefinition = "TEXT") @Size(max = 600)
    private String description;
    @Column(scale = 2, precision = 4) @Min(value = 1, groups = ExValid.class) @Max(value = 10, groups = ExValid.class)
    private Double rating;
    @Min(value = 2, groups = ExValid.class)
    private Integer pages;

    private Boolean proposition;

    public Book() {
    }

    public Boolean getProposition() {
        return proposition;
    }

    public void setProposition(Boolean proposition) {
        this.proposition = proposition;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", publisher=" + publisher +
                ", authors=" + authors +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", pages=" + pages +
                '}';
    }
}