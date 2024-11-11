package com.example.mygame2.Rest;

import com.example.mygame2.BD.Dto.PlayerDto;
import com.example.mygame2.BD.Entity.Player;
import com.example.mygame2.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/addPlayer")
    public String showAddPlayerForm(Model model, String name) {

        model.addAttribute("player", new PlayerDto(name));
        return "addPlayer";
    }

    // Обработка добавления игрока
    @PostMapping("/addPlayer")
    public String addPlayer(@ModelAttribute Player player, Model model) {
        if (playerService.add(player)) {
            model.addAttribute("message", "Игрок успешно добавлен!");
        } else {
            model.addAttribute("error", "Игрок с таким именем уже существует.");
        }
        return "addPlayer";
    }

    @GetMapping("/deletePlayer")
    public String showDeletePlayerForm(Model model) {
        model.addAttribute("player", new Player());
        return "deletePlayer";
    }


    @PostMapping("/deletePlayer")
    public String deletePlayer(@ModelAttribute Player player, Model model) {
        Player deletedPlayer = playerService.delete(player.getName());
        if (deletedPlayer != null) {
            model.addAttribute("message", "Игрок удален!");
        } else {
            model.addAttribute("error", "Игрок с таким именем не найден.");
        }
        return "deletePlayer";
    }
}
