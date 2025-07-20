package com.nff.security.rosterentity;


import com.nff.security.users.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="rosters")
@Getter@Setter @NoArgsConstructor
@AllArgsConstructor @Builder
public class RosterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate weekStart;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private UserEntity createdBy;


    @OneToMany(mappedBy = "roster", cascade = CascadeType.ALL)
    private List<RosterAssignmentEntity> assignments = new ArrayList<>();

}
