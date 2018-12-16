package app.c.team.hackathon.model.domain;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class Event implements Parcelable {
    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("number")
    private int number;

    @SerializedName("mentor")
    private User mentor;

    @SerializedName("startDate")
    private int startDate;

    @SerializedName("endDate")
    private int endDate;

    @SerializedName("description")
    private String description;

    @SerializedName("resources_links")
    private List<ResourceLink> resources_links;

    @SerializedName("location")
    private Location location;

    @SerializedName("notes")
    private List<String> notes;

    @SerializedName("ticket")
    private EventTicket eventTicket;

    protected Event(Parcel in) {
        id = in.readInt();
        title = in.readString();
        number = in.readInt();
        mentor = in.readParcelable(User.class.getClassLoader());
        startDate = in.readInt();
        endDate = in.readInt();
        description = in.readString();
        resources_links = in.createTypedArrayList(ResourceLink.CREATOR);
        location = in.readParcelable(Location.class.getClassLoader());
        notes = in.createStringArrayList();
        eventTicket = in.readParcelable(EventTicket.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeInt(number);
        dest.writeParcelable(mentor, flags);
        dest.writeInt(startDate);
        dest.writeInt(endDate);
        dest.writeString(description);
        dest.writeTypedList(resources_links);
        dest.writeParcelable(location, flags);
        dest.writeStringList(notes);
        dest.writeParcelable(eventTicket, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id &&
                number == event.number &&
                startDate == event.startDate &&
                endDate == event.endDate &&
                Objects.equals(title, event.title) &&
                Objects.equals(mentor, event.mentor) &&
                Objects.equals(description, event.description) &&
                Objects.equals(resources_links, event.resources_links) &&
                Objects.equals(location, event.location) &&
                Objects.equals(notes, event.notes);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, number, mentor, startDate, endDate, description, resources_links, location, notes);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", number=" + number +
                ", mentor=" + mentor +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                ", resources_links=" + resources_links +
                ", location=" + location +
                ", notes=" + notes +
                '}';
    }

    public Event(int id, String title, int number, User mentor, int startDate, int endDate, String description, List<ResourceLink> resources_links, Location location, List<String> notes) {
        this.id = id;
        this.title = title;
        this.number = number;
        this.mentor = mentor;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.resources_links = resources_links;
        this.location = location;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public User getMentor() {
        return mentor;
    }

    public void setMentor(User mentor) {
        this.mentor = mentor;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ResourceLink> getResources_links() {
        return resources_links;
    }

    public void setResources_links(List<ResourceLink> resources_links) {
        this.resources_links = resources_links;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

    public EventTicket getEventTicket() {
        return eventTicket;
    }

    public void setEventTicket(EventTicket eventTicket) {
        this.eventTicket = eventTicket;
    }

    public boolean isRegistered() {
        return eventTicket != null;
    }

    public boolean isVisited() {
        return eventTicket != null && eventTicket.isVisited();
    }

}
