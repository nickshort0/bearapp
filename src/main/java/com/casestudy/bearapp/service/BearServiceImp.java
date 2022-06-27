package com.casestudy.bearapp.service;

import com.casestudy.bearapp.data.ArmorRepository;
import com.casestudy.bearapp.data.BearRepository;
import com.casestudy.bearapp.data.WeaponRepository;
import com.casestudy.bearapp.models.Armor;
import com.casestudy.bearapp.models.Bear;
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
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional(rollbackOn = {DataAccessException.class})
@Service
public class BearServiceImp implements BearService{


    BearRepository bearRepository;
    WeaponRepository weaponRepository;
    ArmorRepository armorRepository;
    @Autowired
    public BearServiceImp(BearRepository bearRepository, WeaponRepository weaponRepository, ArmorRepository armorRepository) {
        this.bearRepository = bearRepository;
        this.weaponRepository = weaponRepository;
        this.armorRepository = armorRepository;
    }

    @Override
    public List<Bear> getAllBears() {
        return this.bearRepository.findAll();
    }

    @Override
    public void saveBear(Bear bear) {
        this.bearRepository.save(bear);
    }

    @Override
    public Bear getBearById(long id) {
        Optional<Bear> optional = bearRepository.findById(id);
        Bear bear;
        if(optional.isPresent()){
            bear = optional.get();
        }
        else{
            throw new RuntimeException("Bear not found for id " + id);
        }
        return bear;
    }

    @Override
    public void deleteBearById(long id) {
        this.bearRepository.deleteById(id);
    }

    @Override
    public void addWeapon(Long bearId, Weapon weapon) {
        Bear bear = getBearById(bearId);
        bear.setWeapon(weapon);
        bearRepository.save(bear);
    }

    @Override
    public void removeWeapon(Long bearId) {
        Bear bear = getBearById(bearId);
        bear.setWeapon(null);
        bearRepository.save(bear);
    }

    @Override
    public void addArmor(Long bearId, Armor armor) {
        Bear bear = getBearById(bearId);
        bear.setArmor(armor);
        bearRepository.save(bear);
    }

    @Override
    public void removeArmor(Long bearId) {
        Bear bear = getBearById(bearId);
        bear.setArmor(null);
        bearRepository.save(bear);
    }


}
