package iesrafaelalberti.apitarea.Repositories;

import iesrafaelalberti.apitarea.Models.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BoardRepository extends CrudRepository<Board, Long> {
    public Board findBoardByUserlo_Id(Long id);

}
