package com.nff.security.repository;

import com.nff.security.entity.RosterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RosterRepository extends JpaRepository<RosterEntity, Long> {
}
