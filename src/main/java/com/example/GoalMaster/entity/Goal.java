package com.example.GoalMaster.entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Goals")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGoals", nullable = false)
    Long idGoals;
    @Column(name = "title",nullable = false)
    String title;
    @Column(name = "status", nullable = false)
    String status;
    @Column(name = "describe",nullable = false)
    String describe;
    @Column(name = "start_date", nullable = false)
    Date start_date;
    @Column(name = "end_date", nullable = false)
    Date end_date;

    @OneToOne
    @JoinColumn(name = "userID", referencedColumnName = "IdUser")
    User user;

    @CreatedDate
    Date createdAt;
}
