package com.casestudy.bearapp.service;

import com.casestudy.bearapp.data.BearRepository;
import com.casestudy.bearapp.models.Armor;
import com.casestudy.bearapp.models.Bear;
import com.casestudy.bearapp.models.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BearServiceImp implements BearService{

    @Autowired
    BearRepository bearRepository;
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
    public void addWeapon(Bear bear, Weapon weapon) {

    }

    @Override
    public void removeWeapon(Bear bear, Weapon weapon) {

    }

    @Override
    public void addArmor(Bear bear, Armor armor) {

    }

    @Override
    public void removeArmor(Bear bear, Armor armor) {

    }


}
