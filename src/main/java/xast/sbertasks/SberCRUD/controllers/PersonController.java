package xast.sbertasks.SberCRUD.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import xast.sbertasks.SberCRUD.models.Person;
import xast.sbertasks.SberCRUD.services.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("person", personService.findAll());
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable int id, Model model) {
        model.addAttribute("person", personService.findOne(id));
        return "show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult result) {

        if(result.hasErrors()) {
            return "new";
        }

        personService.save(person);
        return "redirect:/person";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personService.findOne(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("person") Person person, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "edit";
        }

        personService.update(id, person);
        return "redirect:/person";

    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personService.delete(id);
        return "redirect:/person";
    }
}
