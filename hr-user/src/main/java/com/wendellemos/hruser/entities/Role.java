package com.wendellemos.hruser.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_role")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @EqualsAndHashCode
class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;
}
