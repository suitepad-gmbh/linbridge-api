package de.suitepad.linbridge.api.core;

import android.os.Parcel;
import android.os.Parcelable;

public enum AuthenticationState implements Parcelable {

    /**
     * Registration is in progress.
     */
    Progress,

    /**
     * Registration is successful.
     */
    Ok,

    /**
     * Unregistration succeeded.
     */
    Cleared,

    /**
     * Registration failed.
     */
    Failed;

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AuthenticationState> CREATOR = new Creator<AuthenticationState>() {
        @Override
        public AuthenticationState createFromParcel(Parcel in) {
            return AuthenticationState.valueOf(in.readString());
        }

        @Override
        public AuthenticationState[] newArray(int size) {
            return new AuthenticationState[size];
        }
    };
}
