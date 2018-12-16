package app.c.team.hackathon.presentation.mentors;

import app.c.team.hackathon.model.domain.User;

public class MentorItem {
    private String imageUrl;
    private String name;
    private String job;

    public MentorItem(User user) {
        this.imageUrl = user.getPhoto();
        this.name = user.getName() + " " + user.getSurname();
        this.job = user.getCurrent_job();
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getJob() {
        return job;
    }
}
