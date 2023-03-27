package br.artechsolution.sociallinkapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserContactDto {
    String name;
    String email;
    String message;
}
