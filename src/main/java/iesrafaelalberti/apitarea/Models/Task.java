package iesrafaelalberti.apitarea.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;
@Document(collection = "pictograms")
@Entity @Getter @Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;

    @JsonBackReference
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private Set<Board_Task> boards_tasks = new HashSet<Board_Task>();

    public Task() {
    }

    public Task(String description) {
        this.description = description;
    }
}
