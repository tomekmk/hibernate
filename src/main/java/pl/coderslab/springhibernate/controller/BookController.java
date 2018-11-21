package pl.coderslab.springhibernate.controller;

import org.hibernate.cfg.annotations.reflection.XMLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springhibernate.config.validation.ExValid;
import pl.coderslab.springhibernate.dao.AuthorDao;
import pl.coderslab.springhibernate.dao.BookDao;
import pl.coderslab.springhibernate.dao.PublisherDao;
import pl.coderslab.springhibernate.model.Author;
import pl.coderslab.springhibernate.model.Book;
import pl.coderslab.springhibernate.model.Publisher;

import javax.validation.groups.Default;
import java.util.List;

@Controller
@RequestMapping(value = "/books", produces = "text/html;charset=UTF-8")
public class BookController {

    @Autowired
    BookDao bookDao;

    @Autowired
    PublisherDao publisherDao;

    @Autowired
    AuthorDao authorDao;

    @GetMapping
    public String listOfBooks(Model model) {
        model.addAttribute("allBooks", bookDao.findAll());
        return "/books/all";
    }

//    @GetMapping("/{id:[0-9]+}")       //POBIERANIE JEDNEJ KSIĄŻKI
//    @ResponseBody
//    public String getBook(@PathVariable Long id) {
//        Book book = bookDao.findById(id);
//        return book.toString();
//    }

    @GetMapping("/edit/{id:[0-9]+}")
    public String editBook(Model model,
                           @PathVariable Long id) {
        model.addAttribute("editingBook", bookDao.findById(id));
        return "/books/edit";
    }

    @PostMapping("/edit/{id:[0-9]+}")
    public String saveEditedBook(@ModelAttribute("editingBook") @Validated({ExValid.class, Default.class}) Book book,
                                 BindingResult bindingResult,
                                 @PathVariable Long id) {
        book.setId(id);
        if (bindingResult.hasErrors()) {
            return "/books/edit";
        } else {
            bookDao.update(book);
            return "redirect:/books";
        }
    }


    @GetMapping("/remove/{id:[0-9]+}")
    public String removeAlert(@PathVariable Long id,
                              Model model) {
        model.addAttribute("id", id);
        return "/books/delete-alert";
    }

    @GetMapping("/removeAccept/{id:[0-9]+}")
    public String removeBook(@PathVariable Long id) {
        Book book = bookDao.findById(id);
        bookDao.remove(book);
        return "redirect:/books";
    }

    @PostMapping("/create")
    public String saveBook(@ModelAttribute("newBook") @Validated({ExValid.class, Default.class}) Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/books/create";
        } else {
            bookDao.save(book);
            return "redirect:/books";
        }
    }

    @GetMapping("/create")
    public String book(Model model) {
        model.addAttribute("newBook", new Book());
        return "/books/create";
    }

    @ModelAttribute("publishers")
    public List<Publisher> publishers() {
        return publisherDao.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> authors() {
        return authorDao.findAll();
    }
}