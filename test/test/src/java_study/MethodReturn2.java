package java_study;

public class MethodReturn2 {
    public static void main(String[] args) {

        Data data1 = new Data();
        Data data2 = new Data();

        initData(data1,"data1");
        initData(data2,"data2");

        initData(data1);
        initData(data2);
    }
    static void initData(Data data,String value) {
        data.value = value;
        System.out.println("initdata1 is == "+data);
    }
    static void initData(Data data) {
        System.out.println("initdata2 is == "+data);
        System.out.println("data is == "+data.value);
    }
}
