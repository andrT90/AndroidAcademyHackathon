package app.c.team.hackathon.model.domain;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Location implements Parcelable {
    @SerializedName("title")
    private String title;

    @SerializedName("logo")
    private String logo;

    @SerializedName("lat")
    private double latitude;

    @SerializedName("long")
    private double longitude;

    @SerializedName("description")
    private String description;

    @SerializedName("wifi")
    private Wifi wifi;

    protected Location(Parcel in) {
        title = in.readString();
        logo = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
        description = in.readString();
        wifi = in.readParcelable(Wifi.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(logo);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
        dest.writeString(description);
        dest.writeParcelable(wifi, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Wifi getWifi() {
        return wifi;
    }

    public void setWifi(Wifi wifi) {
        this.wifi = wifi;
    }

    @Override
    public String toString() {
        return "Location{" +
                "title='" + title + '\'' +
                ", logo='" + logo + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", description='" + description + '\'' +
                ", wifi=" + wifi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Double.compare(location.latitude, latitude) == 0 &&
                Double.compare(location.longitude, longitude) == 0 &&
                Objects.equals(title, location.title) &&
                Objects.equals(logo, location.logo) &&
                Objects.equals(description, location.description) &&
                Objects.equals(wifi, location.wifi);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, logo, latitude, longitude, description, wifi);
    }

    public Location(String title, String logo, double latitude, double longitude, String description, Wifi wifi) {

        this.title = title;
        this.logo = logo;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.wifi = wifi;
    }

}