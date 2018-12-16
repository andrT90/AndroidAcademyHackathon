package app.c.team.hackathon.presentation.links;

import app.c.team.hackathon.model.domain.ResourceLink;

public class EventLinkItem {
    private String title;
    private String link;

    public EventLinkItem(ResourceLink resourceLink) {
        this.title = resourceLink.getTitle();
        this.link = resourceLink.getLink();
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }
}
