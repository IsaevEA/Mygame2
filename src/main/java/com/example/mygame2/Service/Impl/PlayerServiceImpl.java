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
    public void add(Player player) {
        playerRepository.save(player);
    }

    @Override
    public Player getPlayer(String id) {
        return playerRepository.getReferenceById(id);
    }


}
