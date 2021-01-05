package main.java.DataLayer;

import main.java.common.CSVReader;
import main.java.common.Transaction;
import main.java.common.TransactionList;

import java.io.File;
import java.util.ArrayList;

public abstract class TransactionTranslator {

    public abstract Transaction processLine(String[] fields);

    public TransactionList translate(File file) {
        TransactionList retValue = new TransactionList();

        ArrayList<String[]> fields = CSVReader.readCSV(file);
        // removing header
        fields.remove(0);
        for(String[] line: fields) {
            retValue.addTransaction(processLine(line));
        }

        return retValue;
    }

}
