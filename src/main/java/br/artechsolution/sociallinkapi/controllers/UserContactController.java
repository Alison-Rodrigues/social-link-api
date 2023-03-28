package br.artechsolution.sociallinkapi.controllers;

import br.artechsolution.sociallinkapi.dtos.UserContactDto;
import br.artechsolution.sociallinkapi.models.UserContactModel;
import br.artechsolution.sociallinkapi.repository.UserContactRepository;
import br.artechsolution.sociallinkapi.services.UserContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class UserContactController {

    @Autowired
    private UserContactRepository userContactRepository;

    @Autowired
    private UserContactService userContactService;

    @GetMapping("/listMessages")
    public List<UserContactModel> findAll() {
        return userContactRepository.findAll();
    }

    @PostMapping("/sendMessage")
    public void save(@RequestBody UserContactDto userContactDto) {
        userContactService.save(userContactDto);
    }

}
