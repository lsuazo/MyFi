package main.java.common;

import java.util.ArrayList;
import java.util.Map;

public class TransactionList{
    final public static Map<Integer, Transaction.Fields> fieldNames = Map.of(
            0, Transaction.Fields.DATE,
            1, Transaction.Fields.AMOUNT,
            2, Transaction.Fields.DESCRIPTION,
            3, Transaction.Fields.CATEGORY,
            4, Transaction.Fields.NOTE
    );

    final private ArrayList<Transaction> transactions;

    public TransactionList() { transactions = new ArrayList<>(); }
    public Transaction getTransaction(int number) { return this.transactions.get(number);}
    public void addTransaction(Transaction transaction) { transactions.add(transaction); }
    public int length(){ return transactions.size(); }
}
