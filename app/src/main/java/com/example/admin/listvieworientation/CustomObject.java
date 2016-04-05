package com.example.admin.listvieworientation;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by admin on 4/5/2016.
 */
public class CustomObject implements Parcelable {
    private int listSize;
    private String key;


    public CustomObject(){

    }

    public int getlistSize() {
        return listSize;
    }

    public void setlistSize(int listSize) {
        this.listSize = listSize;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    protected CustomObject(Parcel in) {
        listSize = in.readInt();
        key = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(listSize);
        dest.writeString(key);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<CustomObject> CREATOR = new Parcelable.Creator<CustomObject>() {
        @Override
        public CustomObject createFromParcel(Parcel in) {
            return new CustomObject(in);
        }

        @Override
        public CustomObject[] newArray(int size) {
            return new CustomObject[size];
        }
    };
}
