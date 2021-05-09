package com.galeopsis.notes.domain;

import com.galeopsis.notes.R;

import java.util.ArrayList;
import java.util.List;

public class NotesRepository {

    public List<Note> getNotes() {
        ArrayList<Note> notes = new ArrayList<>();
        notes.add(new Note(R.string.test1, R.string.firstNoteDescription, R.string.firstNoteCreated,R.string.firstNoteContent));
        notes.add(new Note(R.string.test2, R.string.secondNoteDescription, R.string.secondNoteCreated,R.string.secondNoteContent));
        notes.add(new Note(R.string.test3, R.string.thirdNoteDescription, R.string.thirdNoteCreated,R.string.thirdNoteContent));
        notes.add(new Note(R.string.test4, R.string.fourthNoteDescription, R.string.fourthNoteCreated,R.string.fourthNoteContent));
        notes.add(new Note(R.string.test5, R.string.fifthNoteDescription, R.string.fifthNoteCreated,R.string.fifthNoteContent));
        return notes;
    }
}
