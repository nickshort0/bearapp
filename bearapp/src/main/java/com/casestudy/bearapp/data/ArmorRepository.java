package com.casestudy.bearapp.data;

import com.casestudy.bearapp.models.Armor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArmorRepository extends JpaRepository<Armor, Long> {
}
