package main.java.rules;

import main.java.common.Transaction;
import main.java.common.TransactionList;

import java.util.ArrayList;

public class AutoRules {
    final private ArrayList<CategoryRule> rules;

    public AutoRules( ) {
        this.rules = new ArrayList<>();
    }

    public void addRules(CategoryRule rule) { rules.add(rule); }

    public void applyToTransactions(TransactionList transactions) {
        for(Transaction transaction: transactions) {
            for(CategoryRule rule: rules) {
                if(rule.testTransaction(transaction)) {
                    transaction.setCategory(rule.getCategory());
                }
            }
        }
    }
}
