/**
 *
 * @author omaidmustafa
 *  1/19/21 
 */
import java.util.Scanner; 


public class SalesTaxPro {

    public static void main(String[] args) {
        Basket basket = new Basket();
        Scanner keyboard = new Scanner(System.in);
        int quantity;
        double price;
        String name, isExempt, isImported, yOrN;
        do {
            quantity = Validator.getInt(keyboard,"Enter Quantity: ", 1, 100 );
            price = Validator.getDouble(keyboard,"Enter Price: ", 0, Double.MAX_VALUE);
            System.out.println("Enter Product Name: ");
            name = keyboard.nextLine();
            System.out.println("Is the product exempt: food, book, or medical (y/n): ");
            isExempt = keyboard.nextLine();
            Validator.yOrNValid(isExempt);
            System.out.println("Is the product imported? (y/n): ");
            isImported = keyboard.nextLine();
            Validator.yOrNValid(isImported);

            Item item = null;
            if (isExempt.equalsIgnoreCase("y")) {
                item = new ExemptGoods(price, name, quantity, isImported);

            } else if (isExempt.equalsIgnoreCase("n")) {
                item = new NonExemptGoods(price, name, quantity, isImported);
            }
            basket.addToBasket(item);
            System.out.println("Add another item? (y/n)");
            yOrN = keyboard.nextLine();
            yOrN = Validator.yOrNValid(yOrN);
        }while(yOrN.equalsIgnoreCase("y"));
        basket.displayList();
        System.out.println(basket);
        System.out.println("\n Thanks for shopping with us!");
    }
}
