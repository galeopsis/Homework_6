package com.galeopsis.notes;

import com.galeopsis.notes.domain.Note;

public interface Observer {

    void updateNote(Note note);

}
