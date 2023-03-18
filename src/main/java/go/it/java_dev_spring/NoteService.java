package go.it.java_dev_spring;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {

    private Map<Long, Note> notes = new HashMap<>();
    private Random random = new Random();

    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    public Note add(Note note) {
        long id = random.nextLong();
        note.setId(id);
        notes.put(id, note);
        return note;
    }

    public void deleteById(long id) {
        if (!notes.containsKey(id)) {
            throw new IllegalArgumentException("Note with id=" + id + " does not exist");
        }
        notes.remove(id);
    }

    public void update(Note note) {
        long id = note.getId();
        if (!notes.containsKey(id)) {
            throw new IllegalArgumentException("Note with id=" + id + " does not exist");
        }
        notes.put(id, note);
    }

    public Note getById(long id) {
        Note note = notes.get(id);
        if (note == null) {
            throw new IllegalArgumentException("Note with id=" + id + " does not exist");
        }
        return note;
    }

}
