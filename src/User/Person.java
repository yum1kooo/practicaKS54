package User;

import Service.DataBase;
import Service.Task;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Person implements Serializable {
    private String name;

    transient Scanner scanner = new Scanner(System.in);
    DataBase db = new DataBase();
    Task task = new Task("0", "0", "0");

    public Person(String name) {
        this.name = name;
    }

    public void removeTask(){ //удаляет задачу по id
        while (true) {
            try {
                System.out.println("Введите id задачи которую вы хотите удалить");
                System.out.println("0 - для выхода");
                int id = scanner.nextInt();
                scanner.nextLine();

                if(id == 0){
                    break;
                }

                Task removeTask = db.searchTaskById(id);

                if (removeTask == null) {
                    System.out.println("По такому id задачи не найдено!");
                } else {
                    System.out.println("Вы точно хотите удалить?");
                    String choice = scanner.nextLine().trim().toLowerCase();
                    switch (choice) {
                        case "да": {
                            db.removeTaskById(id);
                            return;
                        }
                        case "нет": {
                            return;
                        }
                        default: {
                            System.out.println("Некоректный ввод");
                            scanner.nextLine();
                            break;
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод");
                scanner.nextLine();
            }
        }
    }


    public void changeTaskName() {  // Меняет название задачи
        while (true) {
            try {
                System.out.println("Введите id задачи который вы хотите поменять имя!");
                System.out.println("0 - для выхода");
                int id = scanner.nextInt();
                scanner.nextLine();

                Task t1 = db.searchTaskById(id);

                    if(id == 0){
                      return;
                    }
                if (t1 == null) {
                    System.out.println("По такому id задачи не найдено!");
                } else {
                    System.out.println("Введите новое имя задачи");
                    String changName = scanner.nextLine();
                    t1.setName(changName);
                    System.out.println("Новое имя задачи " + t1.getName());
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод");
                scanner.nextLine();
            }
        }

    }
        public void changeTaskDescription() { // меняем описание задачи
            while (true) {
                try {
                    System.out.println("Введите id задачи который вы хотите поменять описание!");
                    System.out.println("0 - для выхода");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Task t1 = db.searchTaskById(id);

                    if(id == 0){
                        return;
                    }
                    if (t1 == null) {
                        System.out.println("По такому id задачи не найдено!");
                    } else {
                        System.out.println("Введите новое описание задачи");
                        String changDescription = scanner.nextLine();
                        t1.setDescription(changDescription);
                        System.out.println("Новое описание задачи " + t1.getDescription());
                        return;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Неверный ввод");
                    scanner.nextLine();
                }
            }
        }

        public void changeTaskStatus(){ // меняем статус задачи
            while (true) {
                try {
                    System.out.println("Введите id задачи которой вы хотите поменять статус!");
                    System.out.println("0 - для выхода");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Task t1 = db.searchTaskById(id);

                    if(id == 0){
                        return;
                    }
                    if (t1 == null) {
                        System.out.println("По такому id задачи не найдено!");
                    } else {
                        System.out.println("Введите новый статус задачи");
                        String changStatus = scanner.nextLine();
                        t1.setStatus(changStatus);
                        System.out.println("Новое статус задачи" + t1.getStatus());
                        return;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Неверный ввод");
                    scanner.nextLine();
                }
            }
        }

    public void createNewTask() { // создаем задачи
        int id;
        while (true) {
            try {
                System.out.println("Введите имя");
                String namee = scanner.nextLine();

                System.out.println("Описание");
                String description = scanner.nextLine();

                System.out.println("Введите статус");
                String status = scanner.nextLine();

                while (true) {
                    try {
                        System.out.println("Под каким номером будет находиться задача:");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка ввода. Пожалуйста, введите числовой ID.");
                        scanner.nextLine();
                    }
                }

                Task newTask = new Task(namee, description, status);
                db.addTask(id, newTask);
                return;

            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода. Пожалуйста, введите числовой ID.");
                scanner.nextLine();
            }
        }
    }

    public void checFullTask() { //просмотр полной задачи
        while (true) {
            try {
                System.out.println("Введите id задачи для просмотра");
                System.out.println("0 - выход");
                int searchId = scanner.nextInt();

                Task t1 = db.searchTaskById(searchId);
                System.out.println("Название:" + t1.getName() + " Описание: " + t1.getDescription() + " Статус: " + t1.getStatus());

                if(searchId == 0)
                    break;

            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод");
                scanner.nextLine();
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
