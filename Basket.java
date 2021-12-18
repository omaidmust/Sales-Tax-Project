/**
 *
 * @author omaidmustafa
 *  1/19/21
 */
import java.text.DecimalFormat;
import java.util.ArrayList;


public class Basket {
    ArrayList<Item> itemList = new ArrayList<Item>();
    DecimalFormat decimalFormat = new DecimalFormat("#.00");

    public void addToBasket(Item userInput){
      itemList.add(userInput);
    }
    public void displayList() {
        for(Item i : itemList){
            System.out.println(i);
        }
    }

    public double getSubtotal(){
        double subtotal = 0;
        for(Item i : itemList){
            subtotal = subtotal + i.getSubTotal();
        }
        return subtotal;
    }
    public double getSalesTaxes(){
        double taxes = 0;
        for(Item i : itemList) {
            taxes = taxes + i.getTax();
        }
        return taxes;
    }
    public double total(){
        double total = getSalesTaxes() + getSubtotal();
        return total;
    }

    @Override
    public String toString() {
        return "Subtotal = " + decimalFormat.format(getSubtotal()) + "\n"
        + "Sales Tax = " + decimalFormat.format(getSalesTaxes()) + "\n"
        + "Total = " + decimalFormat.format(total());
    }
}