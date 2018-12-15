package app.c.team.hackathon.model.domain;

import com.google.gson.annotations.SerializedName;

public class ResourceLink {
    private static final int TYPE_PRESENTATION = 0;
    private static final int TYPE_HOMEWORK = 1;

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("link")
    private String link;

    @SerializedName("type")
    private int type;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
