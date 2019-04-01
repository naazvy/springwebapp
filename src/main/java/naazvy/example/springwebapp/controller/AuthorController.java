package naazvy.example.springwebapp.controller;

import naazvy.example.springwebapp.repositories.AuthorRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private AuthorRepositories authorRepositories;

    public AuthorController(AuthorRepositories authorRepositories) {
        this.authorRepositories = authorRepositories;
    }
    @RequestMapping("/authors")
    public String getAuthor(Model model){

        model.addAttribute("authors", authorRepositories.findAll());
        return "authors";
    }
}
