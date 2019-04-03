package de.suitepad.linbridge.api.core;

import android.os.Parcel;
import android.os.Parcelable;

public enum CallError implements Parcelable {

    NotAuthenticated,

    NetworkUnreachable,

    NoCallAvailable,

    AlreadyInCall;

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CallError> CREATOR = new Creator<CallError>() {
        @Override
        public CallError createFromParcel(Parcel in) {
            return CallError.valueOf(in.readString());
        }

        @Override
        public CallError[] newArray(int size) {
            return new CallError[size];
        }
    };
}
