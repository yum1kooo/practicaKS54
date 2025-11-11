package Service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataBase implements Serializable {
     private static LinkedHashMap<Integer, Task> taskDB = new LinkedHashMap<>();

    public void getAllTask(){ // краткое описание задачи с ее номером
        for(Map.Entry<Integer, Task> allTask : taskDB.entrySet()){
            System.out.println("ID задачи: " + allTask.getKey() + " Название: " + allTask.getValue());
        }
    }




    public void addTask(int id, Task task){ //добавляем задачу
        taskDB.putIfAbsent(id, task);
    }

    public Task searchTaskById(int id){
        return taskDB.get(id);
    }


    public void removeTaskById(int id){
        taskDB.remove(id);
    }

    @Override
    public String toString() {
        return "Service.DataBase{" +
                "taskDB=" + taskDB +
                '}';
    }
}

//
    //private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    //    in.defaultReadObject();
    //    LinkedHashMap<Integer, Task> loadedTaskDB = (LinkedHashMap<Integer, Task>) in.readObject();
    //    taskDB = loadedTaskDB; // Восстанавливаем статическое поле
//    }
//
//
    //private void writeObject(ObjectOutputStream out) throws IOException {
    //    out.defaultWriteObject();
    //    out.writeObject(taskDB); // Сериализуем статическое поле
//    }
//
    //public static LinkedHashMap<Integer, Task> getTaskDB() {
    //    return taskDB;
 //   }

