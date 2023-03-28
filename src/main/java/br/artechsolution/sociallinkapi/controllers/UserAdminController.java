package br.artechsolution.sociallinkapi.controllers;


import br.artechsolution.sociallinkapi.dtos.UserAdminDto;
import br.artechsolution.sociallinkapi.services.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class UserAdminController {


    @Autowired
    private UserAdminService userAdminService;

    private final PasswordEncoder encoder;

    public UserAdminController(UserAdminService userAdminService, PasswordEncoder encoder) {
        this.userAdminService = userAdminService;
        this.encoder = encoder;
    }


    @PostMapping("/createUser")
    public void save(@RequestBody UserAdminDto userAdminDto) {
        userAdminDto.setPassword(encoder.encode(userAdminDto.getPassword()));
        userAdminService.save(userAdminDto);
    }

}
