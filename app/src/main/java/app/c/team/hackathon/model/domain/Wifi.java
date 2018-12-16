package app.c.team.hackathon.model.domain;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

class Wifi implements Parcelable {
    @SerializedName("name")
    private String name;

    @SerializedName("login")
    private String login;

    @SerializedName("password")
    private String password;

    protected Wifi(Parcel in) {
        name = in.readString();
        login = in.readString();
        password = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(login);
        dest.writeString(password);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Wifi> CREATOR = new Creator<Wifi>() {
        @Override
        public Wifi createFromParcel(Parcel in) {
            return new Wifi(in);
        }

        @Override
        public Wifi[] newArray(int size) {
            return new Wifi[size];
        }
    };

    @Override
    public String toString() {
        return "Wifi{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wifi wifi = (Wifi) o;
        return Objects.equals(name, wifi.name) &&
                Objects.equals(login, wifi.login) &&
                Objects.equals(password, wifi.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, login, password);
    }

    public Wifi(String name, String login, String password) {

        this.name = name;
        this.login = login;
        this.password = password;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
