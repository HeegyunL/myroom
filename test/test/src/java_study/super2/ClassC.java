package java_study.super2;

public class ClassC extends ClassB {
    public ClassC() {
        super(10,20);    //classB의 기본생성자를 생성 못함 이미 다른것들이 만들어져 있기에
        System.out.println("ClassC 생성자");
    }
}
