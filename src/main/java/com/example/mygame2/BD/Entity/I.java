package com.example.mygame2.BD.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Data
@Table(name = "i")
@AllArgsConstructor
@NoArgsConstructor
public class I {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String login;

    private String password;



    public I(String login, String password) {
        this.login = login;
        this.password = new BCryptPasswordEncoder().encode(password);
    }
}
