package app.c.team.hackathon.model.domain;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class EventTicket implements Parcelable {
    @SerializedName("id")
    private int id;

    @SerializedName("user")
    private User user;

    @SerializedName("event")
    private Event event;

    @SerializedName("is_confirmed")
    private boolean is_confirmed;

    @SerializedName("is_visited")
    private boolean is_visited;

    protected EventTicket(Parcel in) {
        id = in.readInt();
        user = in.readParcelable(User.class.getClassLoader());
        is_confirmed = in.readByte() != 0;
        is_visited = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeParcelable(user, flags);
        dest.writeByte((byte) (is_confirmed ? 1 : 0));
        dest.writeByte((byte) (is_visited ? 1 : 0));
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

    public boolean isIs_confirmed() {
        return is_confirmed;
    }

    public void setIs_confirmed(boolean is_confirmed) {
        this.is_confirmed = is_confirmed;
    }

    public boolean isIs_visited() {
        return is_visited;
    }

    public void setIs_visited(boolean is_visited) {
        this.is_visited = is_visited;
    }

    @Override
    public String toString() {
        return "EventTicket{" +
                "id=" + id +
                ", user=" + user +
                ", event=" + event +
                ", is_confirmed=" + is_confirmed +
                ", is_visited=" + is_visited +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventTicket that = (EventTicket) o;
        return id == that.id &&
                is_confirmed == that.is_confirmed &&
                is_visited == that.is_visited &&
                Objects.equals(user, that.user) &&
                Objects.equals(event, that.event);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, user, event, is_confirmed, is_visited);
    }

    public EventTicket(int id, User user, Event event, boolean is_confirmed, boolean is_visited) {

        this.id = id;
        this.user = user;
        this.event = event;
        this.is_confirmed = is_confirmed;
        this.is_visited = is_visited;
    }

}