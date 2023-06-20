package com.wendellemos.hroauth.entities;

import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    private String email;
    private String password;

    Set<Role> roles = new HashSet<>();
}
