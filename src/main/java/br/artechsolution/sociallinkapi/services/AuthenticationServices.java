package br.artechsolution.sociallinkapi.services;

import br.artechsolution.sociallinkapi.repository.UserAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServices implements UserDetailsService {

    @Autowired
    private UserAdminRepository userAdminRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAdminRepository.findByEmail(username);
    }
}
