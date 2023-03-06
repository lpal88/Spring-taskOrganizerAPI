package iesrafaelalberti.apitarea.Controllers;

import iesrafaelalberti.apitarea.Models.Task;
import iesrafaelalberti.apitarea.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;


@RestController
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping("/pictograms/add")
    public String addPictogram(@RequestParam("description") String description,
                         @RequestParam("pictogram") MultipartFile pictogram)
            throws IOException {
        return taskService.addTask(description, pictogram);
    }

    @GetMapping("/pictograms/{id}")
    public String getPictogram(@PathVariable String id) {
        Task image = taskService.getImage(id);
        return "<img src=\"data:image/jpeg;base64, " + Base64.getEncoder().encodeToString(image.getPictogram().getData()) + "\">";
    }
}