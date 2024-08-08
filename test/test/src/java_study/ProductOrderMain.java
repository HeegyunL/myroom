package java_study;

public class ProductOrderMain {
    public static void main(String[] args) {
        ProductOrder[] orders = new ProductOrder[3];

        orders[0]=createOrder("두부",2000,2);
        orders[1]=createOrder("김치",5000,1);
        orders[2]=createOrder("콜라",1500,2);

        printOrder(orders);
        int totalPrice = getTotalPrice(orders);
        System.out.println("총 상품 가격 = "+totalPrice);
    }

    static ProductOrder createOrder(String name, int price, int amount) {
        ProductOrder order = new ProductOrder();
        order.product = name;
        order.price = price;
        order.amount = amount;

        return order;
    }

    static void printOrder(ProductOrder[] orders) {
        for (ProductOrder order : orders) {
            System.out.println("상품명: " + order.product + " 가격: " + order.price +" 수량: " + order.amount );
        }
    }

    static int getTotalPrice(ProductOrder[] orders) {
        int totalPrice = 0;
        for (ProductOrder order : orders) {
            totalPrice += order.price * order.amount;
        }
        return totalPrice;
    }
}
