package iesrafaelalberti.apitarea.Controllers;

import iesrafaelalberti.apitarea.Models.Board;
import iesrafaelalberti.apitarea.Repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BoardController {
    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/boards")
    public ResponseEntity<Object> boardList() {
        return new ResponseEntity<>(boardRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/boards/{id}")
    public ResponseEntity<Object> boardShow(@PathVariable("id") Long id) {
        return new ResponseEntity<>(boardRepository.findById(id), HttpStatus.OK);
    }
// PREGUNTAR A JAVI POR EL RESULTADO EN INSOMNIA: NO SE PUEDE ASIGNAR UN USUARIO
    @PostMapping("/boards/create")
    public ResponseEntity<Object> boardCreate(@RequestBody Board board) {
        boardRepository.save(board);
        return new ResponseEntity<>(board, HttpStatus.CREATED);
    }
//    @PostMapping("/boards/create/{id}")
//    public ResponseEntity<Object> boardCreate(@RequestBody Board board, @PathVariable("id") Long id) {
//        Optional<Board> user =  boardRepository.findById(id);
//        boardRepository.save(board);
//        return new ResponseEntity<>(board, HttpStatus.CREATED);
//    }

    @RequestMapping(value="/boards/{id}", method={RequestMethod.PUT, RequestMethod.GET})
    public ResponseEntity<Object> boardUpdate(@PathVariable("id") Long id, @RequestBody Board board) {
        Optional<Board> oldBoard = boardRepository.findById(id);
        if(oldBoard.isPresent()) {
            board.setId(id);
            boardRepository.save(board);
            return new ResponseEntity<>(board, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/boards/{id}", method={RequestMethod.DELETE, RequestMethod.GET})
    public ResponseEntity<Object> boardDelete(@PathVariable("id") Long id) {
        Optional<Board> board =  boardRepository.findById(id);
        board.ifPresent(value ->  boardRepository.delete(value));
        return new ResponseEntity<>(board.isPresent(), HttpStatus.OK);
    }
}
