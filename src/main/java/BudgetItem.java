package main.java;

public class BudgetItem {
    private final String name;
    private final float amount;

    public BudgetItem(String name, float amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() { return name; }
    public float getAmount() { return amount; }
}
