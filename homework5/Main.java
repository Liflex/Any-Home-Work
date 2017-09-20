package geekbrains.homework5;


import java.util.concurrent.CyclicBarrier;

public class Main {
    static CyclicBarrier cb = new CyclicBarrier(4, () -> System.out.println("ВАЖНОЕ ОБЪЯВЕНИЕ >>> Гонка началась!!!"));
    static CyclicBarrier cb1 = new CyclicBarrier(4, () -> System.out.println("ВАЖНОЕ ОБЪЯВЕНИЕ >>> Гонка закончилась!!!"));
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
    }
}