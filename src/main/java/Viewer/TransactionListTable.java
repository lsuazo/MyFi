package main.java.Viewer;

import main.java.common.Transaction;
import main.java.common.TransactionList;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Map;

public class TransactionListTable extends AbstractTableModel {
    final private TransactionList transactions;

    public TransactionListTable(TransactionList transactions) {
        this.transactions = transactions;
    }


    @Override
    public int getRowCount() { return this.transactions.length(); }

    @Override
    public int getColumnCount() { return TransactionList.fieldNames.size(); }

    @Override
    public String getColumnName(int column) { return TransactionList.fieldNames.get(column).name(); }

    public int getCategoryColumnIndex() {
        for(Map.Entry<Integer, Transaction.Fields> entry: TransactionList.fieldNames.entrySet()) {
            if(entry.getValue() == Transaction.Fields.CATEGORY) {
                return entry.getKey();
            }
        }
        return -1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Transaction transaction = this.transactions.getTransaction(rowIndex);
        return transaction.getField(TransactionList.fieldNames.get(columnIndex));
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        ArrayList<Transaction.Fields> editable = new ArrayList<>(){{
            add(Transaction.Fields.CATEGORY);
            add(Transaction.Fields.NOTE);
        }};
        return editable.contains(TransactionList.fieldNames.get(col));
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        transactions.getTransaction(row).setField(TransactionList.fieldNames.get(col), (String) value);
    }
}
