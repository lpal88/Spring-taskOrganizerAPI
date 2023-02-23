package iesrafaelalberti.apitarea.Controllers;

import iesrafaelalberti.apitarea.Models.Userlo;
import iesrafaelalberti.apitarea.Repositories.UserloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserloController {
    @Autowired
    private UserloRepository userloRepository;
    @GetMapping(value = "/userslo")
    public ResponseEntity<Object> userloList() {
        return new ResponseEntity<>(userloRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/userslo/{id}")
    public ResponseEntity<Object> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userloRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/userslo/create")
    public ResponseEntity<Object> create(@RequestBody Userlo userlo) {
        userloRepository.save(userlo);
        return new ResponseEntity<>(userlo, HttpStatus.OK);
    }

    @RequestMapping(value="/userslo/{id}", method={RequestMethod.PUT, RequestMethod.GET})
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Userlo userlo) {
        Optional<Userlo> oldUserlo = userloRepository.findById(id);
        if(oldUserlo.isPresent()) {
            userlo.setId(id);
            userloRepository.save(userlo);
            return new ResponseEntity<>(userlo, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/userslo/{id}", method={RequestMethod.DELETE, RequestMethod.GET})
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        Optional<Userlo> userlo =  userloRepository.findById(id);
        userlo.ifPresent(value ->  userloRepository.delete(value));
        return new ResponseEntity<>(userlo.isPresent(), HttpStatus.OK);
    }
}
