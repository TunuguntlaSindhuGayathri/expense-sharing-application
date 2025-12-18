package com.example.expensesharing.service;

import com.example.expensesharing.model.Expense;
import com.example.expensesharing.model.Split;
import com.example.expensesharing.model.SplitType;
import com.example.expensesharing.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    @Autowired
    private BalanceService balanceService;

    public void addExpense(Expense expense) {
        User paidBy = expense.getPaidBy();
        double totalAmount = expense.getAmount();

        if (expense.getSplitType() == SplitType.EQUAL) {
            handleEqualSplit(expense, paidBy, totalAmount);
        }
        else if (expense.getSplitType() == SplitType.EXACT) {
            handleExactSplit(expense, paidBy);
        }
        else if (expense.getSplitType() == SplitType.PERCENTAGE) {
            handlePercentageSplit(expense, paidBy, totalAmount);
        }
    }

    private void handleEqualSplit(Expense expense, User paidBy, double totalAmount) {
        double share = totalAmount / expense.getSplits().size();

        for (Split split : expense.getSplits()) {
            if (!split.getUser().getUserId().equals(paidBy.getUserId())) {
                balanceService.updateBalance(split.getUser(), paidBy, share);
            }
        }
    }

    private void handleExactSplit(Expense expense, User paidBy) {
        for (Split split : expense.getSplits()) {
            if (!split.getUser().getUserId().equals(paidBy.getUserId())) {
                balanceService.updateBalance(
                        split.getUser(),
                        paidBy,
                        split.getAmount()
                );
            }
        }
    }

    private void handlePercentageSplit(Expense expense, User paidBy, double totalAmount) {
        for (Split split : expense.getSplits()) {
            double share = (split.getPercentage() / 100) * totalAmount;

            if (!split.getUser().getUserId().equals(paidBy.getUserId())) {
                balanceService.updateBalance(split.getUser(), paidBy, share);
            }
        }
    }
}
