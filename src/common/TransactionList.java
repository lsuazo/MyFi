package common;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Map;

public class TransactionList extends AbstractTableModel {
    Map<Integer, Transaction.Fields> columnNames = Map.of(
            0, Transaction.Fields.DATE,
            1, Transaction.Fields.AMOUNT,
            2, Transaction.Fields.DESCRIPTION
    );

    private ArrayList<Transaction> transactions;

    public TransactionList() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public int length(){
        return transactions.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column).name();
    }

    @Override
    public int getRowCount() {
        return this.length();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Transaction trans = transactions.get(rowIndex);
        return trans.getField(columnNames.get(columnIndex));
    }
}
