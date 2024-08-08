import java.util.Scanner;

public class calculate {

    public static void  main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        String cal = sc.next();
        int b = sc.nextInt();

        switch (cal) {
            case "+":
                addtion(a,b);
                break;
            case "-":
                subtraction(a,b);
                break;
            case "*":
                multiplication(a,b);
                break;
            case "/":
                division(a,b);
                break;

        }

    }

    public static void addtion(int a, int b) {
        System.out.println(a + b);
    }
    public static void subtraction(int a, int b) {
        System.out.println(a - b);
    }
    public static void multiplication(int a, int b) {
        System.out.println(a * b);
    }
    public static void division(int a, int b) {
        System.out.println(a / b);
    }
}
