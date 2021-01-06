package main.java;

import main.java.common.CSVReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class Budget implements Iterable<BudgetItem>{
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

    public Iterator<BudgetItem> iterator() {
        return new BudgetIterator();
    }

    class BudgetIterator implements Iterator<BudgetItem> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < items.size();
        }

        @Override
        public BudgetItem next() {
            return items.get(index++);
        }
    }
}
