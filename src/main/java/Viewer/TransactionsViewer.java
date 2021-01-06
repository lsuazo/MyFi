package main.java.Viewer;

import main.java.Budget;
import main.java.BudgetItem;
import main.java.DataLayer.CapitalOneTranslator;
import main.java.common.TransactionList;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.io.File;

public class TransactionsViewer {
    JFrame frame = null;
    JTable table = null;

    public void setUpGUI(Budget budget) {

        CapitalOneTranslator translator = new CapitalOneTranslator();
        TransactionList transactionData  = translator.translate(new File("src/test/resources/2020-11_CapitalOne_spending.csv"));
        TransactionListTable tableModel = new TransactionListTable(transactionData);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        TableColumn categoryColumn = table.getColumnModel().getColumn(tableModel.getCategoryColumnIndex());
        JComboBox comboBox = new JComboBox();
        for (BudgetItem budgetItem: budget) {
            comboBox.addItem(budgetItem.getName());
        }
        categoryColumn.setCellEditor(new DefaultCellEditor(comboBox));


        frame = new JFrame("Transaction main.java.Viewer");
        frame.getContentPane().add(scrollPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 900);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void main(String[] args){
        TransactionsViewer viewer = new TransactionsViewer();
        Budget budget = Budget.fromCSV(new File("src/test/resources/SampleBudget.csv"));
        viewer.setUpGUI(budget);
    }
}
