package java_study.oop;

public class Account {
    int balance=0;

    void deposit(int amount) {
        balance += amount;
    }
    void widthdraw(int amount) {
        if (balance >= amount) {
          balance -= amount;
        } else {
            System.out.println("잔액 부족");

        }

    }

}
