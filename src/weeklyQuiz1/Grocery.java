package weeklyQuiz1;

public class Grocery extends Product {
    static private final int discount = 2000;

    public Grocery(String name, int price, int weight ) {
        super(name, price, weight,discount);
    }
}
