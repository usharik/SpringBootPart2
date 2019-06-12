package ru.geekbrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.geekbrains.persist.model.Person;
import ru.geekbrains.persist.repo.PersonRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    private final PersonRepository personRepository;

    @Autowired
    public MainController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostConstruct
    public void after() {
        logger.info("Created!!!");
        List<Person> people = new ArrayList<>();
        people.add(new Person("Ivan", "ivan@mail.ru"));
        people.add(new Person("Petr", "petr@gmail.com"));
        people.add(new Person("Julia", "julia222@seznam.cz"));
        personRepository.saveAll(people);
        personRepository.flush();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage(Model model) {
        logger.info("Index page");
        model.addAttribute("serverDate", LocalDateTime.now().toString());
        model.addAttribute("people", personRepository.findAll());
        return "index-page";
    }
}
