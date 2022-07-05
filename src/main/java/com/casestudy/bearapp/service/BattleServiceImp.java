package com.casestudy.bearapp.service;

import com.casestudy.bearapp.models.Bear;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BattleServiceImp implements BattleService{


    @Override
    public Bear battle(Bear bear1, Bear bear2) {

        int bear1health = bear1.getBaseDef();
        if(bear1.getArmor() != null) bear1health += bear1.getArmor().getDefense();
        int bear2health = bear2.getBaseDef();
        if(bear2.getArmor() != null) bear2health += bear2.getArmor().getDefense();
        int bear1attack = bear1.getBaseAtk();
        if(bear1.getWeapon() != null) bear1attack += bear1.getWeapon().getAttack();
        int bear2attack = bear2.getBaseAtk();
        if(bear2.getWeapon() != null) bear2attack += bear2.getWeapon().getAttack();

        boolean battling = true;
        Bear winner = bear2;

        while(battling){
            bear2health -= bear1attack;
            log.warn("Your bear attacks for " + bear1attack + "! " + bear2.getName() + " remaining health: " + bear2health);

            if(bear2health < 1 || bear2attack < 1){
                winner = bear1;
                battling = false;
                continue;
            }

            bear1health -= bear2attack;
            log.warn(bear2.getName() +" attacks you for " + bear2attack + "! " +  "Your bear's remaining health: " + bear1health);

            if(bear1health < 1 || bear1attack < 1){
                winner = bear2;
                battling = false;
            }
        }
        return winner;
    }

    @Override
    public Bear battleRoyale(List<Bear> bears) {
        return null;
    }
}
