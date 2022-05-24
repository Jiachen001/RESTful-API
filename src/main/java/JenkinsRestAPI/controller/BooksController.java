package JenkinsRestAPI.controller;

import JenkinsRestAPI.Exception.ResourceNotFoundException;
import JenkinsRestAPI.dao.GoodRepository;
import JenkinsRestAPI.entity.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BooksController {
    @Autowired
    private GoodRepository booksRepository;

    @GetMapping("/good")
    public List<Good> getAllNotes() {
        return booksRepository.findAll();
    }

    @GetMapping("/good/{id}")
    public Good getAllNotes(@PathVariable(value = "id") Integer bookId) {
        Good book = booksRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", bookId));
        return book;
    }

    @PostMapping("/good")
    public Good createBook(@RequestBody Good books){
        return booksRepository.save(books);
    }

    @PutMapping("/good/{id}")
    public Good updateNote(@PathVariable(value = "id") Integer bookId,
                            @RequestBody Good bookDetails) {

        Good good = booksRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", bookId));

        good.setGoodName(bookDetails.getGoodName());
        good.setGoodPrice(bookDetails.getGoodPrice());
        good.setGoodDescription(bookDetails.getGoodDescription());

        Good updatedNote = booksRepository.save(good);
        return updatedNote;
    }

    @DeleteMapping("/good/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Integer bookId) {
        Good note = booksRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", bookId));

        booksRepository.delete(note);
        return ResponseEntity.ok().build();
    }
}
