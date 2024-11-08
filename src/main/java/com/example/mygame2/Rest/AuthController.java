package com.example.mygame2.Rest;


import com.example.mygame2.BD.Entity.I;
import com.example.mygame2.BD.Entity.Player;
import com.example.mygame2.BD.Repository.IRepository;
import com.example.mygame2.Rest.Dao.IDao;
import com.example.mygame2.Service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final IRepository service;

    public AuthController(IRepository service) {
        this.service = service;
    }
    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/registration")
    public String registrationForm(Model model){
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
    public String login(){
        return "login";
    }
}

