package iesrafaelalberti.apitarea.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;
@Document(collection = "pictograms")
@NoArgsConstructor @Getter @Setter
public class Task {

    @Id
    private String id;
    private String description;

    private Binary pictogram;

//    @JsonBackReference
//    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
//    private Set<Board_Task> boards_tasks = new HashSet<Board_Task>();

    public Task(String description) {
        this.description = description;

    }

}
