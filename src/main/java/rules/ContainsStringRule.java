package main.java.rules;

import main.java.common.Transaction;

public class ContainsStringRule implements CategoryRule{
    private final String keyString;
    private final String toCategory;

    public ContainsStringRule(String keyString, String toCategory) {
        this.keyString = keyString;
        this.toCategory = toCategory;
    }

    @Override
    public boolean testTransaction(Transaction transaction) {
        return transaction.getDescription().contains(keyString);
    }

    @Override
    public String getCategory() {
        return this.toCategory;
    }

    @Override
    public String toString() {
        return "Contains(" + keyString + ") --> " + toCategory;
    }
}
