package pl.coderslab.springhibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springhibernate.dao.AuthorDao;
import pl.coderslab.springhibernate.model.Author;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private Validator validator;

    @GetMapping
    public String listOfAuthors(Model model) {
        model.addAttribute("authors", authorDao.findAll());
        return "/authors/all";
    }

    @GetMapping("/create")
    public String createAuthor(Model model) {
        model.addAttribute("newAuthor", new Author());
        return "/authors/create";
    }

    @PostMapping("/create")
    public String createNewAuthor(@ModelAttribute("newAuthor") @Valid Author author, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            authorDao.save(author);
            return "redirect:/authors";
        } else {
            return "/authors/create";
        }
    }

    @GetMapping("/remove/{Id}")
    public String removeAuthor(@PathVariable Long Id) {
        try {
            authorDao.delete(authorDao.findById(Id));
            return "redirect:/authors";
        } catch (Exception e) {}
        return "redirect:/authors";
    }

    @GetMapping("/edit/{Id}")
    public String editAuthor(@PathVariable Long Id,
                             Model model) {
        model.addAttribute("editingAuthor", authorDao.findById(Id));
        return "/authors/edit";
    }

    @PostMapping("/edit/{Id}")
    public String editAuthor(Author author,
                             @PathVariable Long Id,
                             Model model) {
        author.setId(Id);
        Set<ConstraintViolation<Author>> validate = validator.validate(author);
        if (validate.isEmpty()) {
            authorDao.update(author);
            return "redirect:/authors";
        } else {
            model.addAttribute("errors", validate);
            return "/validation/errors";
        }
    }
}
