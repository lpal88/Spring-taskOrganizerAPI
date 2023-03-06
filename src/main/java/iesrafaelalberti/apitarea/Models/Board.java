package iesrafaelalberti.apitarea.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import iesrafaelalberti.apitarea.dto.BoardCreateDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity @Getter @Setter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String label;

    @ManyToOne
    @JoinColumn
    private Userlo userlo;

    @JsonBackReference
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private Set<Board_Task> boards_tasks = new HashSet<Board_Task>();

    public Board() {
    }

    public Board(String label, Userlo userlo) {
        this.label = label;
        this.userlo = userlo;
    }
    public Board(BoardCreateDTO newBoard) {
        this.label = newBoard.getLabel();
    }
}
