package java_study.static_study;

public class CountMain {
    public static void main(String[] args) {
        Count count1 = new Count("data1");
        System.out.println("data1 = " + Count.count);
        Count count2 = new Count("data2");
        System.out.println("data2 = " + Count.count);
    }
}
