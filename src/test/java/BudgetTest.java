import main.java.Budget;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

public class BudgetTest {
    @Test
    public void testCanReadBudgetFromCSV() {
        Budget budget = Budget.fromCSV(new File("src/test/resources/SampleBudget.csv"));
        ArrayList<String> categories = budget.getBudgetCategories();
        String[] expected = {"Mortgage", "Food", "Savings", "Entertainment"};
        Assertions.assertArrayEquals(expected, categories.toArray());
    }
}
