package java_study;

public class gop {
    public static void main(String[] args) {
        Long result=100L;
        for (int i = 1; i < 31; i++) {
            result *= 2;
            System.out.println(i+"일 = " + result);
        }
        System.out.println(result);
    }
}
