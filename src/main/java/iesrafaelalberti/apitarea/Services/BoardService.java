package iesrafaelalberti.apitarea.Services;

import iesrafaelalberti.apitarea.Models.Board;
import iesrafaelalberti.apitarea.Repositories.BoardRepository;
import iesrafaelalberti.apitarea.dto.BoardCreateDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BoardService {
    @Autowired
    BoardRepository boardRepository;
    public Board boardCreate(BoardCreateDTO newBoard) {
        return boardRepository.save(new Board(newBoard));
    }
}
