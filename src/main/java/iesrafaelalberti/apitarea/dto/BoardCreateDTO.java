package iesrafaelalberti.apitarea.dto;

import lombok.*;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BoardCreateDTO implements Serializable {
    private String label;

}
