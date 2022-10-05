package main;

import main.model.Case;
import main.model.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CaseController {

    @Autowired
    private CaseRepository caseRepository;

    // метод возвращающий список дел
    @GetMapping("/cases/")
    public List<Case> list() {
        Iterable<Case> caseIterable = caseRepository.findAll();
        ArrayList<Case> caseArrayList = new ArrayList<>();
        caseIterable.forEach(caseArrayList::add);
        return caseArrayList;
    }

    // метод добавления дела
    @PostMapping("/cases/")
    public int add(Case task) {
        Case newCase = caseRepository.save(task);
        return newCase.getId();
    }

    // метод получения дела по id
    @GetMapping("/cases/{id}")
    public ResponseEntity get(@PathVariable int id) {
        Optional<Case> caseOptional = caseRepository.findById(id);
        if (!caseOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(caseOptional.get(), HttpStatus.OK);
    }

    // метод обновления дела по id
    @PutMapping("/cases/{id}")
    public ResponseEntity put(@PathVariable int id, Case updatedCase) {
        Optional<Case> caseOptional = caseRepository.findById(id);
        if (!caseOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            updatedCase.setId(id);
            caseRepository.save(updatedCase);
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    // метод удаления списка дел
    @PostMapping("/cases/delete/")
    public ResponseEntity delete(Case aCase) {
        ArrayList<Case> caseArrayList = (ArrayList<Case>) caseRepository.findAll();
        if (caseArrayList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            caseRepository.deleteAll();
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    // метод удаления дела по id
    @DeleteMapping("/cases/{id}")
    public ResponseEntity deleteCase(@PathVariable int id) {
        Optional<Case> caseOptional = caseRepository.findById(id);
        if (!caseOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else  {
            caseRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }
    }
}
