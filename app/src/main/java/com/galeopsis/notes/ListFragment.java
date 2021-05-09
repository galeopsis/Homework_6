package com.galeopsis.notes;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.galeopsis.notes.domain.Note;
import com.galeopsis.notes.domain.NotesRepository;

import java.util.List;

public class ListFragment extends Fragment {
    private OnNoteClicked onNoteClicked;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof OnNoteClicked) {
            onNoteClicked = (OnNoteClicked) context;
        }
    }

    @Override
    public void onDetach() {
        onNoteClicked = null;
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Note> notes = new NotesRepository().getNotes();

        LinearLayout notesList = view.findViewById(R.id.notes_list);


        for (Note note : notes) {

            View noteView = LayoutInflater.from(requireContext()).inflate(R.layout.item_note, notesList, false);

            noteView.setOnClickListener(v -> openNoteDetail(note));

            TextView title = noteView.findViewById(R.id.note_name);
            title.setText(note.getTitleRes());

            notesList.addView(noteView);

        }
    }


    private void openNoteDetail(Note note) {
        if (getActivity() instanceof PublisherHolder) {
            PublisherHolder holder = (PublisherHolder) getActivity();

            holder.getPublisher().notify(note);
        }

        if (onNoteClicked != null) {
            onNoteClicked.onNoteClicked(note);
        }
    }

    public interface OnNoteClicked {
        void onNoteClicked(Note note);
    }

}