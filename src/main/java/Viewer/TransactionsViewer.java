package main.java.Viewer;

import main.java.DataLayer.CapitalOneTranslator;
import main.java.common.TransactionList;

import javax.swing.*;
import java.io.File;

public class TransactionsViewer {
    JFrame frame = null;
    JTable table = null;

    public void setUpGUI() {

        CapitalOneTranslator translator = new CapitalOneTranslator();
        TransactionList transactionData  = translator.translate(new File("src/test/resources/2020-11_CapitalOne_spending.csv"));
        table = new JTable(transactionData);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        frame = new JFrame("Transaction main.java.Viewer");
        frame.getContentPane().add(scrollPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 900);
        frame.setVisible(true);

    }

    public static void main(String[] args){
        TransactionsViewer viewer = new TransactionsViewer();
        viewer.setUpGUI();
    }
}
