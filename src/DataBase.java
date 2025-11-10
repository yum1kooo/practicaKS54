import java.util.LinkedHashMap;
import java.util.Map;

public class DataBase {
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
        return "DataBase{" +
                "taskDB=" + taskDB +
                '}';
    }
}
