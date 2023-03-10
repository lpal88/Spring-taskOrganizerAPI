package iesrafaelalberti.apitarea.BootStrap;

import iesrafaelalberti.apitarea.Models.Board;
import iesrafaelalberti.apitarea.Models.Task;
import iesrafaelalberti.apitarea.Models.User;
import iesrafaelalberti.apitarea.Models.Userlo;
import iesrafaelalberti.apitarea.Repositories.UserRepository;
import iesrafaelalberti.apitarea.Repositories.BoardRepository;
import iesrafaelalberti.apitarea.Repositories.TaskRepository;
import iesrafaelalberti.apitarea.Repositories.UserloRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Seeder implements CommandLineRunner {
    @Autowired
    private UserloRepository userloRepository;
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String[] args) {
        // Create sample entities for testing purposes
        Userlo u1, u2;
        Board b1, b2;
        Task t1, t2;
        User user1 = new User("paca", "aitortilla");
        userRepository.save(user1);
        u1 = userloRepository.save(new Userlo("daniela", "pestillo"));
        u2 = userloRepository.save(new Userlo("teresa", "pestillo"));
        b1 = boardRepository.save(new Board("morning",u1));
        b2 = boardRepository.save(new Board("afternoon", u2));
        t1 = taskRepository.save(new Task("comer"));
        t2 = taskRepository.save(new Task("piscina"));
    }
}