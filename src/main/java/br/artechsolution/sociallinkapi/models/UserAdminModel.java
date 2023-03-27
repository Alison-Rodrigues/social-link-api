package br.artechsolution.sociallinkapi.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "user_admin")
@Getter
@Setter
public class UserAdminModel {

    @Id
    @Column(name = "uuid")
    UUID uuid = UUID.randomUUID();

    @Column(name = "email", unique = true, nullable = false, length = 150)
    String email;

    @Column(name = "password", nullable = false, length = 150)
    String password;

}
