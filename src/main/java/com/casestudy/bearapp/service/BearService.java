package com.casestudy.bearapp.service;

import com.casestudy.bearapp.models.Armor;
import com.casestudy.bearapp.models.Bear;
import com.casestudy.bearapp.models.Weapon;

import java.util.List;

public interface BearService {
    List<Bear> getAllBears();
    void saveBear(Bear bear);
    Bear getBearById(long id);
    void deleteBearById(long id);

    void addWeapon(Long bear_id, Weapon weapon);
    void removeWeapon(Long bear_id, Weapon weapon);
    void addArmor(Long bear_id, Armor armor);
    void removeArmor(Long bear_id);
}
