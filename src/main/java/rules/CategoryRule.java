package main.java.rules;

import main.java.common.Transaction;

public interface CategoryRule {
    boolean testTransaction(Transaction transaction);
    String getCategory();
}
