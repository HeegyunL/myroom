package java_study;

public class MethodReturn {
    public static void main(String[] args) {
        int number = 5;
        System.out.println("1. number is = " + number);

        //자바는 항상 값을 대입 하거나 어떤 상태를 변경 시킬 때 값을 복사 해서 사용 -> main의 number와 calNumber 안의 number는 다른 객체다.
        //결과 값이 변경된 걸 받고 싶다면
        //number = calNumber(number); 로 해야 한다.

        calNumber(number);
        System.out.println("4. number is = " + number);


    }
    public static void calNumber(int number) {
        System.out.println("2. number is = " + number);
        number *= 2;
        System.out.println("3. number is = " + number);
    }
}
