package com.casestudy.bearapp.service;

import com.casestudy.bearapp.models.Bear;

import java.util.List;

public interface BattleService {
    Bear battle(Bear bear1, Bear bear2);
    Bear battleRoyale(List<Bear> bears);
}
