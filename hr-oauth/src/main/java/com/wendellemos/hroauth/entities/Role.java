package com.wendellemos.hroauth.entities;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @EqualsAndHashCode
class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String roleName;
}
