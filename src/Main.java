import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Кирилл");
        DataBase db = new DataBase();
        Task taskTest = new Task("asd", "asd", "asd");
        Task taskTest2 = new Task("2", "asd", "asd");


        db.addTask(1, taskTest);
        db.addTask(2, taskTest);

        db.getAllTask();

        person.removeTask();

        db.getAllTask();
    }
}