package br.artechsolution.sociallinkapi.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "user_contact")
@Getter
@Setter
public class UserContactModel {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "name", nullable = false, length = 150)
    String name;

    @Column(name = "email", nullable = false, length = 150)
    String email;

    @Column(name = "message", nullable = false, length = 300)
    String message;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "date_time")
    LocalDateTime dateTime;


}
