package app.c.team.hackathon.model.domain;

import com.google.gson.annotations.SerializedName;

public class ResourceLink {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @SerializedName("title")
    private String title;
    @SerializedName("link")
    private String link;
}
