package app.c.team.hackathon.model.domain;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class ResourceLink implements Parcelable {
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

    protected ResourceLink(Parcel in) {
        id = in.readInt();
        title = in.readString();
        link = in.readString();
        type = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(link);
        dest.writeInt(type);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ResourceLink> CREATOR = new Creator<ResourceLink>() {
        @Override
        public ResourceLink createFromParcel(Parcel in) {
            return new ResourceLink(in);
        }

        @Override
        public ResourceLink[] newArray(int size) {
            return new ResourceLink[size];
        }
    };

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceLink that = (ResourceLink) o;
        return id == that.id &&
                type == that.type &&
                Objects.equals(title, that.title) &&
                Objects.equals(link, that.link);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, link, type);
    }

    public ResourceLink(int id, String title, String link, int type) {

        this.id = id;
        this.title = title;
        this.link = link;
        this.type = type;
    }

    @Override
    public String toString() {
        return "ResourceLink{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", type=" + type +
                '}';
    }
}
