package com.casestudy.bearapp.service;

import com.casestudy.bearapp.models.Bear;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BattleServiceImp implements BattleService{
    @Override
    public Bear battle(Bear bear1, Bear bear2) {
        //while bear health > 0
        //random bear goes first
        //base def + armor - base atk + weapon
        //wait better idea
        //attack button/other actions(defend, run, idk)
        //return victor
        return null;
    }

    @Override
    public Bear battleRoyale(List<Bear> bears) {
        return null;
    }
}
