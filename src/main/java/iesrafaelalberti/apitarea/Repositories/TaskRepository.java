package iesrafaelalberti.apitarea.Repositories;

import iesrafaelalberti.apitarea.Models.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task, Long> {
    // you can add more query's declaring specific methods

}
