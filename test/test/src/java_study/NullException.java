package java_study;



public class NullException {

    public static void main(String[] args) {
        //null이 생기는 지점에 .을 찍고 데이터를 불러온다 생각하면 쉽다.
        Data data = null;
        data.value = "10";
        System.out.println(data.value);

    }


}
