package com.example.GoalMaster.entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Goal_progress")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Goal_progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;
    @Column(name = "title",nullable = false)
    String title;
    @Column(name = "completed",nullable = false)
    boolean completed;
    @OneToOne
    @JoinColumn(name = "goalID", referencedColumnName = "idGoals")
    Goal goal;
}
