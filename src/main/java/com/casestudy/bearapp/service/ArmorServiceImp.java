package com.casestudy.bearapp.service;

import com.casestudy.bearapp.data.ArmorRepository;
import com.casestudy.bearapp.models.Armor;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional(rollbackOn = {DataAccessException.class})
@Service
public class ArmorServiceImp implements ArmorService{


    ArmorRepository armorRepository;
    @Autowired
    public ArmorServiceImp(ArmorRepository armorRepository) {
        this.armorRepository = armorRepository;
    }

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

    @Override
    public Page<Armor> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort =
                sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.armorRepository.findAll(pageable);
    }
}
