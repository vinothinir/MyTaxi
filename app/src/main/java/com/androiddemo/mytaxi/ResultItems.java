package com.androiddemo.mytaxi;

import android.os.Parcel;
import android.os.Parcelable;

public class ResultItems implements Parcelable {
    private String title;
    private String first;
    private String last;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel in, int i) {
        this.title = in.readString();
        this.first = in.readString();
        this.last =  in.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public ResultItems createFromParcel(Parcel in) {
            return new ResultItems(in);
        }

        public ResultItems[] newArray(int size) {
            return new ResultItems[size];
        }
    };

    public ResultItems(Parcel in){
        this.title = in.readString();
        this.first = in.readString();
        this.last =  in.readString();
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
