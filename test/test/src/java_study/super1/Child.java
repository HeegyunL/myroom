package java_study.super1;

public class Child extends Parent{
    public String value = "child";

    @Override
    public void hello() {
        System.out.println("Child, hello");

    }

    public void call() {
        System.out.println("Child == " + this.value );
        System.out.println("Parent == " + super.value ); //super를 통해서 부모 클래스를 접근가능

        this.hello();
        super.hello();

    }

}
