package com.casestudy.bearapp.service;

import com.casestudy.bearapp.data.ArmorRepository;
import com.casestudy.bearapp.models.Armor;
import com.casestudy.bearapp.models.Bear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArmorServiceImp implements ArmorService{

    @Autowired
    ArmorRepository armorRepository;
    @Override
    public List<Armor> getAllArmors() {
        return this.armorRepository.findAll();
    }

    @Override
    public void saveArmor(Armor armor) {
        this.armorRepository.save(armor);
    }

    @Override
    public Armor getArmorById(long id) {
        Optional<Armor> optional = armorRepository.findById(id);
        Armor armor;
        if(optional.isPresent()){
            armor = optional.get();
        }
        else{
            throw new RuntimeException("Armor not found for id " + id);
        }
        return armor;
    }

    @Override
    public Armor getArmorByName(String name) {
        Optional<Armor> optional = armorRepository.findByName(name);
        Armor armor;
        if(optional.isPresent()){
            armor = optional.get();
        }
        else{
            throw new RuntimeException("Armor not found for name " + name);
        }
        return armor;
    }

    @Override
    public void deleteArmorById(long id) {
        this.armorRepository.deleteById(id);
    }
}
