package geekbrains.homework1;

public class Box<T extends String, N extends Integer> {
    private final T nameBox;
    private int N;
    private float weight=0;

    public Box(T nameBox, int countFruit) {
        this.nameBox = nameBox;
        this.N = countFruit;
        Weight();

    }

    public void addFruit(String fruitName, int count) {
        if (fruitName.equals(nameBox)) {
            setN(getN() + count);
        } else {
            System.out.println("Добавление прошло неудачно, вероятно такого фрукта не существует или ввели неверное имя");
        }
    }
    public void Weight(){
        if(nameBox.equals("apple")){
            Apple apple = new Apple();
            setWeight(apple.weight*getN());
        }else if(nameBox.equals("orange")){
            Orange orange = new Orange();
            setWeight(orange.weight*getN());
        }else System.out.println("Внимание: вы положили в коробку нечто, что не сходится с условиями задачи," +
                                " дальнейшее выполнение программы не гарантировано");
    }

    public void setN(int countFruit) {
        this.N = countFruit;
    }

    public int getN() {
        return N;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
    public float getWeight(){
        if(nameBox.equals("apple") || nameBox.equals("orange")){
            Weight();
            System.out.println("Вес коробки с "+ nameBox+" = "+weight+" кг");
            return weight;
        }else System.out.println("Вес коробки с "+nameBox+" невозможно определить"); return weight;
    }

}
