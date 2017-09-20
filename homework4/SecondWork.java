package geekbrains.homework4;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Второе задание
public class SecondWork {
    static BufferedOutputStream out;
    static byte b[] = new byte[30];
    public static void main(String[] args) throws Exception {
        CountDownLatch cdl = new CountDownLatch(3);
        SecondWork s = new SecondWork();
        ExecutorService serv = Executors.newFixedThreadPool(3);

        serv.execute(() -> {
            try {
                s.printA();
                Thread.sleep(20);
            } catch (InterruptedException e)
            {e.printStackTrace();
            }
            cdl.countDown();
            });

        serv.execute(() -> {
            try {
                s.printB();
                Thread.sleep(20);
            } catch (InterruptedException e)
            {e.printStackTrace();
            }
            cdl.countDown();
        });

        serv.execute(() -> {
            try {
                s.printC();
                Thread.sleep(20);
            } catch (InterruptedException e)
            {e.printStackTrace();
            }
            cdl.countDown();
        });

        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("END");
        out = new BufferedOutputStream(new FileOutputStream("test.txt"));
        for (int i = 0; i < b.length; i++) {
            out.write(b);
        }
        out.close();
    }

    public void printA() {
        for (int i = 0; i < 9; i++) {
            b[i]=(byte)i;
        }
    }
    public void printB() {
        for (int i = 10; i < 19; i++) {
            b[i]=(byte)i;
        }
    }
    public void printC() {
        for (int i = 20; i < 29; i++) {
            b[i]=(byte)i;
        }
    }
}
