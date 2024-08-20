package java_study.capsule;

public class Item {
    private String vege;
    private int price;
    private int amount;

    public Item(String vege,int price, int amount) {
        this.vege = vege;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return vege;
    }

    public int getTotalPriace() {
        return price * amount;
    }

}
