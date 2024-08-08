public class for_test {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                int result = i*j;
                System.out.println( i +"*" +j+"="+result);
            }
        }
    }
}