package java_study;



public class NullException2 {

    public static void main(String[] args) {

        BigData bigData = new BigData();
        System.out.println("count is = " + bigData.count);
        System.out.println("data is = " + bigData.data);

        System.out.println("data.value is = " + bigData.data.value);

    }


}
