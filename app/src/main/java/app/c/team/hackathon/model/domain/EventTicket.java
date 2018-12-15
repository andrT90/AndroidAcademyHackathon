package app.c.team.hackathon.model.domain;

import com.google.gson.annotations.SerializedName;

class EventTicket {
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
}