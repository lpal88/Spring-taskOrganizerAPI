package iesrafaelalberti.apitarea.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Userlo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String userName;
    String password;

    @JsonBackReference
    @OneToMany(mappedBy = "userlo", cascade = CascadeType.ALL)
    private Set<Board> boards = new HashSet<>();
    public Userlo() {
    }

    public Userlo(String userName, String password) {
        this.userName = userName;
        this.password = password;


    }
}
