package com.androiddemo.mytaxi;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Results implements Parcelable {

    List<ResultItems> resultItemsList;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel in, int i) {
        in.writeList( this.resultItemsList );
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Results createFromParcel(Parcel in) {
            return new Results(in);
        }

        public Results[] newArray(int size) {
            return new Results[size];
        }
    };

    public Results(Parcel in){
        this.resultItemsList = new ArrayList<>(  );
        in.readList( this.resultItemsList, ResultItems.class.getClassLoader() );
    }

    public void setResultItemsList(List<ResultItems> itemsList) {
        this.resultItemsList = itemsList;
    }

    public List<ResultItems> getResultItemsList() {
        return resultItemsList;
    }
}
