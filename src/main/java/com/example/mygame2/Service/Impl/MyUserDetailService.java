package com.example.mygame2.Service.Impl;

import com.example.mygame2.BD.Entity.I;
import com.example.mygame2.BD.Repository.IRepository;
import com.example.mygame2.BD.Repository.PlayerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MyUserDetailService implements UserDetailsService {

    private final IRepository repository;

    public MyUserDetailService(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.example.mygame2.BD.Entity.I> myUserOptional = repository.findByLogin(username);
        if (myUserOptional.isPresent()) {
            com.example.mygame2.BD.Entity.I myUser = myUserOptional.get();
            return org.springframework.security.core.userdetails.User.builder()
                    .username(myUser.getLogin())
                    .password(myUser.getPassword())
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}
