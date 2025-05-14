package tech.learns.lionel.spiritual_health_tracker.Services;

import org.springframework.stereotype.Service;

import tech.learns.lionel.spiritual_health_tracker.Entities.Journal;
import tech.learns.lionel.spiritual_health_tracker.Repositories.JournalRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class JournalService {
    private final List<Journal> journals = new ArrayList<>();
    private final JournalRepository journalRepository;

    public JournalService(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    public Journal create(Journal journal) {
        journal.setCreatedAt(LocalDateTime.now().withNano(0));
        journal.setUpdatedAt(null);
        journals.add(journal);
        return journal;
    }

    public List<Journal> getAll() {
        return journals;
    }

    public Journal getJournalById(Long id) {
        journalRepository.findById(id).ifPresent(journals::add);
             
        return journals.stream()
                      .filter(journal -> journal.getId().equals(id))
                      .findFirst()
                      .orElse(null);
    }

    public Journal update(Long id, Journal updatedJournal) {
        Journal journalToUpdate = getJournalById(id);
        journalToUpdate.setContent(updatedJournal.getContent());
        journalToUpdate.setVerses(updatedJournal.getVerses());
        //journalToUpdate.setMember(updatedJournal.getMember());
        journalToUpdate.setCreatedAt(updatedJournal.getCreatedAt());
        journalToUpdate.setUpdatedAt(LocalDateTime.now().withNano(0));
        return journalToUpdate;
    }

    public boolean deleteJournal(Long id) {
        return journals.removeIf(journal -> journal.getId().equals(id));
    }
}