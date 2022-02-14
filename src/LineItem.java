public class LineItem {

    private int price;
    private int quantity;
    private boolean onSale;
    private String name;

    public LineItem(int price, int quantity, boolean onSale, String name) {
        this.price = price;
        this.quantity = quantity;
        this.onSale = onSale;
        this.name = name;
    }



    public boolean isOnSale() {
        return onSale;
    }

    public LineItem(int price, String name) {
        this.price = price;
        this.name = name;
        this.quantity = 1;
        this.onSale = false;

    }

    public String getName() {
        return name;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

}
