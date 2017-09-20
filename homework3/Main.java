package geekbrains.homework3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static Scanner scn = new Scanner (System.in);
    public static void main (String[] args) throws Exception {
        //Первое
        File file = new File("test.txt");
        if (!file.exists()) {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("test.txt"));
            for (int i = 0; i < 4000000; i++) {
                out.write(65);
                out.write(66);
                out.write(67);
            }
            out.close();
        }
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("test.txt"));
        StringBuilder sb = new StringBuilder("");
        int x;
        while ((x = in.read()) != -1) {
            System.out.println(sb.append((char) x));
        }

        in.close();
        //Второе задание
        SequenceInputStream seq;
        FileOutputStream out;
        ArrayList<FileInputStream> ali = new ArrayList<>();
        ali.add(new FileInputStream("test.txt"));
        ali.add(new FileInputStream("test2.txt"));
        ali.add(new FileInputStream("test3.txt"));
        ali.add(new FileInputStream("test4.txt"));
        ali.add(new FileInputStream("test5.txt"));

        seq = new SequenceInputStream(Collections.enumeration(ali));
        out = new FileOutputStream("test6.txt");
        int y;
        while ((y=seq.read()) != -1){
            out.write(y);
        }
        seq.close();
        out.close();
        //Третье
        int number = scn.nextInt();
        RandomAccessFile raf = new RandomAccessFile("test.txt", "r");
        raf.seek(page(number));
        byte b[] = new byte[1800];
        raf.read(b, 0, 1800);
        String s2 = new String (b);
        System.out.println(" "+s2);
    }
    public static int page(int number){
        int pageNumber = number*1800;
        return pageNumber;
    }
}
