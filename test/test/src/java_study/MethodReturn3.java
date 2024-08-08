package java_study;

public class MethodReturn3 {
    public static void main(String[] args) {
        Data data1 =createData("data1");
        Data data2 =createData("data2");

        System.out.println("data is == "+data1);
        System.out.println("data is == "+data2);

        System.out.println("data is == "+data1.value);
        System.out.println("data is == "+data2.value);
        String[] arr = {"1", "2", "3", "4"};

    }
    static Data createData(String value) {

        Data createDate = new Data();
        System.out.println("create data is == "+createDate.value );
        createDate.value = value;
        System.out.println("create data is == "+createDate);
        return createDate;
    }

}
