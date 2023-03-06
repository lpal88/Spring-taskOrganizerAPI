package iesrafaelalberti.apitarea.Services;

import iesrafaelalberti.apitarea.Models.Task;
import iesrafaelalberti.apitarea.Repositories.TaskRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public String addTask(String description, MultipartFile file) throws IOException {
        Task task = new Task(description);
        task.setPictogram(
                new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        task = taskRepository.insert(task);
        return task.getId();
    }

    public Task getImage(String id) {
        return taskRepository.findById(id).get();
    }
}