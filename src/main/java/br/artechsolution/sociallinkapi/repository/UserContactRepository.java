package br.artechsolution.sociallinkapi.repository;


import br.artechsolution.sociallinkapi.models.UserContactModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserContactRepository extends JpaRepository<UserContactModel, Integer> {
}
