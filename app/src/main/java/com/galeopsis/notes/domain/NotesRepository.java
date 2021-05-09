package com.galeopsis.notes.domain;

import com.galeopsis.notes.R;

import java.util.ArrayList;
import java.util.List;

public class NotesRepository {

    public List<Note> getNotes() {
        ArrayList<Note> notes = new ArrayList<>();
        notes.add(new Note(R.string.test1));
        notes.add(new Note(R.string.test2));
        notes.add(new Note(R.string.test3));
        notes.add(new Note(R.string.test4));
        notes.add(new Note(R.string.test5));
        return notes;
    }
}
