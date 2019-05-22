package de.suitepad.linbridge.api.core;

import android.os.Parcel;
import android.os.Parcelable;

public enum CallEndReason implements Parcelable {

    /**
      * No reason has been set by the core.
      */
    None,

    /**
      * No response received from remote.
      */
    NoResponse,

    /**
      * Authentication failed due to bad credentials or resource forbidden.
      */
    Forbidden,

    /**
      * The call has been declined.
      */
    Declined,

    /**
      * Destination of the call was not found.
      */
    NotFound,

    /**
      * The call was not answered in time (request timeout)
      */
    NotAnswered,

    /**
      * Phone line was busy.
      */
    Busy,

    /**
      * Unsupported content.
      */
    UnsupportedContent,

    /**
      * Transport error: connection failures, disconnections etc...
      */
    IOError,

    /**
      * Do not disturb reason.
      */
    DoNotDisturb,

    /**
      * Operation is unauthorized because missing credential.
      */
    Unauthorized,

    /**
      * Operation is rejected due to incompatible or unsupported media parameters.
      */
    NotAcceptable,

    /**
      * Operation could not be executed by server or remote client because it didn&#x27;t
      * have any context for it.
      */
    NoMatch,

    /**
      * Resource moved permanently.
      */
    MovedPermanently,

    /**
      * Resource no longer exists.
      */
    Gone,

    /**
      * Temporarily unavailable.
      */
    TemporarilyUnavailable,

    /**
      * Address incomplete.
      */
    AddressIncomplete,

    /**
      * Not implemented.
      */
    NotImplemented,

    /**
      * Bad gateway.
      */
    BadGateway,

    /**
      * Server timeout.
      */
    ServerTimeout,

    /**
      * Unknown reason.
      */
    Unknown;

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CallEndReason> CREATOR = new Creator<CallEndReason>() {
        @Override
        public CallEndReason createFromParcel(Parcel in) {
            return CallEndReason.valueOf(in.readString());
        }

        @Override
        public CallEndReason[] newArray(int size) {
            return new CallEndReason[size];
        }
    };
}
