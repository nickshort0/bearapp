package com.casestudy.bearapp.data;

import com.casestudy.bearapp.models.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {
}
