package java_study.extends1.access.parent;

public class Parent {
    public int publicValue;
    protected int protectedValue;
    int defaultValue;
    private int privateValue;

    public void publicMethod() {
        System.out.println("Parent.publicMethod");

    }
    protected void protectedMethod() {
        System.out.println("Parent.publicMethod");

    }
    void defaultMethod() {
        System.out.println("Parent.publicMethod");

    }
    private void privateMethod() {
        System.out.println("Parent.publicMethod");

    }

    public void printParent() {
        System.out.println("==Parent 메서드 안 ==");
        System.out.println("publicValue = " + publicValue);
        System.out.println("publicValue = " + protectedValue);
        System.out.println("publicValue = " + defaultValue);
        System.out.println("publicValue = " + privateValue);

        //부모 메서드 안에서 모두 접근 가능
        defaultMethod();
        privateMethod();
    }
}
