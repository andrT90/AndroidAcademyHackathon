package app.c.team.hackathon.model.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Event {
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
}
