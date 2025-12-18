package com.example.expensesharing.controller;

import com.example.expensesharing.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/balances")
public class BalanceSheetController {

    @Autowired
    private BalanceService balanceService;

    @GetMapping
    public Map<String, Map<String, Double>> getBalanceSheet() {
        return balanceService.getBalances();
    }
}
