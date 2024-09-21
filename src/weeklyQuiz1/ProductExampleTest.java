package weeklyQuiz1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductExampleTest {

    @Test
    public void testCalculateDeliveryCharge() {
        // Given
        Product beauty = new Beauty("beauty", 30000, 2);
        Product grocery = new Grocery("grocery", 20000, 3);
        Product largeAppliance = new LargeAppliance("largeAppliance", 50000, 5);

        Cart cart = new Cart(new Product[] {beauty, grocery, largeAppliance});

        //When
        int totalDeliveryCharge = cart.calculateDeliveryCharge();

        //Then
        assertEquals(9000,totalDeliveryCharge, "가격 불일치");

    }
}