package iesrafaelalberti.apitarea.dto;
import iesrafaelalberti.apitarea.Models.Board;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import java.io.Serializable;
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO implements Serializable {
    private Long id;
    private String label;
    @NotNull
    private Long userlo_id;

    public BoardDTO(Board board){
        this.id = board.getId();
        this.label = board.getLabel();
        this.userlo_id = board.getUserlo().getId();
    }
}

