package java_study;



public class Null {

    public static void main(String[] args) {
        Data data = new Data();

        //참조 변수는 기본적으로 Null이다. int는 0
        System.out.println(data.value);


        data.value = "data";
        System.out.println(data.value);


        data.value = null;
        System.out.println(data.value);
    }


}
