package br.artechsolution.sociallinkapi.repository;

import br.artechsolution.sociallinkapi.models.UserAdminModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserAdminRepository extends JpaRepository<UserAdminModel, UUID> {

    UserAdminModel findByEmail(String email);
}
