package iesrafaelalberti.apitarea.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Entity @Getter @Setter
public class Board_Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn()
    private Board board;
    @ManyToOne
    @JoinColumn()
    private Task task;

    public Board_Task() {
    }
    public Board_Task(Board board, Task task) {
        this.board = board;
        this.task = task;
    }

}
