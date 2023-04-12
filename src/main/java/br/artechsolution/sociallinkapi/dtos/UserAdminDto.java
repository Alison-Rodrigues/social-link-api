package br.artechsolution.sociallinkapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAdminDto {

    private String email;
    private String password;
    private String role;
}
