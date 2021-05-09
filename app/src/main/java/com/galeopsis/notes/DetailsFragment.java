package com.galeopsis.notes;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.galeopsis.notes.domain.Note;

import java.util.Calendar;

public class DetailsFragment extends Fragment implements Observer, DatePicker.OnDateChangedListener {
    private static final String ARG_NOTE = "ARG_NOTE";
    private TextView title;
    private TextView description;
    private TextView createDate;
    private TextView content;
    private Publisher publisher;

    public static DetailsFragment newInstance(Note note) {
        DetailsFragment fragment = new DetailsFragment();

        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_NOTE, note);

        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof PublisherHolder) {
            publisher = ((PublisherHolder) context).getPublisher();
            publisher.addObserver(this);
        }
    }

    @Override
    public void onDetach() {
        if (publisher != null) {
            publisher.removeObserver(this);
        }
        super.onDetach();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        title = view.findViewById(R.id.title);
        description = view.findViewById(R.id.description);
        createDate = view.findViewById(R.id.createDate);
        content = view.findViewById(R.id.content);

        Note note = getArguments().getParcelable(ARG_NOTE);

        title.setText(note.getTitleRes());
        description.setText(note.getDescription());
        createDate.setText(note.getCreateDate());
        content.setText(note.getNoteContent());

        view.findViewById(R.id.setDateBtn).setOnClickListener(v -> setDate());
        // Set the date to now
        Calendar calendar = Calendar.getInstance();
        DatePicker datePicker;
        datePicker = view.findViewById(R.id.datePicker);
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), this);

    }

    @Override
    public void updateNote(Note note) {

        title.setText(note.getTitleRes());
        content.setText(note.getNoteContent());

    }

    private void setDate() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        createDate.setText(new StringBuilder()
                .append(day).append(".").append(month + 1).append(".")
                .append(year));
    }

    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

    }
}
