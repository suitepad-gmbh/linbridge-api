package de.suitepad.linbridge.api;

import android.os.Parcel;
import android.os.Parcelable;

import de.suitepad.linbridge.api.core.AudioCodec;

public class AudioConfiguration implements Parcelable {

    /**
     * specify the microphone gain in dB, default is 0
     */
    public int microphoneGain;

    /**
     * specify the speaker gain in dB, default is 0
     */
    public int speakerGain;

    /**
     * enable/disable aec, default is false. AEC uses the speaker signal as a reference and tries
     * to suppress it from the  input
     */
    public boolean echoCancellation;

    /**
     * enable/disable echo limiter, if enabled microphone gain will be decreased by [microphoneDecrease] when the speaker
     * output exceeds a certain [speakerThreshold] amount. The microphone gain is then decreased for
     * [echoLimiterSustain]ms
     * <p>
     * echo limiter will be bypassed in case of double talk detection, [doubleTalkDetection]
     */
    public boolean echoLimiter;

    /**
     * linear amount of microphone gain decrease when [echoLimiter] is active
     */
    public int echoLimiterMicrophoneDecrease;

    /**
     * linear amount of speaker gain output to be reached to that [echoLimiter] decreases the microphone gain
     */
    public float echoLimiterSpeakerThreshold;

    /**
     * microphone gain decrease sustain when [echoLimiter] is active
     */
    public int echoLimiterSustain;

    /**
     * amount of micGain/speakerGain above which [echoLimiter] is automatically disabled
     */
    public float echoLimiterDoubleTalkDetection;

    /**
     * list of enabled [Codec]s,
     * empty list or null for enabling all codecs
     */
    public AudioCodec[] enabledCodecs;

    public AudioConfiguration() {

    }

    protected AudioConfiguration(Parcel in) {
        microphoneGain = in.readInt();
        speakerGain = in.readInt();
        echoCancellation = in.readByte() != 0;
        echoLimiter = in.readByte() != 0;
        echoLimiterMicrophoneDecrease = in.readInt();
        echoLimiterSpeakerThreshold = in.readFloat();
        echoLimiterSustain = in.readInt();
        echoLimiterDoubleTalkDetection = in.readFloat();
        String[] enabledCodecNames = in.createStringArray();
        enabledCodecs = new AudioCodec[enabledCodecNames != null ? enabledCodecNames.length : 0];
        for (int i = 0; i < enabledCodecs.length; i++) {
            enabledCodecs[i] = AudioCodec.valueOf(enabledCodecNames[i]);
        }
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
        String[] codecNames = new String[enabledCodecs != null ? enabledCodecs.length : 0];
        for (int i = 0; i < codecNames.length; i++) {
            codecNames[i] = enabledCodecs[i].name();
        }
        dest.writeStringArray(codecNames);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AudioConfiguration> CREATOR = new Creator<AudioConfiguration>() {
        @Override
        public AudioConfiguration createFromParcel(Parcel in) {
            return new AudioConfiguration(in);
        }

        @Override
        public AudioConfiguration[] newArray(int size) {
            return new AudioConfiguration[size];
        }
    };

}
