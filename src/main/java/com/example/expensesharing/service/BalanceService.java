package com.example.expensesharing.service;

import com.example.expensesharing.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BalanceService {

    // balances[fromUserId][toUserId] = amount
    private final Map<String, Map<String, Double>> balances = new HashMap<>();

    public void updateBalance(User from, User to, double amount) {
        balances.putIfAbsent(from.getUserId(), new HashMap<>());

        Map<String, Double> userBalances = balances.get(from.getUserId());
        userBalances.put(
                to.getUserId(),
                userBalances.getOrDefault(to.getUserId(), 0.0) + amount
        );
    }

    public Map<String, Map<String, Double>> getBalances() {
        return balances;
    }

    // Optional: Clear balances (useful for testing)
    public void clearBalances() {
        balances.clear();
    }
}
