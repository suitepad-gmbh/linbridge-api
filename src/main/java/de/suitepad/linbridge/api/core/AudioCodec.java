package de.suitepad.linbridge.api.core;

import android.os.Parcel;
import android.os.Parcelable;

public enum AudioCodec implements Parcelable {
    PCMA("pcma", 8000),
    PCMU("pcmu", 8000),
    SPEEX_32K("speex", 32000),
    SPEEX_16K("speex", 16000),
    SPEEX_8K("speex", 8000),
    OPUS("opus", 48000),
    G722("g722", 8000);

    private String mimeType;
    private int rate;

    public static AudioCodec getAudioCodecByMimeAndRate(String mimeType, int rate) {
        for (AudioCodec value : values()) {
            if (value.mimeType.equalsIgnoreCase(mimeType) && value.rate == rate) {
                return value;
            }
        }
        return null;
    }

    AudioCodec(String mimeType, int rate) {
        this.mimeType = mimeType;
        this.rate = rate;
    }

    public static final Creator<AudioCodec> CREATOR = new Creator<AudioCodec>() {
        @Override
        public AudioCodec createFromParcel(Parcel in) {
            return valueOf(in.readString());
        }

        @Override
        public AudioCodec[] newArray(int size) {
            return new AudioCodec[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name());
    }

    public String getMimeType() {
        return mimeType;
    }

    public int getRate() {
        return rate;
    }

}
