package main.java;

public class BudgetItem {
    private final String name;
    private final float amount;

    public BudgetItem(String n, float amnt) {
        name = n;
        amount = amnt;
    }

    public String getName() { return name; }
    public float getAmount() { return amount; }
}
