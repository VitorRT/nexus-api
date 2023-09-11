package br.com.ninus.rest.api.entity;

import java.time.LocalDateTime;

public class Admin {
    private Long id;
    private String email;
    private String password;
    private String smashCodeRole;
    private LocalDateTime created;
    private Boolean active;
}
