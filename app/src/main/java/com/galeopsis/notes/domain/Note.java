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

    public Note(int titleRes) {
        this.titleRes = titleRes;
    }

    protected Note(Parcel in) {
        titleRes = in.readInt();
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
    }
}
