package app.c.team.hackathon.model.domain;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

class User implements Parcelable {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("surname")
    private String surname;
    @SerializedName("phone")
    private String phone;
    @SerializedName("email")
    private String email;
    @SerializedName("current_job")
    private String current_job;
    @SerializedName("about")
    private String about;
    @SerializedName("photo")
    private String photo;
    @SerializedName("is_mentor")
    private boolean is_mentor;

    protected User(Parcel in) {
        id = in.readInt();
        name = in.readString();
        surname = in.readString();
        phone = in.readString();
        email = in.readString();
        current_job = in.readString();
        about = in.readString();
        photo = in.readString();
        is_mentor = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(surname);
        dest.writeString(phone);
        dest.writeString(email);
        dest.writeString(current_job);
        dest.writeString(about);
        dest.writeString(photo);
        dest.writeByte((byte) (is_mentor ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                is_mentor == user.is_mentor &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(email, user.email) &&
                Objects.equals(current_job, user.current_job) &&
                Objects.equals(about, user.about) &&
                Objects.equals(photo, user.photo) &&
                Objects.equals(homeWorks, user.homeWorks);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, surname, phone, email, current_job, about, photo, is_mentor, homeWorks);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", current_job='" + current_job + '\'' +
                ", about='" + about + '\'' +
                ", photo='" + photo + '\'' +
                ", is_mentor=" + is_mentor +
                ", homeWorks=" + homeWorks +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrent_job() {
        return current_job;
    }

    public void setCurrent_job(String current_job) {
        this.current_job = current_job;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isIs_mentor() {
        return is_mentor;
    }

    public void setIs_mentor(boolean is_mentor) {
        this.is_mentor = is_mentor;
    }

    public List<HomeWorks> getHomeWorks() {
        return homeWorks;
    }

    public void setHomeWorks(List<HomeWorks> homeWorks) {
        this.homeWorks = homeWorks;
    }

    public User(int id, String name, String surname, String phone, String email, String current_job, String about, String photo, boolean is_mentor, List<HomeWorks> homeWorks) {

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.current_job = current_job;
        this.about = about;
        this.photo = photo;
        this.is_mentor = is_mentor;
        this.homeWorks = homeWorks;
    }

    @SerializedName("homeWorks")
    private List<HomeWorks> homeWorks;

}