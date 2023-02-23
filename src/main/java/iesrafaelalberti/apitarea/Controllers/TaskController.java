package iesrafaelalberti.apitarea.Controllers;

import iesrafaelalberti.apitarea.Models.Task;
import iesrafaelalberti.apitarea.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks")
    public ResponseEntity<Object> taskList() {
        return new ResponseEntity<>(taskRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/tasks/{id}")
    public ResponseEntity<Object> taskShow(@PathVariable("id") Long id) {
        return new ResponseEntity<>(taskRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/tasks/create")
    public ResponseEntity<Object> taskCreate(@RequestBody Task task) {
        taskRepository.save(task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @RequestMapping(value="/tasks/{id}", method={RequestMethod.PUT, RequestMethod.GET})
    public ResponseEntity<Object> taskUpdate(@PathVariable("id") Long id, @RequestBody Task task) {
        Optional<Task> oldTask = taskRepository.findById(id);
        if(oldTask.isPresent()) {
            task.setId(id);
            taskRepository.save(task);
            return new ResponseEntity<>(task, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/tasks/{id}", method={RequestMethod.DELETE, RequestMethod.GET})
    public ResponseEntity<Object> taskDelete(@PathVariable("id") Long id) {
        Optional<Task> task =  taskRepository.findById(id);
        task.ifPresent(value ->  taskRepository.delete(value));
        return new ResponseEntity<>(task.isPresent(), HttpStatus.OK);
    }
}