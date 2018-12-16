package app.c.team.hackathon.model.domain;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class EventTicket implements Parcelable {
    @SerializedName("id")
    private int id;

    @SerializedName("user")
    private User user;

    @SerializedName("event")
    private Event event;

    @SerializedName("is_confirmed")
    private boolean isConfirmed;

    @SerializedName("is_visited")
    private boolean isVisited;

    protected EventTicket(Parcel in) {
        id = in.readInt();
        user = in.readParcelable(User.class.getClassLoader());
        isConfirmed = in.readByte() != 0;
        isVisited = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeParcelable(user, flags);
        dest.writeByte((byte) (isConfirmed ? 1 : 0));
        dest.writeByte((byte) (isVisited ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<EventTicket> CREATOR = new Creator<EventTicket>() {
        @Override
        public EventTicket createFromParcel(Parcel in) {
            return new EventTicket(in);
        }

        @Override
        public EventTicket[] newArray(int size) {
            return new EventTicket[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }


    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public EventTicket(int id, User user, Event event, boolean is_confirmed, boolean is_visited) {

        this.id = id;
        this.user = user;
        this.event = event;
        this.isConfirmed = is_confirmed;
        this.isVisited = is_visited;
    }

}