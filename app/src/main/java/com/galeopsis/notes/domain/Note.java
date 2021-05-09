package com.galeopsis.notes.domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.StringRes;

public class Note implements Parcelable {

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    @StringRes
    private final int titleRes;
    private final int description;
    private final int createDate;
    private final int noteContent;

    public Note(int titleRes, int description, int createDate, int noteContent) {
        this.titleRes = titleRes;
        this.description = description;
        this.createDate = createDate;
        this.noteContent = noteContent;
    }

    protected Note(Parcel in) {
        titleRes = in.readInt();
        description = in.readInt();
        createDate = in.readInt();
        noteContent = in.readInt();
    }

    public int getDescription() {
        return description;

    }

    public int getCreateDate() {
        return createDate;

    }

    public int getNoteContent() {
        return noteContent;
    }

    public int getTitleRes() {
        return titleRes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(titleRes);
        dest.writeInt(description);
        dest.writeInt(createDate);
        dest.writeInt(noteContent);
    }
}
