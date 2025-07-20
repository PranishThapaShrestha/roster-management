package com.nff.security.rosterentity;

import com.nff.security.users.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.DayOfWeek;
@Entity
@Table(name= "roster_assignments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RosterAssignmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="roster_id")
    private RosterEntity roster;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity user;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    private String task;
}
