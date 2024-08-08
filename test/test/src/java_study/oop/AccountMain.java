package java_study.oop;

public class AccountMain {
    public static void main(String[] args) {
        Account account = new Account();
        account.deposit(10000);
        account.widthdraw(9000);
        account.widthdraw(2000);
        System.out.println("잔고 : " + account.balance);
    }
}
