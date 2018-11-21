package pl.coderslab.springhibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springhibernate.dao.BookDao;
import pl.coderslab.springhibernate.model.Book;

import javax.validation.Valid;

@Controller
@RequestMapping("/propositions")
public class PropositionController {

    @Autowired
    private BookDao bookDao;

    @GetMapping
    public String getAllProposition(Model model) {
        model.addAttribute("propBooks", bookDao.findAllPropositions());
        return "/propositions/all";
    }

    @GetMapping("/edit/{id:[0-9]+}")                //EDYCJA GET
    public String editBook(Model model,
                           @PathVariable Long id) {
        model.addAttribute("editingBook", bookDao.findById(id));
        return "/propositions/edit";
    }

    @PostMapping("/edit/{id:[0-9]+}")                //EDYCJA POST
    public String saveEditedBook(@ModelAttribute("editingBook") @Valid Book book,
                                 BindingResult bindingResult,
                                 @PathVariable Long id) {
        book.setId(id);
        if (bindingResult.hasErrors()) {
            return "/propositions/edit";
        } else {
            bookDao.update(book);
            return "redirect:/propositions";
        }
    }

    @GetMapping("/remove/{Id}")
    public String removeBook(@PathVariable Long Id) {
        try {
            bookDao.remove(bookDao.findById(Id));
            return "redirect:/propositions";
        } catch (Exception e) {}
        return "redirect:/propositions";
    }

    @GetMapping("/create")                        //TWORZENIE GET
    public String book(Model model) {
        model.addAttribute("newBook", new Book());
        return "/propositions/create";
    }

    @PostMapping("/create")                         //TWORZENIE POST
    public String saveBook(@ModelAttribute("newBook") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/propositions/create";
        } else {
            bookDao.save(book);
            return "redirect:/propositions";
        }
    }
}
