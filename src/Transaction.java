import java.util.Date;

public class Transaction {
    private final Date date;
    private final float amount;
    private final String description;
    private String category;

    public Transaction(Date dt, float amnt, String desc) {
        date = dt;
        amount = amnt;
        description = desc;
    }


    public Date getDate() {
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
