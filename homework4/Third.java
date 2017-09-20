package geekbrains.homework4;

//Третье задание.
public class Third {
    private final Object print = new Object();
    private final Object scan = new Object();
    static int i = 0;
    static int b = 0;
    public static void main(String[] args) {
        Third w = new Third();
        Thread Print = new Thread(() -> {
            while (true){
                try {
                    w.print();
                    Thread.sleep(50);
                } catch (InterruptedException e)
                {e.printStackTrace();
                }}
        });

        Thread Scan = new Thread(() -> {
            while (true){
                try {
                    w.scan();
                    Thread.sleep(50);
                } catch (InterruptedException e)
                {e.printStackTrace();
                }}
        });

        Scan.start();
        Print.start();

    }

    public void print() {
        synchronized (print) {
            i++;
            System.out.println("Печатаю страницу: "+i);
        }
    }

    public void scan() {
        synchronized (scan) {
            b++;
            System.out.println("Сканирую документ: "+b);
        }
    }
}
