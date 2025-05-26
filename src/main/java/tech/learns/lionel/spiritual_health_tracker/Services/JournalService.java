package tech.learns.lionel.spiritual_health_tracker.Services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import tech.learns.lionel.spiritual_health_tracker.Entities.Journal;
import tech.learns.lionel.spiritual_health_tracker.Repositories.JournalRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JournalService {
    private final JournalRepository journalRepository;

    public JournalService(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    //todo: for post, put and delete endpoints, add authentication so that only authenticated users can create, update or delete journals.
    public Journal create(Journal journal) {
        try {
            journal.setCreatedAt(LocalDateTime.now().withNano(0));
            journal.setUpdatedAt(null);
            return journalRepository.save(journal);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to create journal");
        }
    }

    public List<Journal> getAll() {
        try {
            return journalRepository.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to fetch journals");
        }
    }

    public Journal getJournalById(Long id) {
        return journalRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Journal not found with ID: " + id));
    }

    public Journal update(Long id, Journal updatedJournal) {
        try {
            Journal journal = getJournalById(id);
            journal.setContent(updatedJournal.getContent());
            journal.setVerses(updatedJournal.getVerses());
            journal.setCreatedAt(updatedJournal.getCreatedAt());
            journal.setUpdatedAt(LocalDateTime.now().withNano(0));
            return journalRepository.save(journal);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Journal not found with ID: " + id);
        }
    }

    public boolean deleteJournal(Long id) {
        try {
            journalRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Journal not found with ID: " + id);
        }
    }
}