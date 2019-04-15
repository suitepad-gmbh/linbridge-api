package de.suitepad.linbridge.api.core;

import android.os.Parcel;
import android.os.Parcelable;

public class Credentials implements Parcelable {

    String host;
    int port = 5060;
    String username;
    String password;
    String proxy;

    public Credentials(String host, int port, String username, String password, String proxy) {
        this.host = host;
        if (port != 0)
            this.port = port;
        this.username = username;
        this.password = password;
        this.proxy = proxy;
    }

    protected Credentials(Parcel in) {
        host = in.readString();
        port = in.readInt();
        username = in.readString();
        password = in.readString();
        proxy = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(host);
        dest.writeInt(port);
        dest.writeString(username);
        dest.writeString(password);
        dest.writeString(proxy);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Credentials> CREATOR = new Creator<Credentials>() {
        @Override
        public Credentials createFromParcel(Parcel in) {
            return new Credentials(in);
        }

        @Override
        public Credentials[] newArray(int size) {
            return new Credentials[size];
        }
    };
}
