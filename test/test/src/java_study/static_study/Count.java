package java_study.static_study;

public class Count {
    String name;
    public static int count;

    public Count(String name) {
        this.name = name;
        Count.count++;

    }
}




