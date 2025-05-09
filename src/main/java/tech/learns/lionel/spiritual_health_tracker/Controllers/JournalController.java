package tech.learns.lionel.spiritual_health_tracker.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.learns.lionel.spiritual_health_tracker.Entities.Journal;
import tech.learns.lionel.spiritual_health_tracker.Services.JournalService;

@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private final JournalService service;

    public JournalController(JournalService service) {
        this.service = service;
    }

    @PostMapping
    public Journal create(@RequestBody Journal journal) {
        return service.create(journal);
    }

    @GetMapping({"/{id}", "/{id}/"})
    public Journal getById(@PathVariable Long id) {
        return service.getJournalById(id);
    }

    @GetMapping({"","/"})
    public List<Journal> getAll() {
        return service.getAll();
    }

    @PutMapping({"/{id}", "/{id}/"})
    public Journal update(@PathVariable Long id, @RequestBody Journal journal) {
        return service.update(id, journal);
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    public Boolean delete(@PathVariable Long id) {
        return service.deleteJournal(id);
    }
}