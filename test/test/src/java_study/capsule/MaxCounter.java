package java_study.capsule;

public class MaxCounter {
    private int count;
    private int max;
    public MaxCounter(int num) {
         max = num;

    }
//      내가 한거
//    public void increment() {
//        if (max <= count) {
//            System.out.println("최대값을 초과할 수 없습니다.");
//        }
//        if (max > count) {
//
//            count++;
//        }
//    }


    public void increment() {
        //return을 하면 종료
        if (max <= count) {
            System.out.println("최대값을 초과할 수 없습니다.");
            return;
        }
        count++;


    }

    public int getCount() {
        return count;
    }
}
