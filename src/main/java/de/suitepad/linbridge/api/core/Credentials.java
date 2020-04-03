package de.suitepad.linbridge.api.core;

import android.os.Parcel;
import android.os.Parcelable;

public class Credentials implements Parcelable {

    private String host;
    private int port = 5060;
    private String username;
    private String password;
    private String proxy;
    private String authId;

    public Credentials(String host, int port, String username, String password, String proxy,
                       String authId) {
        this.host = host;
        if (port != 0)
            this.port = port;
        this.username = username;
        this.password = password;
        this.proxy = proxy;
        this.authId = authId;
    }

    protected Credentials(Parcel in) {
        host = in.readString();
        port = in.readInt();
        username = in.readString();
        password = in.readString();
        proxy = in.readString();
        authId = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(host);
        dest.writeInt(port);
        dest.writeString(username);
        dest.writeString(password);
        dest.writeString(proxy);
        dest.writeString(authId);
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

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

}
