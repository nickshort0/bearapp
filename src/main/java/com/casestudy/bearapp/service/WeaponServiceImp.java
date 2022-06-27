package com.casestudy.bearapp.service;

import com.casestudy.bearapp.data.WeaponRepository;
import com.casestudy.bearapp.models.Armor;
import com.casestudy.bearapp.models.Weapon;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional(rollbackOn = {DataAccessException.class})
@Service
public class WeaponServiceImp implements WeaponService{

    @Autowired
    WeaponRepository weaponRepository;
    @Override
    public List<Weapon> getAllWeapons() {
        return weaponRepository.findAll();
    }

    @Override
    public void saveWeapon(Weapon weapon) {
        this.weaponRepository.save(weapon);
    }

    @Override
    public Weapon getWeaponById(long id) {
        Optional<Weapon> optional = weaponRepository.findById(id);
        Weapon weapon;
        if(optional.isPresent()){
            weapon = optional.get();
        }
        else{
            throw new RuntimeException("Weapon not found for id " + id);
        }
        return weapon;
    }

    @Override
    public Weapon getWeaponByName(String name) {
        Optional<Weapon> optional = weaponRepository.findByName(name);
        Weapon weapon;
        if(optional.isPresent()){
            weapon = optional.get();
        }
        else{
            throw new RuntimeException("Weapon not found for name " + name);
        }
        return weapon;
    }

    @Override
    public void deleteWeaponById(long id) {
        weaponRepository.deleteById(id);
    }
}
