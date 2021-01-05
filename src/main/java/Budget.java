package main.java;

import main.java.common.CSVReader;

import java.io.File;
import java.util.ArrayList;

public class Budget {
    final private ArrayList<BudgetItem> items;

    public Budget() { items = new ArrayList<>();}

    public Budget(ArrayList<BudgetItem> budgetItems) {
        items = budgetItems;
    }

    static public Budget fromCSV(File csvFilePath) {
        Budget budget = new Budget();
        ArrayList<String[]> fields = CSVReader.readCSV(csvFilePath);
        for(String[] line : fields) {
            budget.addBudgetItem(new BudgetItem(line[0], Float.parseFloat(line[1])));
        }
        return budget;
    }

    public void addBudgetItem(BudgetItem budgetItem) { items.add(budgetItem); }
    public ArrayList<String> getBudgetCategories() {
        ArrayList<String> res = new ArrayList<>();
        for (BudgetItem item: items) {
            res.add(item.getName());
        }
        return res;
    }
}
