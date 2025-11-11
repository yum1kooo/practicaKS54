package User;

import Service.DataBase;

import java.io.*;
import java.util.Scanner;

public class Main implements Serializable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person person = new Person("Кирилл");
        DataBase db = new DataBase();


        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("database.dat"))) {
            DataBase loaded = (DataBase) ois.readObject();
            person.db = loaded;
            System.out.println("База данных успешно загружена!");
        } catch (FileNotFoundException e) {
            System.out.println("База данных не найдена");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке базы данных");
        }

        while (true) {
            System.out.println("Меню");
            System.out.println("1 Создать задачу");
            System.out.println("2 Показать все задачи");
            System.out.println("3 Изменить имя задачи");
            System.out.println("4 Изменить описание задачи");
            System.out.println("5 Изменить статус задачи");
            System.out.println("6 Посмотреть полностью задачу");
            System.out.println("7 Удалить задачу");
            System.out.println("0 Выход и сохранение");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    person.createNewTask();
                }
                case "2" -> {
                    db.getAllTask();
                }
                case "3" -> {
                    person.changeTaskName();
                }
                case "4" -> {
                    person.changeTaskDescription();
                }
                case "5" -> {
                    person.changeTaskStatus();
                }
                case "6" -> {
                    person.checFullTask();
                    break;
                }
                case "7" -> {
                    person.removeTask();
                }
                case "0" -> {
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("database.dat"))) {
                        oos.writeObject(person.db);
                        System.out.println("База данных успешно сохранена!");
                    } catch (IOException e) {
                        System.out.println("Ошибка при сохранении базы данных: " + e.getMessage());
                    }
                    System.out.println("Выход");
                    return;
                }
                default -> System.out.println("Некорректный ввод, попробуйте снова");
            }
        }
    }
}
