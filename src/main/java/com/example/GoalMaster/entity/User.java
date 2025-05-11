package com.example.GoalMaster.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    Long idUser;

    @Column(nullable = false, unique = true)
    String emailPhone;
    @Column(nullable = false)
    String password;

    @CreatedDate
    Date createdAt;

    @OneToOne
    @JoinColumn(name = "usersId", referencedColumnName = "idUser")
    Profile profile;
}
