package java_study.capsule;

public class ShoppingCart {
    private Item[] items = new Item[10];
    private int itemCount;

    public void addItem(Item item) {
        if (itemCount >= items.length) {
            System.out.println("장바구니가 꽉 찼습니다.");
            return;
        }

        items[itemCount] = item;
        itemCount++;
    }

    public void displayItem() {
        System.out.println("장바구니 상품 출력");
        int sum = 0;
        for (int i = 0 ; i<itemCount;i++) {
            Item item = items[i];
            System.out.println("상품명 : " + item.getName() + "가격은 : " + item.getTotalPriace());
            sum += item.getTotalPriace();
        }
        System.out.println("총 금액은 : " + totalPrice());
    }

    private int totalPrice() {
        int sum = 0;
        for (int i = 0 ; i<itemCount;i++) {
            Item item = items[i];
            sum += item.getTotalPriace();
        }
        return sum;
    }
}
