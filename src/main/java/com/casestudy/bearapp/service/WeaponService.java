package com.casestudy.bearapp.service;

import com.casestudy.bearapp.models.Bear;
import com.casestudy.bearapp.models.Weapon;
import org.springframework.data.domain.Page;

import java.util.List;

public interface WeaponService {
    List<Weapon> getAllWeapons();
    void saveWeapon(Weapon weapon);
    Weapon getWeaponById(long id);
    Weapon getWeaponByName(String name);
    void deleteWeaponById(long id);

    Page<Weapon> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
