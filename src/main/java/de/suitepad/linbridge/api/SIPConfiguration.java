package de.suitepad.linbridge.api;

import android.os.Parcel;
import android.os.Parcelable;

public class SIPConfiguration implements Parcelable {

    /**
     * specify the microphone gain in dB, default is 0
     */
    private int microphoneGain;

    /**
     * specify the speaker gain in dB, default is 0
     */
    private int speakerGain;

    /**
     * enable/disable aec, default is false. AEC uses the speaker signal as a reference and tries
     * to suppress it from the  input
     */
    private boolean echoCancellation;

    /**
     * enable/disable echo limiter, if enabled microphone gain will be decreased by [microphoneDecrease] when the speaker
     * output exceeds a certain [speakerThreshold] amount. The microphone gain is then decreased for
     * [echoLimiterSustain]ms
     * <p>
     * echo limiter will be bypassed in case of double talk detection, [doubleTalkDetection]
     */
    private boolean echoLimiter;

    /**
     * linear amount of microphone gain decrease when [echoLimiter] is active
     */
    private int echoLimiterMicrophoneDecrease;

    /**
     * linear amount of speaker gain output to be reached to that [echoLimiter] decreases the microphone gain
     */
    private float echoLimiterSpeakerThreshold;

    /**
     * microphone gain decrease sustain when [echoLimiter] is active
     */
    private int echoLimiterSustain;

    /**
     * amount of micGain/speakerGain above which [echoLimiter] is automatically disabled
     */
    private float echoLimiterDoubleTalkDetection;

    /**
     * list of enabled [Codec]s,
     * empty list or null for enabling all codecs
     */
    String[] enabledCodecs;

    protected SIPConfiguration(Parcel in) {
        microphoneGain = in.readInt();
        speakerGain = in.readInt();
        echoCancellation = in.readByte() != 0;
        echoLimiter = in.readByte() != 0;
        echoLimiterMicrophoneDecrease = in.readInt();
        echoLimiterSpeakerThreshold = in.readFloat();
        echoLimiterSustain = in.readInt();
        echoLimiterDoubleTalkDetection = in.readFloat();
        enabledCodecs = in.createStringArray();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(microphoneGain);
        dest.writeInt(speakerGain);
        dest.writeByte((byte) (echoCancellation ? 1 : 0));
        dest.writeByte((byte) (echoLimiter ? 1 : 0));
        dest.writeInt(echoLimiterMicrophoneDecrease);
        dest.writeFloat(echoLimiterSpeakerThreshold);
        dest.writeInt(echoLimiterSustain);
        dest.writeFloat(echoLimiterDoubleTalkDetection);
        dest.writeStringArray(enabledCodecs);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SIPConfiguration> CREATOR = new Creator<SIPConfiguration>() {
        @Override
        public SIPConfiguration createFromParcel(Parcel in) {
            return new SIPConfiguration(in);
        }

        @Override
        public SIPConfiguration[] newArray(int size) {
            return new SIPConfiguration[size];
        }
    };

}
