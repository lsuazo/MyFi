package common;


import java.time.LocalDate;

public class Transaction {
    private final LocalDate date;
    private final float amount;
    private final String description;
    private String category;

    public Transaction(LocalDate dt, float amnt, String desc) {
        date = dt;
        amount = amnt;
        description = desc;
    }

    static public enum Fields {
        DATE,
        AMOUNT,
        DESCRIPTION
    }

    public Object getField(Fields field) {
        switch (field) {
            case DATE:
                return getDate();
            case AMOUNT:
                return getAmount();
            case DESCRIPTION:
                return getDescription();
        }
        return null;
    }


    public LocalDate getDate() {
        return date;
    }

    public float getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
