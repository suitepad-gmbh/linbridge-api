package de.suitepad.linbridge.api.core;

import android.os.Parcel;
import android.os.Parcelable;

public enum CallState implements Parcelable {

    /**
     * Initial state.
     */
    Idle,

    /**
     * Incoming call received.
     */
    IncomingReceived,

    /**
     * Outgoing call initialized.
     */
    OutgoingInit,

    /**
     * Outgoing call in progress.
     */
    OutgoingProgress,

    /**
     * Outgoing call ringing.
     */
    OutgoingRinging,

    /**
     * Outgoing call early media.
     */
    OutgoingEarlyMedia,

    /**
     * Connected.
     */
    Connected,

    /**
     * Streams running.
     */
    StreamsRunning,

    /**
     * Pausing.
     */
    Pausing,

    /**
     * Paused.
     */
    Paused,

    /**
     * Resuming.
     */
    Resuming,

    /**
     * Referred.
     */
    Referred,

    /**
     * Error.
     */
    Error,

    /**
     * Call end.
     */
    End,

    /**
     * Paused by remote.
     */
    PausedByRemote,

    /**
     * The call's parameters are updated for example when video is asked by remote.
     */
    UpdatedByRemote,

    /**
     * We are proposing early media to an incoming call.
     */
    IncomingEarlyMedia,

    /**
     * We have initiated a call update.
     */
    Updating,

    /**
     * The call object is now released.
     */
    Released,

    /**
     * The call is updated by remote while not yet answered (SIP UPDATE in early
     * dialog received)
     */
    EarlyUpdatedByRemote,

    /**
     * We are updating the call while not yet answered (SIP UPDATE in early dialog
     * sent)
     */
    EarlyUpdating;

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CallState> CREATOR = new Creator<CallState>() {
        @Override
        public CallState createFromParcel(Parcel in) {
            return CallState.valueOf(in.readString());
        }

        @Override
        public CallState[] newArray(int size) {
            return new CallState[size];
        }
    };

}
