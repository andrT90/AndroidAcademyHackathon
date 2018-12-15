package app.c.team.hackathon.model.domain;

import com.google.gson.annotations.SerializedName;

class Location {
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
}