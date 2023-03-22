package go.it.java_dev_spring.service;

import go.it.java_dev_spring.entity.Note;
import go.it.java_dev_spring.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final Random random = new Random();

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note add(Note note) {
        long id = random.nextLong();
        note.setId(id);
        noteRepository.save(note);
        return note;
    }

    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    public void update(Note note) {
        long id = note.getId();
        if (!noteRepository.existsById(id)) {
            throw new IllegalArgumentException("Note with id=" + id + " does not exist");
        }
        noteRepository.save(note);
    }

    public Note getById(long id) {
        Note note = noteRepository.getReferenceById(id);
        if (note == null) {
            throw new IllegalArgumentException("Note with id=" + id + " does not exist");
        }
        return note;
    }

}
