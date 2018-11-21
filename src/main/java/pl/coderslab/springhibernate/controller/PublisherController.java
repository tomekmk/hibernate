package pl.coderslab.springhibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springhibernate.dao.BookDao;
import pl.coderslab.springhibernate.dao.PublisherDao;
import pl.coderslab.springhibernate.model.Book;
import pl.coderslab.springhibernate.model.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/publishers", produces = "text/html; charset=UTF-8")
public class PublisherController {

    @Autowired
    private PublisherDao publisherDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    Validator validator;

    @GetMapping
    public String listOfPublishers(Model model) {
        model.addAttribute("publishers", publisherDao.findAll());
        return "/publishers/all";
    }

    @GetMapping("/create")
    public String createPublisher(Model model) {
        model.addAttribute("newPublisher", new Publisher());
        return "/publishers/create";
    }

    @PostMapping("/create")
    public String createNewPublisher(Publisher publisher, Model model) {
        Set<ConstraintViolation<Publisher>> validate = validator.validate(publisher);
        if (validate.isEmpty()) {
            publisherDao.save(publisher);
            return "redirect:/publishers";
        } else {
            model.addAttribute("errors", validate);
            return "/validation/errors";
        }
    }

    @GetMapping("/remove/{Id}")
    public String removePublisher(@PathVariable Long Id) {
        try {
            publisherDao.delete(publisherDao.findById(Id));
            return "redirect:/publishers";
        } catch (Exception e) {}
        return "redirect:/publishers";
    }

    @GetMapping("/edit/{Id}")
    public String editPublisher(@PathVariable Long Id,
                             Model model) {
        model.addAttribute("publisher", publisherDao.findById(Id));
        return "/publishers/edit";
    }

    @PostMapping("/edit/{Id}")
    public String editPublisher(Publisher publisher,
                                @PathVariable Long Id,
                                Model model) {
        publisher.setId(Id);
        Set<ConstraintViolation<Publisher>> validate = validator.validate(publisher);
        if (validate.isEmpty()) {
            publisherDao.update(publisher);
            return "redirect:/publishers";
        } else {
            model.addAttribute("errors", validate);
            return "/validation/errors";
        }
    }

    @ModelAttribute("allBooks")
    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }
}
