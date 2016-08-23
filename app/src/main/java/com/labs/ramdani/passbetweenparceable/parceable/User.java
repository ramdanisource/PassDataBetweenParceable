package com.labs.ramdani.passbetweenparceable.parceable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ramdani on 8/23/16.
 */
public class User implements Parcelable {

    private String mName;

    private User(Parcel in) {
        mName = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public void setmName(String mName) {
        this.mName = mName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getmName() {
        return mName;
    }

    public User(String mName) {
        super();
        this.mName = mName;
    }

    public User(){}

    private  void readFromParcel(Parcel source) {
        mName = source.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
    }
}
