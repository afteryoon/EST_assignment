package weeklyQuiz1;
import java.util.Arrays;

public class Cart {
    private static final int WEIGHT_THRESHOLD_1 = 3;
    private static final int WEIGHT_THRESHOLD_2 = 10;
    private static final int PRICE_THRESHOLD_1 = 30000;
    private static final int PRICE_THRESHOLD_2 = 100000;
    private static final int DELIVERY_FEE_1 = 1000;
    private static final int DELIVERY_FEE_2 = 5000;
    private static final int DELIVERY_FEE_3 = 10000;

    private Product[] products;

    public Cart(){};
    public Cart(Product[] products) {
        this.products = products;
    }

    public int calculateDeliveryCharge() {
        int sumWeight = Arrays.stream(products).mapToInt(Product::getWeight).sum();
        int sumAmount = Arrays.stream(products).mapToInt(Product::getDiscountedPrice).sum();

        int deliveryDiscount = sumAmount < PRICE_THRESHOLD_1 ? 0 :
                sumAmount >= PRICE_THRESHOLD_2 ? sumAmount : DELIVERY_FEE_1;

        if (sumAmount == deliveryDiscount) {
            return 0;
        }

        int deliveryAmount = sumWeight < WEIGHT_THRESHOLD_1 ? DELIVERY_FEE_1 :
                sumWeight >= WEIGHT_THRESHOLD_2 ? DELIVERY_FEE_3 : DELIVERY_FEE_2;

        return Math.max(0, deliveryAmount - deliveryDiscount);
    }

}
