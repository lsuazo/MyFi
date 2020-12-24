package DataLayer;

import common.Transaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CapitalOneTranslator extends TransactionTranslator {
    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);

    private final int dateField = 0;
    private final int amountField = 5;
    private final int descriptionField = 3;

    @Override
    public Transaction processLine(String[] fields) {
        if (fields[amountField].equals("")) {
            fields[amountField] = "-"+fields[6];
        }

        String dateString =  fields[dateField];
        LocalDate date = LocalDate.parse(dateString, dateFormatter);
        float amount =  Float.parseFloat(fields[amountField]);
        String description = fields[descriptionField];
        return new Transaction(date, amount, description);
    }
}
