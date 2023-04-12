package br.artechsolution.sociallinkapi.services;


import br.artechsolution.sociallinkapi.dtos.UserAdminDto;
import br.artechsolution.sociallinkapi.models.UserAdminModel;
import br.artechsolution.sociallinkapi.repository.UserAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAdminService {

    @Autowired
    private UserAdminRepository userAdminRepository;

    public void save(UserAdminDto userAdminDto) {

        UserAdminModel existsUser = userAdminRepository.findByEmail(userAdminDto.getEmail());

        if (existsUser != null) {
            throw new Error("E-mail já cadastrado.");
        }

        UserAdminModel userAdminModel = new UserAdminModel();

        userAdminModel.setEmail(userAdminDto.getEmail());
        userAdminModel.setPassword(userAdminDto.getPassword());
        userAdminModel.setRole(userAdminDto.getRole());

        userAdminRepository.save(userAdminModel);
    }
}
