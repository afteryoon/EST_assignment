package weeklyQuiz1;

public abstract class Product implements Promotion {
    //객체의 상태 변경을 방지
    private final String name;
    private final int price;
    private final int weight;
    private final int discountAmount;

    public Product(String name, int price, int weight, int discountAmount) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.discountAmount = discountAmount;
    }

    @Override
    public int getDiscountAmount() {
        return discountAmount;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    //구현 메서드
    public int getDiscountedPrice() {
        return price - discountAmount;
    }

}

