import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    ShoppingCart codeUnderTest;

    @BeforeEach
    void init(){
        codeUnderTest = new ShoppingCart();
    }

    @Test
    void shoppingCartIsEmpty() {
        assertTrue(codeUnderTest.getCart().isEmpty());
    }

    @Test
    void shoppingCartGetTotalPrice() {
        // Given
        int expected =6;
        LineItem lineItem = new LineItem(6, "Binre");
        codeUnderTest.addItem(lineItem);

        // when
        int actual = codeUnderTest.getTotalPrice();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    void shoppingCartQuantity() {
        // Given
        int expected =2;
        LineItem lineItem = new LineItem(6, "apfel");
        LineItem lineItem2 = new LineItem(3, "birne");

        codeUnderTest.addItem(lineItem);
        codeUnderTest.addItem(lineItem2);

        // when
        int actual = codeUnderTest.getTotalQuantity();

        // Then
        assertEquals(expected, actual);

    }


    @Test
    void shoppingCartTestitemQuantities() {
        // Given
        ArrayList<Integer> listTemp = new ArrayList<>();
        listTemp.add(1);
        listTemp.add(2);

        LineItem lineItem = new LineItem(6, "Apfel");
        LineItem lineItem2 = new LineItem(3,"Birne");
        LineItem lineItem3 = new LineItem(3,"Birne");

        codeUnderTest.addItem(lineItem);
        codeUnderTest.addItem(lineItem2);

        // when
        ArrayList<Integer> actuaList = codeUnderTest.itemQuantities();

        // Then
        assertEquals(listTemp, actuaList);

    }


    @Test
    void shoppingCartTestonSaleItems() {
        // Given

        ArrayList<LineItem> listTemp = new ArrayList<>();

        LineItem lineItem = new LineItem(6,1,false, "Apfel");
        LineItem lineItem2 = new LineItem(3, 1, true, "Birne");
        LineItem lineItem3 = new LineItem(3, 1, true, "Birne");

        listTemp.add(lineItem2);
        listTemp.add(lineItem3);

        codeUnderTest.addItem(lineItem);
        codeUnderTest.addItem(lineItem2);

        // when
        ArrayList<LineItem> actuaList = codeUnderTest.onSaleItems();

        // Then
        assertEquals(listTemp, actuaList);

    }




}
