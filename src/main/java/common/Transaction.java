package main.java.common;


import java.time.LocalDate;

public class Transaction {
    private final LocalDate date;
    private final float amount;
    private final String description;
    private String category;
    private String notes;

    public Transaction(LocalDate dt, float amnt, String desc) {
        date = dt;
        amount = amnt;
        description = desc;
        category = "";
        notes = "";

    }


    public enum Fields {
        DATE,
        AMOUNT,
        DESCRIPTION,
        CATEGORY,
        NOTE,
    }

    public Object getField(Fields field) {
        return switch (field) {
            case DATE -> getDate();
            case AMOUNT -> getAmount();
            case DESCRIPTION -> getDescription();
            case CATEGORY -> getCategory();
            case NOTE -> getNotes();
        };
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
