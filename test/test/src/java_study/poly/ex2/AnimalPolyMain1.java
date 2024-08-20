package java_study.poly.ex2;

public class AnimalPolyMain1 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();
        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(caw);

        }

        //부모는 자식을 참조 할수 있다 = 다형적 참조  //를 이용하여 묶음
    private static void soundAnimal(Animal animal){
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");

    }
}
