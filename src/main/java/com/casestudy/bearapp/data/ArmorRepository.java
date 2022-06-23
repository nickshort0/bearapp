package com.casestudy.bearapp.data;

import com.casestudy.bearapp.models.Armor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArmorRepository extends JpaRepository<Armor, Long> {
    Optional<Armor> findByName(String name);
}
