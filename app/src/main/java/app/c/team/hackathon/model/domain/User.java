package app.c.team.hackathon.model.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class User {
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
    @SerializedName("homeWorks")
    private List<HomeWorks> homeWorks;
}