package com.casestudy.bearapp.service;

import com.casestudy.bearapp.models.Bear;
import com.casestudy.bearapp.models.Weapon;

import java.util.List;

public interface WeaponService {
    List<Weapon> getAllWeapons();
    void saveWeapon(Weapon weapon);
    Weapon getWeaponById(long id);
    void deleteWeaponById(long id);
}
