package de.suitepad.linbridge.api.core;

import android.os.Parcel;
import android.os.Parcelable;

public enum CallState implements Parcelable {

    /**
     * Initial state.
     */
    Idle(null, null),

    /**
     * Incoming call received.
     */
    IncomingReceived(null, null),

    /**
     * Outgoing call initialized.
     */
    OutgoingInit(null, null),

    /**
     * Outgoing call in progress.
     */
    OutgoingProgress(null, null),

    /**
     * Outgoing call ringing.
     */
    OutgoingRinging(null, null),

    /**
     * Outgoing call early media.
     */
    OutgoingEarlyMedia(null, null),

    /**
     * Connected.
     */
    Connected(null, null),

    /**
     * Streams running.
     */
    StreamsRunning(null, null),

    /**
     * Pausing.
     */
    Pausing(null, null),

    /**
     * Paused.
     */
    Paused(null, null),

    /**
     * Resuming.
     */
    Resuming(null, null),

    /**
     * Referred.
     */
    Referred(null, null),

    /**
     * Error.
     */
    Error(null, null),

    /**
     * Call end.
     */
    End(null, null),

    /**
     * Paused by remote.
     */
    PausedByRemote(null, null),

    /**
     * The call's parameters are updated for example when video is asked by remote.
     */
    UpdatedByRemote(null, null),

    /**
     * We are proposing early media to an incoming call.
     */
    IncomingEarlyMedia(null, null),

    /**
     * We have initiated a call update.
     */
    Updating(null, null),

    /**
     * The call object is now released.
     */
    Released(null, null),

    /**
     * The call is updated by remote while not yet answered (SIP UPDATE in early
     * dialog received)
     */
    EarlyUpdatedByRemote(null, null),

    /**
     * We are updating the call while not yet answered (SIP UPDATE in early dialog
     * sent)
     */
    EarlyUpdating(null, null);

    public String number;
    public String contactName;

    CallState(String number, String contactName) {
        this.number = number;
        this.contactName = contactName;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name());
        dest.writeString(number);
        dest.writeString(contactName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CallState> CREATOR = new Creator<CallState>() {
        @Override
        public CallState createFromParcel(Parcel in) {
            CallState callState = CallState.valueOf(in.readString());
            callState.number = in.readString();
            callState.contactName = in.readString();
            return callState;
        }

        @Override
        public CallState[] newArray(int size) {
            return new CallState[size];
        }
    };

}
