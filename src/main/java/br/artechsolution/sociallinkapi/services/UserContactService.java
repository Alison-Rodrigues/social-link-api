package br.artechsolution.sociallinkapi.services;


import br.artechsolution.sociallinkapi.dtos.UserContactDto;
import br.artechsolution.sociallinkapi.models.UserContactModel;
import br.artechsolution.sociallinkapi.repository.UserContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserContactService {

    @Autowired
    private UserContactRepository userContactRepository;

    public void save(UserContactDto userContactDto) {
        UserContactModel userContactModel = new UserContactModel();

        userContactModel.setName(userContactDto.getName());
        userContactModel.setEmail(userContactDto.getEmail());
        userContactModel.setMessage(userContactDto.getMessage());
        userContactModel.setDateTime(LocalDateTime.now());

        userContactRepository.save(userContactModel);
    }
}
