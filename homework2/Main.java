package geekbrains.homework2;

import java.sql.*;
import java.util.Scanner;



        public class Main {
            static Scanner scanner = new Scanner (System.in);
            private static Connection connection;
            private static Statement stmt;
            private static PreparedStatement ps;
            private static ResultSet rs;


            public static void main(String[] args) throws Exception {
                connect();
                stmt = connection.createStatement();
                //creatBase();

                do {
                    System.out.println("Выберите операцию с базой товаров: ");
                    System.out.println("1)Вывести на экран товары с ценой от и до заданного диапозона");
                    System.out.println("2)Позволяет у нужного вам товара сменить цену");
                    System.out.println("3)");
                    int choice = scanner.nextInt();

                    if (choice == 1) {
                        System.out.println("Введите первое число");
                        int s1 = scanner.nextInt();
                        System.out.println("Введите второе число");
                        int s2 = scanner.nextInt();
                        rs = stmt.executeQuery("SELECT * FROM productBase WHERE cost >= " + s1 + " AND cost <= " + s2 + "");
                        while (rs.next()) {
                            System.out.println(rs.getInt("id")
                                    + " " + rs.getInt("idproduct")
                                    + " " + rs.getString("title")
                                    + " " + rs.getInt("cost"));
                        }
                    }else if (choice == 2) {
                        System.out.println("Введите имя товара у которого хотите сменить цену");
                        String select = scanner.next();
                        rs = stmt.executeQuery("SELECT * FROM productBase WHERE title = '"+select+"'");
                        while (rs.next()) {
                            System.out.println(rs.getInt("id")
                                    + " " + rs.getInt("idproduct")
                                    + " " + rs.getString("title")
                                    + " " + rs.getInt("cost"));
                        }
                        System.out.println("Введите цену на которую хотите заменить");
                        int s3 = scanner.nextInt();
                        stmt.executeUpdate("UPDATE productBase SET cost = "+s3+" WHERE title = '"+select+"'");
                        System.out.println("Молодец");
                    }else if (choice == 3) {
                    }
                }while (Cycle());
                scanner.close();

                disconnect();
            }

            public static void connect() {
                try {
                    Class.forName("org.sqlite.JDBC");

                    connection = DriverManager.getConnection("jdbc:sqlite:productBase.db");
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }

            public static void disconnect() {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            public static boolean Cycle (){ //Спрашивает нужно ли выполнить операцию с базой еще раз
                System.out.println("Хотите выполнить операцию с базой еще раз ? Введите Yes для повтора.");
                String exit = scanner.next();
                if (exit.equals("Yes")){
                    return true;
                } else return false;
            }

            public static void creatBase(){ //Проверяет наличие базы и заполняет её
                try {
                    stmt.execute("CREATE TABLE IF NOT EXISTS productBase (\n" +
                            "    id    INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                            "    idproduct  INTEGER,\n" +
                            "    title  TEXT,\n" +
                            "    cost INTEGER);");
                    connection.setAutoCommit(false);
                    ps = connection.prepareStatement("INSERT INTO productBase (idproduct, title, cost) VALUES (?, ?, ?)");
                    for (int i = 0; i < 10000; i++) {
                        ps.setInt(1, (i));
                        ps.setString(2, "Product" + i);
                        ps.setInt(3, (i + 1) * 10);
                        ps.addBatch();
                    }
                    ps.executeBatch();
                    connection.commit();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
