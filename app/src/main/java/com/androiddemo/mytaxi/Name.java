package com.androiddemo.mytaxi;

import android.os.Parcel;
import android.os.Parcelable;

public class Name implements Parcelable {

    private String title;
    private String first;
    private String last;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString( this.title );
        dest.writeString( this.first );
        dest.writeString( this.last );
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Name createFromParcel(Parcel in) {
            return new Name( in );
        }

        public Name[] newArray(int size) {
            return new Name[size];
        }
    };

    public Name(String title, String first, String last) {
        this.title = title;
        this.first = first;
        this.last = last;
    }

    public Name(Parcel in) {
        this.title = in.readString();
        this.first = in.readString();
        this.last = in.readString();
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getFirst() {
        return first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getLast() {
        return last;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
