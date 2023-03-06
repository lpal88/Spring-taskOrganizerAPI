package iesrafaelalberti.apitarea.Repositories;

import iesrafaelalberti.apitarea.Models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
    // you can add more query's declaring specific methods

}
