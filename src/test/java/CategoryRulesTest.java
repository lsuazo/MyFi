import main.java.common.Transaction;
import main.java.common.TransactionList;
import main.java.rules.AutoRules;
import main.java.rules.ContainsStringRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CategoryRulesTest {
    @Test
    public void testContainsStringRulesDoesCorrectMatching(){
        ContainsStringRule rule = new ContainsStringRule("MCDONALD", "EatingOut");
        Transaction trans1 = new Transaction(null, 1, "MCDONALD'S F48");
        Transaction trans2 = new Transaction(null, 1, "MICKEY'S F48");

        Assertions.assertTrue(rule.testTransaction(trans1));
        Assertions.assertFalse(rule.testTransaction(trans2));

        Assertions.assertEquals(rule.getCategory(), "EatingOut");
    }

    @Test
    public void testAutoRulesApplicationWorksAsExpected() {
        ContainsStringRule rule1 = new ContainsStringRule("MCDONALD", "EatingOut");
        ContainsStringRule rule2 = new ContainsStringRule("HBO", "Entertainment");

        Transaction trans1 = new Transaction(null, 1, "MCDONALD'S F48");
        Transaction trans2 = new Transaction(null, 1, "MICKEY'S F48");
        Transaction trans3 = new Transaction(null, 1, "HBOMAX");

        TransactionList transactions = new TransactionList();
        transactions.addTransaction(trans1);
        transactions.addTransaction(trans2);
        transactions.addTransaction(trans3);
        transactions.addTransaction(trans1);

        AutoRules autoRules = new AutoRules();
        autoRules.addRules(rule1);
        autoRules.addRules(rule2);

        autoRules.applyToTransactions(transactions);

        ArrayList<String> categories = new ArrayList<>();
        for(Transaction transaction: transactions) {
            categories.add(transaction.getCategory());
        }

        Assertions.assertEquals(categories, List.of("EatingOut", "", "Entertainment", "EatingOut"));
    }
}
