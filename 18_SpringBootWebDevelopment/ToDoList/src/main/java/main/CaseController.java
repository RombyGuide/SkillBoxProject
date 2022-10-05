package main;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.model.Case;

import java.util.List;

@RestController
public class TaskController {

    // метод возвращающий список дел
    @GetMapping("/cases/")
    public List<Case> list() {
        return Storage.getAllCase();
    }

    // метод добавления дела
    @PostMapping("/cases/")
    public int add(Case task) {
        return Storage.addCase(task);
    }

    // метод получения дела по id
    @GetMapping("/cases/{id}")
    public ResponseEntity get(@PathVariable int id) {
        Case aCase = Storage.getCase(id);
        if (aCase == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(aCase, HttpStatus.OK);
    }

    // метод обновления дела по id
    @PutMapping("/cases/{id}")
    public ResponseEntity put(@PathVariable int id, Case updatedCase) {
        Case aCase = Storage.getCase(id);
        if (aCase == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            Storage.updateCase(id, updatedCase);
            return new ResponseEntity(aCase, HttpStatus.OK);
        }
    }

    // метод удаления списка дел
    @PostMapping("/cases/delete/")
    public ResponseEntity delete(Case aCase) {
        if (aCase == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            Storage.deleteCases();
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }

    // метод удаления дела по id
    @DeleteMapping("/cases/{id}")
    public ResponseEntity deleteCase(@PathVariable int id) {
        Case aCase = Storage.getCase(id);
        if (aCase == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else  {
            Storage.deleteCase(id);
            return new ResponseEntity(aCase, HttpStatus.OK);
        }
    }
}
