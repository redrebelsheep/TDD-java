import java.util.ArrayList;
import java.util.stream.Collectors;

public class ShoppingCart {

    private ArrayList<LineItem> cart = new ArrayList<LineItem>();
    private int totalPrice = 0;
    private int totalQuantity = 0;

    public void addItem(LineItem item){
        totalPrice += item.getPrice();
        totalQuantity += item.getQuantity();
        cart.add(item);
    }

    public ArrayList<LineItem> getCart() {
        return cart;
    }


    public int getTotalQuantity() {
        return totalQuantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public ArrayList<Integer> itemQuantities() {
        ArrayList<LineItem> tmpList = new ArrayList<LineItem>();
        for(LineItem lineItem : cart){
           if(tmpList.stream().anyMatch(e -> e.getName().equals(lineItem.getName()))){
               int index = tmpList.indexOf(lineItem);
               tmpList.get(index).addQuantity(lineItem.getQuantity());
            }else {
               tmpList.add(lineItem);
           }
        }

        return (ArrayList<Integer>) tmpList.stream().map(e -> e.getQuantity()).collect(Collectors.toList());
    }


    public ArrayList<LineItem> onSaleItems() {
        ArrayList<LineItem> tmpList = new ArrayList<LineItem>();
        for(LineItem lineItem : cart){
            if(lineItem.isOnSale()){
                tmpList.add(lineItem);
            }
        }
        return tmpList;
    }
}
