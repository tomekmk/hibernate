package pl.coderslab.springhibernate.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.springhibernate.dao.PersonDao;
import pl.coderslab.springhibernate.model.Person;

@Controller
@RequestMapping(path = "/persons", produces = "text/html; charset=UTF-8")
public class PersonController {

    @Autowired
    private PersonDao personDao;

    @GetMapping("/create")
    public String getPersonForm(Model model) {
        model.addAttribute("newPerson", new Person());
        return "/registration";
    }

    @PostMapping("/create")
    public String createPerson(@RequestParam String login,
                               @RequestParam String email,
                               @RequestParam String password,
                               Model model) {
        Person person = new Person();
        person.setLogin(login);
        person.setEmail(email);
        person.setPassword(password);
        personDao.save(person);
        model.addAttribute("person", person.getId());
        return "/registration-success";
    }

    @GetMapping("/sform/create")
    public String getSpringPersonForm(Model model) {
        model.addAttribute("newSpringPerson", new Person());
        return "/registration";
    }

    @PostMapping("/sform/create")
    public String createSpringPerson(Person person, Model model) {
        personDao.save(person);
        model.addAttribute("person", person.getId());
        return "/registration-success";
    }
}
