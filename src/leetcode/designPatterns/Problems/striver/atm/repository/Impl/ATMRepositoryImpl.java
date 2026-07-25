package leetcode.designPatterns.Problems.striver.atm.repository.Impl;

import leetcode.designPatterns.Problems.striver.atm.domain.ATM;
import leetcode.designPatterns.Problems.striver.atm.domain.state.ATMState;
import leetcode.designPatterns.Problems.striver.atm.repository.ATMRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ATMRepositoryImpl implements ATMRepository {
    private Map<String, ATM> atmStore = new ConcurrentHashMap<>();

    @Override
    public ATM save(ATM atm) {
        atmStore.put(atm.getId(), atm);
        return atm;
    }

    @Override
    public Optional<ATM> findById(String atmId) {
        return Optional.ofNullable(atmStore.get(atmId));
    }

    @Override
    public List<ATM> findAll() {
        return new ArrayList<>(atmStore.values());
    }

    @Override
    public void updateATMState(String atmId, ATMState state) {
        Optional<ATM> atmOpt = findById(atmId);
        if (atmOpt.isPresent()) {
            atmOpt.get().setCurrentState(state);
        }
    }
}

