package weeklyQuiz1;

public class Beauty extends Product {
    static private final int discount = 10000;

    public Beauty(String name, int price, int weight ) {
        super(name, price, weight,discount);
    }

}
