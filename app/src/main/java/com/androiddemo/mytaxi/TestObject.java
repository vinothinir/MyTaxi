package com.androiddemo.mytaxi;

import android.os.Parcel;
import android.os.Parcelable;

public class TestObject implements Parcelable {

    private Results results;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeParcelable(this.results, i);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public TestObject createFromParcel(Parcel in) {
            return new TestObject(in);
        }

        public TestObject[] newArray(int size) {
            return new TestObject[size];
        }
    };

    public TestObject(Parcel in){
        this.results = in.readParcelable( Results.class.getClassLoader() );
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public Results getResults() {
        return results;
    }
}
