package com.example.mygame2.Service.Impl;

import com.example.mygame2.BD.Entity.Player;
import com.example.mygame2.BD.Repository.PlayerRepository;
import com.example.mygame2.Service.PlayerService;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public boolean add(Player player) {

        if (playerRepository.findByName(player.getName()) != null) {
            return false;        }
        playerRepository.save(player);
        return true;
    }

    @Override
    public Player delete(String name) {
        Player player = playerRepository.findByName(name).orElse(null);
        if (player != null) {
            playerRepository.delete(player);
            return player;
        }
        return null;
    }
}
