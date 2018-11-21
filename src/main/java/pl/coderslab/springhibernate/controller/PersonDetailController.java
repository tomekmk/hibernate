package pl.coderslab.springhibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springhibernate.model.PersonDTO;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/details")
public class PersonDetailController {

    @GetMapping("/create")
    public String createPersonDetailsForm(Model model) {
        model.addAttribute("newPersonDTO", new PersonDTO());
        return "/details/person-details-form";
    }

    @PostMapping("/create")
    @ResponseBody
    public String createPersonDetails(PersonDTO personDTO) {
        return personDTO.toString();
    }




    @ModelAttribute("gender")
    public List<String> gender() {
        String a[] = new String[] {"M", "K"};
        return Arrays.asList(a);
    }
    @ModelAttribute("country")
    public List<String> country() {
        String a[] = new String[] {"Polska", "Niemcy", "Czechy"};
        return Arrays.asList(a);
    }
    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        String a[] = new String[] {"java", "php", "ruby", "python"};
        return Arrays.asList(a);
    }
    @ModelAttribute("qwerty")
    public List<String> hobbies() {
        return Arrays.asList("rand1", "rand2", "rand3");
    }
}
