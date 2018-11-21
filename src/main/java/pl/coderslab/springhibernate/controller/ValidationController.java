package pl.coderslab.springhibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springhibernate.model.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequestMapping("/validation")
public class ValidationController {

    @Autowired
    Validator validator;

    @GetMapping("/test")
    public String testValidation(Model model) {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("A");
        book.setRating(12.0);

        Set<ConstraintViolation<Book>> errors = validator.validate(book);
        if (!errors.isEmpty()) {
            model.addAttribute("errors", errors);
            System.out.println("błędy walidacji");

            for (ConstraintViolation<Book> violation : errors) {
                Path path = violation.getPropertyPath();
                String message = violation.getMessage();
                Object invalidValue = violation.getInvalidValue();
                System.out.printf("Dla %s niepoprawna wartość %s, treść błędu: '%s'\n", path, invalidValue, message);
            }

            return "/validation/errors";
        } else {
            System.out.println("brak błędów");
            return "200 ok";
        }
    }
}
