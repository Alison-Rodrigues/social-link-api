package br.artechsolution.sociallinkapi.controllers;


import br.artechsolution.sociallinkapi.dtos.UserAdminDto;
import br.artechsolution.sociallinkapi.models.UserAdminModel;
import br.artechsolution.sociallinkapi.services.TokenService;
import br.artechsolution.sociallinkapi.services.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/v1/api")
public class UserAdminController {


    @Autowired
    private UserAdminService userAdminService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

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

    @PostMapping("/login")
    public String login(@RequestBody UserAdminDto userAdminDto) {
        //Class responsible for authentication by user and password
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(userAdminDto.getEmail(),
                    userAdminDto.getPassword());

        Authentication authenticate = this.authenticationManager
                .authenticate(usernamePasswordAuthenticationToken);

        var user = (UserAdminModel) authenticate.getPrincipal();

        return tokenService.generateToken(user);
    }

}
