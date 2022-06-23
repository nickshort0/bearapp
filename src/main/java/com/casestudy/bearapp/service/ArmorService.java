package com.casestudy.bearapp.service;

import com.casestudy.bearapp.models.Armor;

import java.util.List;

public interface ArmorService {
    List<Armor> getAllArmors();
    void saveArmor(Armor armor);
    Armor getArmorById(long id);
    Armor getArmorByName(String name);
    void deleteArmorById(long id);
}
