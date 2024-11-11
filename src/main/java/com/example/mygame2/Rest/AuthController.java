package com.example.mygame2.Rest;

import com.example.mygame2.BD.Entity.I;
import com.example.mygame2.BD.Entity.Player;
import com.example.mygame2.BD.Repository.IRepository;
import com.example.mygame2.Rest.Dao.IDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
public class AuthController {
    private final IRepository service;

    public AuthController(IRepository service) {
        this.service = service;
    }

    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("user", new IDao());
        return "registration-form";
    }

    @PostMapping("/registration/save")
    public String register(@Valid @ModelAttribute("user") IDao userDao, Model model, BindingResult result) {
        service.findByLogin(userDao.getLogin()).ifPresent(existingUser -> {
            result.reject("Login already exist");
        });

        if (result.hasErrors()) {
            model.addAttribute("user", userDao);
            return "registration-form";
        }

        service.save(new I(userDao.getLogin(), userDao.getPassword()));
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("login") String login, @ModelAttribute("password") String password, RedirectAttributes redirectAttributes) {
        boolean isValidUser = service.findByLogin(login).map(user -> user.getPassword().equals(password)).orElse(false);

        if (isValidUser) {
            return "redirect:/addPlayer";
        } else {
            redirectAttributes.addFlashAttribute("error", "Неверный логин или пароль");
            return "redirect:/login";
        }
    }

    @GetMapping("/auth/addPlayer")
    public String showAddPlayerForm(Model model) {
        model.addAttribute("player", new Player());
        return "addPlayer";
    }
}
