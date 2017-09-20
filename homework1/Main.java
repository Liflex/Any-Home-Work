package geekbrains.homework1;

public class Main {
    public static void main(String[] args) {
        Box<String, Integer> boxFruitApple = new Box<>("apple", 20); //Почему Integer зачёркнут ?
        boxFruitApple.addFruit("apple", 11);/*Можно было обойтись и без fruitName, но
                                                        По логике подумал:А вдруг мы нарочно захотим
                                                        Кинуть туда другой фрукт и посмотреть на реакцию хайтек деревянной коробки*/
        boxFruitApple.getWeight();
        /*
        Опустил методы пересыпания фруктов.. По сути тут это реализовано.. там убавил, а там прибавил..
        Для ленивых просто вписать метод принимающим два инта и сравнение типа фруктов в коробке..
        Ручками)))
         */
    }
}
