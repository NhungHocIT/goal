package com.example.GoalMaster.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Table(name = "profiles")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idUser;

    @Column(name = "avata_url", nullable = true)
    String avatar_url;
    @Column(name = "background_image", nullable = true)
    String background_image;
    String bio;

    @Column(name = "username", nullable = false)
    String username;
    @Column(name = "birth", nullable = false)
    Date birth;
}